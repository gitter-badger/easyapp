package com.jdl.easyapp.domain.model;

import com.jdl.easyapp.domain.model.base.IEntity;
import com.jdl.easyapp.domain.model.base.Org;
import lombok.Data;

@Data
public class Index implements IEntity {
    private Org org;

    private Long id;

    private Table table;
    private Column column;

    private String value;

    // the cluster index reference
    private Long rowId;

    Index(Org org, Table table, Column column, Row row) {
        this.org = org;
        this.table = table;
        this.column = column;
        this.rowId = row.Id();
    }

    @Override
    public Long Id() {
        return id;
    }

    @Override
    public Org org() {
        return org;
    }
}
