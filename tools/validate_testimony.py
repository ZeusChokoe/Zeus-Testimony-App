#!/usr/bin/env python3
"""Validate app/src/main/assets/testimony.txt and report which images are still missing.

Mirrors the rules of TestimonyParser.kt so content errors are caught before building.
Usage: python3 tools/validate_testimony.py
"""
import re
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
TEXT = ROOT / "app/src/main/assets/testimony.txt"
IMAGES = ROOT / "app/src/main/assets/images"
SAFE_IMAGE = re.compile(r"^[A-Za-z0-9_\-]+(/[A-Za-z0-9_\-]+)*\.(webp|png|jpg|jpeg)$")
MAX_IMAGE_BYTES = 360 * 1024


STOP = set("the a an of and to in is was were his her its it that this for on by with as at from be he she "
           "they their are not but or which who into than so".split())


def repetition_errors(threshold: float = 0.45) -> list:
    """Flag sentences in different chapters that share most of their words (Jaccard >= threshold)."""
    items, chapter = [], None
    for line in TEXT.read_text(encoding="utf-8").splitlines():
        line = line.strip()
        if line.startswith("@chapter "):
            chapter = line[9:]
        elif chapter and line and not line.startswith(("@", "#")):
            words = {w for w in re.findall(r"[a-z0-9']+", line.lstrip("> ").lower()) if w not in STOP and len(w) > 2}
            if len(words) >= 5:
                items.append((chapter, line, words))
    found = []
    for i, (ca, la, wa) in enumerate(items):
        for cb, lb, wb in items[i + 1:]:
            if ca != cb and len(wa & wb) / len(wa | wb) >= threshold:
                found.append(f"repeated sentence in {ca!r} and {cb!r}: {la[:70]!r} / {lb[:70]!r}")
    return found


def main() -> int:
    errors, volumes = [], []
    for n, raw in enumerate(TEXT.read_text(encoding="utf-8").splitlines(), 1):
        line = raw.strip()
        if not line or line.startswith("#"):
            continue
        vol = volumes[-1] if volumes else None
        ch = vol["chapters"][-1] if vol and vol["chapters"] else None
        if line.startswith("@"):
            key, _, value = line[1:].partition(" ")
            value = value.strip()
            if not value:
                errors.append(f"line {n}: @{key} needs a value")
            elif key == "volume":
                volumes.append({"title": value, "summary": "", "image": None, "chapters": []})
            elif vol is None:
                errors.append(f"line {n}: @{key} before any @volume")
            elif key in ("subtitle", "summary", "seal"):
                vol[key] = value
            elif key == "chapter":
                vol["chapters"].append({"title": value, "image": None, "epigraph": None, "verses": 0})
            elif key == "epigraph":
                if ch is None:
                    errors.append(f"line {n}: @epigraph must follow a @chapter")
                else:
                    ch["epigraph"] = value
            elif key == "image":
                if not SAFE_IMAGE.match(value):
                    errors.append(f"line {n}: unsafe image name {value!r}")
                (ch or vol)["image"] = value
            else:
                errors.append(f"line {n}: unknown directive @{key}")
        elif line.startswith(">"):
            if not ch or ch["verses"] == 0:
                errors.append(f"line {n}: commentary before any verse")
        elif ch is None:
            errors.append(f"line {n}: verse before any @chapter")
        else:
            ch["verses"] += 1

    wanted = ["hero.webp"]
    for v in volumes:
        if not v.get("seal"):
            errors.append(f"volume {v['title']!r}: missing @seal")
        if not v["summary"]:
            errors.append(f"volume {v['title']!r}: missing @summary")
        if len(v["chapters"]) < 4:
            errors.append(f"volume {v['title']!r}: fewer than 4 chapters")
        wanted += [v["image"]] + [c["image"] for c in v["chapters"]]
        for c in v["chapters"]:
            if not c["epigraph"]:
                errors.append(f"chapter {c['title']!r}: missing @epigraph")
            if c["verses"] < 7:
                errors.append(f"chapter {c['title']!r}: fewer than 7 verses")

    chapters = sum(len(v["chapters"]) for v in volumes)
    verses = sum(c["verses"] for v in volumes for c in v["chapters"])
    print(f"{len(volumes)} volumes, {chapters} chapters, {verses} verses")

    missing = [w for w in wanted if w and not (IMAGES / w).exists()]
    oversized = [p.name for p in IMAGES.glob("*") if p.stat().st_size > MAX_IMAGE_BYTES]
    print(f"images: {len(wanted) - len(missing)}/{len(wanted)} supplied (missing ones show a styled placeholder)")
    for name in oversized:
        print(f"  warning: {name} is over {MAX_IMAGE_BYTES // 1024} KB; compress it to WebP")

    errors += repetition_errors()
    text = TEXT.read_text(encoding="utf-8")
    for bad, name in (("\u2014", "em dash"), ("\u2013", "en dash")):
        if bad in text:
            errors.append(f"{name} found; use commas or full stops instead")
    for e in errors:
        print("ERROR", e)
    return 1 if errors else 0


if __name__ == "__main__":
    sys.exit(main())
