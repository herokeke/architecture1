package com.ultrapower.common.service;

import com.github.pagehelper.PageInfo;
import com.ultrapower.common.vo.BaseModel;

import java.util.List;

/**
 * Created by User on 2018/8/7.
 */
public interface IBaseService<M,QM extends BaseModel> {

    public void create(M cm);

    public void update(M cm);

    public void delete(int pid);

    public M getByPid(int pid);

    public PageInfo<M> getByConditionPage(QM cm);
}
