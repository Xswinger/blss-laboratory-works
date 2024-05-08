package com.Xswinger.uazService.entities;

public class ModelCountMessage {
    private int count;

    public ModelCountMessage(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ModelCountMessage{" +
                "count=" + count +
                '}';
    }
}
