package com.acompletenoobsmoke.leetcodetrackerbackend.model;

public class TopicTag {
    private String name;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return name;
    }
}
