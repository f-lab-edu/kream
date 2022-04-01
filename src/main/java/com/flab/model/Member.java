package com.flab.model;

import lombok.Data;

@Data
public class Member {
    private String id;

    private String name;


    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
