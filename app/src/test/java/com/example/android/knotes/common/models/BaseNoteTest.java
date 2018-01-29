package com.example.android.knotes.common.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;


public class BaseNoteTest {

    private BaseNote baseNote1;
    private BaseNote baseNote2;


    @Before
    public void setUp() {
        baseNote1 = new BaseNote();
        baseNote1.setTitle("new title");
        baseNote1.setContent("some random content");
        baseNote1.setCreation(Calendar.getInstance().getTimeInMillis() - 10000);
        baseNote1.setLastModification(Calendar.getInstance().getTimeInMillis() - 10000);
        baseNote1.setLocked(true);

        baseNote2 = new BaseNote();
        baseNote2.setTitle("another title");
        baseNote2.setContent("some more random different content");
        baseNote2.setCreation(Calendar.getInstance().getTimeInMillis());
        baseNote2.setLastModification(Calendar.getInstance().getTimeInMillis());
        baseNote2.setCategory(new BaseCategory());
    }


    @Test
    public void equivalence() {
        BaseNote newBaseNote = new BaseNote(baseNote1);
        assertEquals(baseNote1, newBaseNote);
        newBaseNote.setContent(baseNote1.getContent());
        assertEquals(baseNote1, newBaseNote);
    }


    @Test
    public void equivalenceByCategory() {
        BaseNote newBaseNote = new BaseNote(baseNote1);
        newBaseNote.setCategory(new BaseCategory());
        assertFalse(baseNote1.equals(newBaseNote));
    }


    @Test
    public void difference() {
        assertNotEquals(baseNote1, baseNote2);
    }


    @Test
    public void listContainsNote() {
        List<BaseNote> baseNotes = new ArrayList<>();
        baseNotes.add(baseNote1);
        baseNotes.add(baseNote2);
        assertTrue(baseNotes.contains(baseNote1));
        assertTrue(baseNotes.contains(baseNote2));
        assertFalse(baseNotes.contains(new BaseNote()));
    }
}