package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.CheckFlow;
import com.jd.m.cms.bjshare.domain.po.CheckFlowExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckFlowMapper {
    int countByExample(CheckFlowExample example);

    int deleteByExample(CheckFlowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CheckFlow record);

    int insertSelective(CheckFlow record);

    List<CheckFlow> selectByExample(CheckFlowExample example);

    CheckFlow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CheckFlow record, @Param("example") CheckFlowExample example);

    int updateByExample(@Param("record") CheckFlow record, @Param("example") CheckFlowExample example);

    int updateByPrimaryKeySelective(CheckFlow record);
//根据活动id和erp更新流程
    int updateByActivityIdSelective(CheckFlow record);

    int updateByPrimaryKey(CheckFlow record);
}