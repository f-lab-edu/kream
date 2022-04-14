package com.flab.kream.common.model;

import lombok.Value;

@Value
public class Pagination {

    long cursorUserNo;

    int size;

    public static Pagination paging(long cursorUserNo, int size) {

        return new Pagination(cursorUserNo, size);
    }

}
