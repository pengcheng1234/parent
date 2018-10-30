package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.Role;
import com.jd.m.cms.bjshare.domain.po.WhiteList;
import com.jd.m.cms.bjshare.domain.po.WhiteListExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface WhiteListMapper {
    int countByExample(WhiteListExample example);

    int deleteByExample(WhiteListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WhiteList record);

    int insertSelective(WhiteList record);

    List<WhiteList> selectByExample(WhiteListExample example);

    WhiteList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WhiteList record, @Param("example") WhiteListExample example);

    int updateByExample(@Param("record") WhiteList record, @Param("example") WhiteListExample example);

    int updateByPrimaryKeySelective(WhiteList record);

    int updateByPrimaryKey(WhiteList record);

    //通过erplist查询用户
    Set<String> selectByErpList(Map<String, Object> map);

    //批量新增白名单
    int insertRoleSetList(List<WhiteList> roleList);
}