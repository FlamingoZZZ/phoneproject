package com.example.springboot.domain;

import java.util.List;

public class PageInfo {
    private int curPage;
    private int totalPage;
    private List<String> result;

    public PageInfo(int curPage, int totalPage, List<String> result) {
        this.curPage = curPage;
        this.totalPage = totalPage;
        this.result = result;
    }

    public int getCurPage() {
        return curPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public List<String> getResult() {
        return result;
    }
}
