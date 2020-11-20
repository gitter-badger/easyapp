package com.jdl.easyapp.domain.model;

import com.jdl.easyapp.domain.dict.ColumnType;
import com.jdl.easyapp.domain.facade.repository.IIdRepository;
import com.jdl.easyapp.domain.model.base.Org;
import com.jdl.easyapp.domain.model.creator.TableCreator;
import com.jdl.easyapp.domain.model.mock.IdRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-test.xml"})
public class TableTest {

    private Org org;
    private IIdRepository idRepository = new IdRepository();

    @Before
    public void setUp() {
        org = new Org();
        org.setId(8L);
    }

    @Test
    public void basic() throws NoSuchFieldException {
        TableCreator creator = new TableCreator();
        creator.setOrg(org);
        creator.setName("耗材");

        // 创建表：耗材表
        Table table = Table.createWith(creator, idRepository);
        assertEquals("耗材", table.getName());
        assertNotNull(table.getColumns());

        // 添加字段：名称
        Column columnName = new Column(table, ColumnType.Text, 1, "名称"); // slot1
        table.addColumn(columnName, idRepository);
        assertEquals(1, table.getColumns().size());
        assertEquals("名称", table.getColumnBySlot(1).getName());
        assertNull(table.getColumnBySlot(2));

        // 添加字段：耗材描述，并且该字段进行索引
        Column columnDesc = new Column(table, ColumnType.Text, 3, "耗材描述"); // slot3
        columnDesc.setIndexed(true);
        columnDesc.setMaxLen(200);
        table.addColumn(columnDesc, idRepository);
        assertEquals(2, table.getColumns().size());
        assertEquals("耗材描述", table.getColumnBySlot(3).getName());

        // 向耗材表插入数据
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("名称", "打印机");
        dataMap.put("invalid", "foo");
        dataMap.put("耗材描述", "支持WIFI，支持扫描");
        Row row = table.addRow(dataMap, idRepository);
        assertEquals("打印机", row.getSlot1());
        assertEquals("支持WIFI，支持扫描", row.getSlot3());
        assertNull(row.getSlot2());
        assertEquals(1, row.getIndexes().size());
        Index index = row.getIndexes().get(0);
        assertEquals("支持WIFI，支持扫描", index.getValue());
        assertSame(table, index.getTable());
        assertSame(columnDesc, index.getColumn());
        assertEquals(row.getId(), index.getRowId());

        assertSame(row.getTable(), table);
        assertSame(row.getOrg(), table.org());

        // 利用索引查询数据
        List<Row> rows = table.searchRow("耗材描述", "支持WIFI，支持扫描");
    }

}