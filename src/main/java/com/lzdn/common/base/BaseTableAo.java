package com.lzdn.common.base;

public class BaseTableAo {
    private Integer offset;
    private Integer limit;
    private String search;
    private String sort;
    private String order;

    public BaseTableAo() {
    }

    public BaseTableAo(Integer offset, Integer limit, String search, String sort, String order) {
        this.offset = offset;
        this.limit = limit;
        this.search = search;
        this.sort = sort;
        this.order = order;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
