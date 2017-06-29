package com.hsbc.gcph.xaracloud.ms.customers.model;

/**
 * Created by subhash on 27/6/17.
 */
public class Customer {


    private long id;
    private String name;
    private String email;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
