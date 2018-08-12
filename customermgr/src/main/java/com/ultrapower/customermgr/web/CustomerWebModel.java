package com.ultrapower.customermgr.web;

/**
 * Created by User on 2018/8/10.
 */
public class CustomerWebModel {

    private String queryJsonStr = "";

    private int pageNum = 1;

    public String getQueryJsonStr() {
        return queryJsonStr;
    }

    public void setQueryJsonStr(String queryJsonStr) {
        this.queryJsonStr = queryJsonStr;
    }


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
