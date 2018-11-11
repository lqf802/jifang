package com.stylefeng.guns.core.page;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import java.util.Collections;
import java.util.List;

public class Page<T, C> extends Pagination {
    private static final long serialVersionUID = 1L;
    private List<T> rows;
    private transient C condition;

    public Page() {
        this.rows = Collections.emptyList();
    }

    public Page(int current, int size) {
        super(current, size);
        this.rows = Collections.emptyList();
    }

    public Page(int current, int size, String orderByField) {
        super(current, size);
        this.rows = Collections.emptyList();
        this.setOrderByField(orderByField);
    }

    public Page(int current, int size, String orderByField, boolean isAsc) {
        this(current, size, orderByField);
        this.setAsc(isAsc);
    }

    public List<T> getRows() {
        return this.rows;
    }

    public Page<T, C> setRows(List<T> rows) {
        this.rows = rows;
        return this;
    }

    public C getCondition() {
        return this.condition;
    }

    public Page<T, C> setCondition(C condition) {
        this.condition = condition;
        return this;
    }

    public String toString() {
        StringBuilder pg = new StringBuilder();
        pg.append(" Page:{ [").append(super.toString()).append("], ");
        if (this.rows != null) {
            pg.append("records-size:").append(this.rows.size());
        } else {
            pg.append("records is null");
        }

        return pg.append(" }").toString();
    }
}
