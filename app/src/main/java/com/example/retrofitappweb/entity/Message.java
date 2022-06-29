package com.example.retrofitappweb.entity;

public class Message {

    private int count;
    private String next;
    private String previous;
    private results results;

    @Override
    public String toString() {
        return "Message{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + results.toString() +
                '}';
    }
}
