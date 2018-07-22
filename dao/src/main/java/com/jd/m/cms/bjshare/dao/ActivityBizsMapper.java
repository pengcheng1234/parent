package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.ActivityBizs;
import com.jd.m.cms.bjshare.domain.po.ActivityBizsExample;
import com.jd.m.cms.bjshare.domain.vo.IdsAndAuditStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ActivityBizsMapper {
    int countByExample(ActivityBizsExample example);

    int deleteByExample(ActivityBizsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivityBizs record);

    int insertSelective(ActivityBizs record);

    List<ActivityBizs> selectByExample(ActivityBizsExample example);

    ActivityBizs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivityBizs record, @Param("example") ActivityBizsExample example);

    int updateByExample(@Param("record") ActivityBizs record, @Param("example") ActivityBizsExample example);

    int updateByPrimaryKeySelective(ActivityBizs record);

    int updateByPrimaryKey(ActivityBizs record);

    /**
     * 批量插入活动和biz的关系
     */
    void insertActivityBizsPatch(List<ActivityBizs> activityBizsList);
    /**
     * 通过运维活动id获取的商品id数据列表
     */
    List<IdsAndAuditStatus> getThingIdsListByOperation(Map<String, Object> map);



}