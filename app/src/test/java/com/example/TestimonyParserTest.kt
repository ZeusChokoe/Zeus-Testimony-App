package com.example

import com.example.data.NoteKind
import com.example.data.Position
import com.example.data.TestimonyFormatException
import com.example.data.TestimonyParser
import com.example.data.toRoman
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class TestimonyParserTest {

    private val sample = """
        # comment
        @volume First
        @subtitle Sub
        @summary Sum
        @image vol_01.webp
        @chapter Alpha
        @image v01_c01.webp
        Verse one.
        > Science: A fact.
        > plain note
        Verse two.
        @chapter Beta
        Verse three.
        @volume Second
        @chapter Gamma
        Verse four.
    """.trimIndent()

    @Test
    fun numbersChaptersAndVersesByPosition() {
        val t = TestimonyParser.parse(sample)
        assertEquals(2, t.volumes.size)
        assertEquals(listOf(1, 2), t.volumes[0].chapters.map { it.number })
        assertEquals(listOf(1, 2), t.volumes[0].chapters[0].verses.map { it.number })
        assertEquals("vol_01.webp", t.volumes[0].image)
        assertEquals("v01_c01.webp", t.volumes[0].chapters[0].image)
        val notes = t.volumes[0].chapters[0].verses[0].notes
        assertEquals(NoteKind.SCIENCE, notes[0].kind)
        assertEquals("A fact.", notes[0].text)
        assertEquals(NoteKind.NOTE, notes[1].kind)
    }

    @Test
    fun navigationCrossesVolumes() {
        val t = TestimonyParser.parse(sample)
        assertEquals(Position(1, 0), t.next(Position(0, 1)))
        assertEquals(Position(0, 1), t.previous(Position(1, 0)))
        assertNull(t.next(Position(1, 0)))
        assertNull(t.previous(Position(0, 0)))
        assertNull(t.chapter(Position(9, 9)))
    }

    @Test(expected = TestimonyFormatException::class)
    fun rejectsPathTraversalInImages() {
        TestimonyParser.parse("@volume A\n@image ../../secret.png")
    }

    @Test(expected = TestimonyFormatException::class)
    fun rejectsVerseOutsideChapter() {
        TestimonyParser.parse("@volume A\nOrphan verse")
    }

    @Test
    fun romanNumerals() {
        assertEquals(listOf("I", "IV", "IX", "XII", "XL"), listOf(1, 4, 9, 12, 40).map(::toRoman))
    }

    /** Guards the shipped content: every volume has several distinct, auto-numbered chapters. */
    @Test
    fun bundledTestimonyIsWellFormed() {
        val t = TestimonyParser.parse(File("src/main/assets/testimony.txt").readText())
        assertEquals(12, t.volumes.size)
        t.volumes.forEach { v ->
            assertTrue("${v.title} has too few chapters", v.chapters.size >= 4)
            assertTrue("${v.title} lacks summary", v.summary.isNotBlank())
            assertEquals(v.chapters.size, v.chapters.map { it.title }.toSet().size)
            v.chapters.forEach { assertTrue("${it.title} has too few verses", it.verses.size >= 5) }
        }
    }
}
