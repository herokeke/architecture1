package com.ultrapower.common.vo;

import com.github.pagehelper.PageHelper;

/**
 * Created by User on 2018/8/7.
 */
public class BaseModel {

    private Integer pid;

    private PageHelper pageHelper = new  PageHelper();

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public PageHelper getPageHelper() {
        return pageHelper;
    }

    public void setPageHelper(PageHelper pageHelper) {
        this.pageHelper = pageHelper;
    }
}
