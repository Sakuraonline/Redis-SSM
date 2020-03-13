package com.sakura.entity;
public class Account {
    private int uid;
    private String name;
    private double money;

    public int getId() {
        return uid;
    }

    public void setId(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
