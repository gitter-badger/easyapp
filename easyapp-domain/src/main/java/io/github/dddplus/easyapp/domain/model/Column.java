package io.github.dddplus.easyapp.domain.model;

import io.github.dddplus.easyapp.domain.ability.FieldValidateAbility;
import io.github.dddplus.easyapp.domain.dict.ColumnType;
import io.github.dddplus.easyapp.domain.model.base.IEntity;
import io.github.dddplus.easyapp.domain.model.base.Org;
import io.github.dddplus.runtime.DDD;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Column implements IEntity {
    private Org org;

    private Table table;

    private Long id;
    private String name;
    private ColumnType columnType;
    private Integer slot; // 在 Row的第几个槽位

    private int maxLen;
    private boolean indexed;
    private boolean unique;

    public Column(@NotNull Table table, @NotNull ColumnType columnType, @NotNull Integer slot, @NotNull String name) {
        this.table = table;
        this.columnType = columnType;
        this.slot = slot;
        this.name = name;
    }

    @Override
    public Long Id() {
        return id;
    }

    @Override
    public Org org() {
        return org;
    }

    void validateValue(String value) {
        DDD.findAbility(FieldValidateAbility.class).validate(this, value);
    }
}
