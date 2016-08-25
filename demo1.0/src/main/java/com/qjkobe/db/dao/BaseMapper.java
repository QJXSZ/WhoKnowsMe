package com.qjkobe.db.dao;

import com.qjkobe.db.model.Order;
import com.qjkobe.db.model.Pager;
import com.qjkobe.db.model.Pojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BaseMapper {

	@SuppressWarnings("rawtypes")
	public List selectListByParam(@Param("pojo") Pojo pojo,
								  @Param("orderObj") Order order, @Param("pager") Pager pager);

	public int selectCountByParam(@Param("pojo") Pojo pojo);

	@SuppressWarnings("rawtypes")
	public List selectListByParamMap(Map<String, Object> param);
}
