package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.OperaterList;
import com.jd.m.cms.bjshare.domain.po.OperaterListExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperaterListMapper {
    int countByExample(OperaterListExample example);

    int deleteByExample(OperaterListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperaterList record);

    int insertSelective(OperaterList record);

    List<OperaterList> selectByExample(OperaterListExample example);

    OperaterList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperaterList record, @Param("example") OperaterListExample example);

    int updateByExample(@Param("record") OperaterList record, @Param("example") OperaterListExample example);

    int updateByPrimaryKeySelective(OperaterList record);

    int updateByPrimaryKey(OperaterList record);
}