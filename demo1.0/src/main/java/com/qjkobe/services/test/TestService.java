package com.qjkobe.services.test;

import com.qjkobe.db.model.Order;
import com.qjkobe.db.model.Pager;
import com.qjkobe.db.model.test.TTest;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25.
 */
public interface TestService {
    public List<TTest> getTestListByParam(TTest test, Order order, Pager page);

    public void addTest(TTest test);

    public void modifyTest(TTest test);

    public TTest getTestById(String id);
}
