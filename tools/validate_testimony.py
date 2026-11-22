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
            elif key in ("subtitle", "summary"):
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
        if not v["summary"]:
            errors.append(f"volume {v['title']!r}: missing @summary")
        if len(v["chapters"]) < 4:
            errors.append(f"volume {v['title']!r}: fewer than 4 chapters")
        wanted += [v["image"]] + [c["image"] for c in v["chapters"]]
        for c in v["chapters"]:
            if not c["epigraph"]:
                errors.append(f"chapter {c['title']!r}: missing @epigraph")
            if c["verses"] < 5:
                errors.append(f"chapter {c['title']!r}: fewer than 5 verses")

    chapters = sum(len(v["chapters"]) for v in volumes)
    verses = sum(c["verses"] for v in volumes for c in v["chapters"])
    print(f"{len(volumes)} volumes, {chapters} chapters, {verses} verses")

    missing = [w for w in wanted if w and not (IMAGES / w).exists()]
    oversized = [p.name for p in IMAGES.glob("*") if p.stat().st_size > MAX_IMAGE_BYTES]
    print(f"images: {len(wanted) - len(missing)}/{len(wanted)} supplied (missing ones show a styled placeholder)")
    for name in oversized:
        print(f"  warning: {name} is over {MAX_IMAGE_BYTES // 1024} KB; compress it to WebP")

    text = TEXT.read_text(encoding="utf-8")
    for bad, name in (("\u2014", "em dash"), ("\u2013", "en dash")):
        if bad in text:
            errors.append(f"{name} found; use commas or full stops instead")
    for e in errors:
        print("ERROR", e)
    return 1 if errors else 0


if __name__ == "__main__":
    sys.exit(main())
