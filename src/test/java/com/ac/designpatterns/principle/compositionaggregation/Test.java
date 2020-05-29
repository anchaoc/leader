package com.ac.designpatterns.principle.compositionaggregation;

/**
 * Created by geely
 * 聚合复用原则
 */
public class Test {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        productDao.setDbConnection(new PostgreSQLConnection());
        productDao.addProduct();
    }
}
