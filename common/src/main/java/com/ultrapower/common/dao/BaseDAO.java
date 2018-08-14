package com.ultrapower.common.dao;

import java.util.List;

/**
 * Created by User on 2018/8/7.
 */
public interface BaseDAO<M,QM> {

    public void create(M cm);

    public void update(M cm);

    public void delete(int pid);

    public M getByPid(int pid);

    public M getByCustomerId(String  customerId);

    public List<M> getByConditionPage(QM cm);
}
