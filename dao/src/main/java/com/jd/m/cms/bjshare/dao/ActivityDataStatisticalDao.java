package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.ActivityDataStatistical;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ActivityDataStatisticalDao {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(ActivityDataStatistical record);

    ActivityDataStatistical selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivityDataStatistical record);

	List<ActivityDataStatistical> getDataListByDate(Map<String, Object> map);

	List<ActivityDataStatistical> getDataListByActivityId(Map<String, Object> map);

	List<ActivityDataStatistical> getBizList(Map<String, Object> map);
}