package com.count.entity;

public class CountView {
    private int count=0;

    public CountView(int count) {
        this.count = count;
    }

    public CountView() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment(){
        this.count++;
    }
}
