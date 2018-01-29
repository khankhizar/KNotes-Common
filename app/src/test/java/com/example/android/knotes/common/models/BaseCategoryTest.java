package com.example.android.knotes.common.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BaseCategoryTest {

    private BaseCategory baseCategory1;
    private BaseCategory baseCategory2;


    @Before
    public void setUp() {
        baseCategory1 = new BaseCategory();
        baseCategory1.setId(1L);
        baseCategory1.setColor("#ffffff");
        baseCategory1.setCount(10);
        baseCategory1.setDescription("first cat description");
        baseCategory1.setName("first cat name");

        baseCategory2 = new BaseCategory();
        baseCategory2.setId(2L);
        baseCategory2.setColor("#000000");
        baseCategory2.setCount(5);
        baseCategory2.setDescription("second cat description");
        baseCategory2.setName("second cat name");
    }


    @Test
    public void equivalence() {
        BaseCategory newBaseCategory = new BaseCategory(baseCategory1);
        assertEquals(baseCategory1, newBaseCategory);
    }


    @Test
    public void difference() {
        assertNotEquals(baseCategory1, baseCategory2);
    }


    @Test
    public void listContainsNote() {
        List<BaseCategory> categories = new ArrayList<>();
        categories.add(baseCategory1);
        categories.add(baseCategory2);
        assertTrue(categories.contains(baseCategory2));
        assertTrue(categories.contains(baseCategory1));

        BaseCategory newBaseCategory = new BaseCategory();
        newBaseCategory.setName("newCat");
        newBaseCategory.setDescription("newCat desc");
        newBaseCategory.setColor("#cccccc");
        assertFalse(categories.contains(newBaseCategory));
    }
}