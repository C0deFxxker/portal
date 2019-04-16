package com.lyl.study.portal.common.dto;

import lombok.ToString;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@ToString
public class PageInfo<T> implements Serializable {
    /**
     * 总数
     */
    private long total = 0;

    /**
     * 每页显示条数，默认 10
     */
    private int size = 10;

    /**
     * 总页数
     */
    private long pages = 0;

    /**
     * 当前页
     */
    private int current = 1;

    /**
     * 查询数据列表
     */
    private List<T> list = Collections.emptyList();

    public PageInfo() {
    }

    public PageInfo(int current, int size) {
        this.size = size;
        this.current = current;
    }

    public PageInfo(int current, int size, long total, List<T> list) {
        this.total = total;
        this.size = size;
        this.current = current;
        this.list = list;
        this.pages = (total + size - 1) / size;
    }

    public long getTotal() {
        return total;
    }

    public PageInfo<T> setTotal(long total) {
        this.total = total;
        pages = (total + size - 1) / size;
        return this;
    }

    public int getSize() {
        return size;
    }

    public PageInfo<T> setSize(int size) {
        this.size = size;
        pages = (total + size - 1) / size;
        return this;
    }

    public long getPages() {
        return pages;
    }

    public int getCurrent() {
        return current;
    }

    public PageInfo<T> setCurrent(int current) {
        this.current = current;
        return this;
    }

    public List<T> getList() {
        return list;
    }

    public PageInfo<T> setList(List<T> list) {
        this.list = list;
        return this;
    }

}
