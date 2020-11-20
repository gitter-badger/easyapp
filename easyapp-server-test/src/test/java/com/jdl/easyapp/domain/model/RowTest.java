package com.jdl.easyapp.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RowTest {

    @Test
    public void setValueBySlot() throws NoSuchFieldException {
        Row row = new Row(null, null);
        row.setValueBySlot(1, "abc");
        assertEquals("abc", row.getSlot1());
        assertEquals("abc", row.getValueBySlot(1));

        row.setSlot3("hello");
        assertEquals("hello", row.getValueBySlot(3));
    }

}