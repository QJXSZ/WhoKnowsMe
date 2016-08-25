package com.qjkobe.db.dao.test;

import com.qjkobe.db.dao.BaseMapper;
import com.qjkobe.db.model.test.TTest;

public interface TTestMapper extends BaseMapper {
    int deleteByPrimaryKey(String id);

    int insert(TTest record);

    int insertSelective(TTest record);

    TTest selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TTest record);

    int updateByPrimaryKey(TTest record);
}