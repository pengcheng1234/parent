package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.ShareRuleAdditional;
import com.jd.m.cms.bjshare.domain.po.ShareRuleAdditionalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShareRuleAdditionalMapper {
    int countByExample(ShareRuleAdditionalExample example);

    int deleteByExample(ShareRuleAdditionalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShareRuleAdditional record);

    int insertSelective(ShareRuleAdditional record);

    List<ShareRuleAdditional> selectByExample(ShareRuleAdditionalExample example);

    ShareRuleAdditional selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShareRuleAdditional record, @Param("example") ShareRuleAdditionalExample example);

    int updateByExample(@Param("record") ShareRuleAdditional record, @Param("example") ShareRuleAdditionalExample example);

    int updateByPrimaryKeySelective(ShareRuleAdditional record);

    int updateByPrimaryKey(ShareRuleAdditional record);
}