package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.ActivityDataStatisticalAdditional;
import com.jd.m.cms.bjshare.domain.po.ActivityDataStatisticalAdditionalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityDataStatisticalAdditionalMapper {
    int countByExample(ActivityDataStatisticalAdditionalExample example);

    int deleteByExample(ActivityDataStatisticalAdditionalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivityDataStatisticalAdditional record);

    int insertSelective(ActivityDataStatisticalAdditional record);

    List<ActivityDataStatisticalAdditional> selectByExample(ActivityDataStatisticalAdditionalExample example);

    ActivityDataStatisticalAdditional selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivityDataStatisticalAdditional record, @Param("example") ActivityDataStatisticalAdditionalExample example);

    int updateByExample(@Param("record") ActivityDataStatisticalAdditional record, @Param("example") ActivityDataStatisticalAdditionalExample example);

    int updateByPrimaryKeySelective(ActivityDataStatisticalAdditional record);

    int updateByPrimaryKey(ActivityDataStatisticalAdditional record);
}