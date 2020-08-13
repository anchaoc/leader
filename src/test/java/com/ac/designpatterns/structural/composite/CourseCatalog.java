package com.ac.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anchao
 * @date 2020/8/11 10:52
 **/
public class CourseCatalog extends CatalogComponent {

    private List<CatalogComponent> items = new ArrayList<CatalogComponent>();
    private String name;

    public CourseCatalog(String name) {
        this.name = name;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        items.remove(catalogComponent);
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CatalogComponent catalogComponent : items) {
            System.out.println(" ");
            catalogComponent.print();
        }
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }
}
