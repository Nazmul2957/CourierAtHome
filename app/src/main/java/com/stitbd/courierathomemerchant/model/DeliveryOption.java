package com.stitbd.courierathomemerchant.model;

public class DeliveryOption {
    private int id;
    private String name;

    public DeliveryOption(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
