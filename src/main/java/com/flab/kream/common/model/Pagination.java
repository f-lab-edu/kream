package com.flab.kream.common.model;

import lombok.Value;

@Value
public class Pagination {

    long cursor;

    int size;

    public static Pagination paging(long cursor, int size) {

        return new Pagination(cursor, size);
    }

}
