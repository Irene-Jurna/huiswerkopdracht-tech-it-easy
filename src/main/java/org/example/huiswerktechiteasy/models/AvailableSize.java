package org.example.huiswerktechiteasy.models;

public enum AvailableSize {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private final String size;

    AvailableSize(String size){
        this.size = size;
    }

    @Override
    public String toString(){
        return size;
    }
}
