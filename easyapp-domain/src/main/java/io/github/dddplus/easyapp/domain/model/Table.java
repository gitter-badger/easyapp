package io.github.dddplus.easyapp.domain.model;

import io.github.dddplus.easyapp.domain.facade.repository.IIdRepository;
import io.github.dddplus.easyapp.domain.model.base.IEntity;
import io.github.dddplus.easyapp.domain.model.base.Org;
import io.github.dddplus.easyapp.domain.model.creator.TableCreator;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Table implements IEntity {
    private Org org;

    private Long id;
    private String name;

    // key: slot
    private Map<Integer, Column> columns;

    // key: Column.name
    private Map<String, Column> columnsCache;

    @Override
    public Long Id() {
        return id;
    }

    @Override
    public Org org() {
        return org;
    }

    private Table() {}

    public static Table createWith(@NotNull TableCreator creator, @NotNull IIdRepository idRepository) {
        Table table = new Table();
        table.org = creator.getOrg();
        table.id = idRepository.newId();
        table.name = creator.getName();
        table.columns = new HashMap<>();
        table.columnsCache = new HashMap<>();

        return table;
    }

    public Column getColumnBySlot(@NotNull Integer slot) {
        return columns.get(slot);
    }

    public Column getColumnByName(String columnName) {
        return columnsCache.get(columnName);
    }

    public Integer getSlotByColumnName(String columnName) {
        return getColumnByName(columnName).getSlot();
    }

    public void addColumn(Column column, @NotNull IIdRepository idRepository) {
        column.setId(idRepository.newId());
        this.columns.put(column.getSlot(), column);
        this.columnsCache.put(column.getName(), column);
    }

    public Row addRow(Map<String, String> rowData, @NotNull IIdRepository idRepository) throws NoSuchFieldException {
        Row row = new Row(this.org, this);
        row.setId(idRepository.newId());

        for (Map.Entry<String, String> entry : rowData.entrySet()) {
            String columnName = entry.getKey();
            String columnValue = entry.getValue();

            Column column = getColumnByName(columnName);
            if (column == null) {
                // invalid column name
                continue;
            }

            column.validateValue(columnValue);

            if (column.isIndexed()) {
                Index index = new Index(org, this, column, row);
                index.setId(idRepository.newId());
                index.setValue(columnValue);
                row.addIndex(index);
            }

            row.setValueBySlot(getSlotByColumnName(columnName), columnValue);
        }

        return row;
    }

    // TODO 目前还只能使用1个索引，暂时不支持 composite key
    public List<Row> searchRow(String columnName, String columnValue) {
        return null; // TODO
    }
}
