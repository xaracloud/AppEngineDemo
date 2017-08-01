package com.hsbc.gcph.xaracloud.common.model;

import java.io.Serializable;

/**
 * Created by subhash on 28/7/17.
 */
public class Customer implements Serializable {

    private int id;
    private String name;

    public Customer() {

    }

    public Customer(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
