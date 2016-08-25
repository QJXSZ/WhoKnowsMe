package com.qjkobe.services.test.impl;

import com.qjkobe.db.dao.test.TTestMapper;
import com.qjkobe.db.model.Order;
import com.qjkobe.db.model.Pager;
import com.qjkobe.db.model.test.TTest;
import com.qjkobe.services.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25.
 */
@Service("testService")
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    TTestMapper tTestMapper;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<TTest> getTestListByParam(TTest test, Order order, Pager page) {
        if (page != null) {
            int count = tTestMapper.selectCountByParam(test);
            page.setRecordCount(count);
        }
        return tTestMapper.selectListByParam(test, order, page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addTest(TTest test) {
        tTestMapper.insertSelective(test);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyTest(TTest test) {
        tTestMapper.updateByPrimaryKeySelective(test);
    }

    @Override
    @Transactional(readOnly = true)
    public TTest getTestById(String id) {
        return tTestMapper.selectByPrimaryKey(id);
    }
}
