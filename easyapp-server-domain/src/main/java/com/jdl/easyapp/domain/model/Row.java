package com.jdl.easyapp.domain.model;

import com.jdl.easyapp.domain.model.base.IEntity;
import com.jdl.easyapp.domain.model.base.Org;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Data
public class Row implements IEntity {
    private Org org;

    private Long id;

    private Table table;

    private List<Index> indexes;

    private String slot1;
    private String slot2;
    private String slot3;
    private String slot4;
    private String slot5;
    private String slot6;
    private String slot7;
    private String slot8;

    @Override
    public Long Id() {
        return id;
    }

    @Override
    public Org org() {
        return org;
    }

    Row(Org org, Table table) {
        this.org = org;
        this.table = table;
        this.indexes = new ArrayList<>();
    }

    public void setValueBySlot(Integer slot, String value) throws NoSuchFieldException {
        Field field = getClass().getDeclaredField("slot" + slot);
        try {
            field.set(this, value);
        } catch (IllegalAccessException shouldNeverHappen) {
        }
    }

    public String getValueBySlot(Integer slot) throws NoSuchFieldException {
        Field field = getClass().getDeclaredField("slot" + slot);
        try {
            Object value = field.get(this);
            if (value == null) {
                return null;
            }

            return (String) value;
        } catch (IllegalAccessException shouldNeverHappen) {
        }

        return null;
    }

    public void addIndex(Index index) {
        this.indexes.add(index);
    }
}
