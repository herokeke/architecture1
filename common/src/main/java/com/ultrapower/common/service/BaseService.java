package com.ultrapower.common.service;

import com.github.pagehelper.PageInfo;
import com.ultrapower.common.dao.BaseDAO;
import com.ultrapower.common.vo.BaseModel;

import java.util.List;

/**
 * Created by User on 2018/8/7.
 */
public class BaseService<M,QM extends BaseModel> implements IBaseService<M,QM> {

    private BaseDAO dao = null;

    public void setDao(BaseDAO dao) {
        this.dao = dao;
    }

    @Override
    public void create(M cm) {
        dao.create(cm);
    }

    @Override
    public void update(M cm) {
        dao.update(cm);

    }

    @Override
    public void delete(int pid) {
        dao.delete(pid);
    }

    @Override
    public M getByPid(int pid) {
        return (M) dao.getByPid(pid);
    }

    @Override
    public M getByMId(String mId) {
        return (M) dao.getByMId(mId);
    }

    @Override
    public PageInfo<M> getByConditionPage(QM qm) {
        List<M> list = dao.getByConditionPage(qm);
        qm.getPageHelper().startPage(1,5);
        PageInfo page = new PageInfo<>(list);
        return page;
    }
}
