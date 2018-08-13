package com.ultrapower.common.vo;


import com.github.pagehelper.PageHelper;

/**
 * Created by User on 2018/8/7.
 */
public class BaseModel implements java.io.Serializable {

    private Integer pid;

    /*
    分页在引入ehcache后在查询中报错：
    java.io.NotSerializableException: com.github.pagehelper.PageHelper
     */
    private transient PageHelper pageHelper = new  PageHelper();

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
