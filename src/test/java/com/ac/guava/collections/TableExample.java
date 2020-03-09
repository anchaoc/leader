package com.ac.guava.collections;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

/** 表
 * @author anchao
 * @date 2020/3/9 19:47
 */
public class TableExample {


    //ArrayTbale
    //TreeBaseTable
    //HashBaseTable
    //ImmutableTable
    @Test
    public void test(){
        HashBasedTable<Object, Object, Object> hashBasedTable = HashBasedTable.create();
        hashBasedTable.put("Language", "Java", "1.8");
        hashBasedTable.put("Language", "Scala", "2.3");
        hashBasedTable.put("DateBase", "Oracle", "12C");
        hashBasedTable.put("DateBase", "Mysql", "8.0");
        //Map<String,Map<String,String>>
        //{Lanuage={Java=1.8, Scala=2.3}, DateBase={Oracle=12C, Mysql=8.0}}
        System.out.println(hashBasedTable);
        Map<Object, Object> language = hashBasedTable.row("Language");
        System.out.println(language);
        Set<Table.Cell<Object, Object, Object>> cells = hashBasedTable.cellSet();
        System.out.println(cells);

    }
}
