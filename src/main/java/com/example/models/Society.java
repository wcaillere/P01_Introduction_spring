package com.example.models;

public class Society {
    private String societyName;

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String name) {
        this.societyName = name;
    }

    @Override
    public String toString() {
        return "Society{" +
                "societyName='" + societyName + '\'' +
                '}';
    }
}
