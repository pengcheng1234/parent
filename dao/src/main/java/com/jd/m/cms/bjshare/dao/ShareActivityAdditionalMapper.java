package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.ShareActivityAdditional;
import com.jd.m.cms.bjshare.domain.po.ShareActivityAdditionalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShareActivityAdditionalMapper {
    int countByExample(ShareActivityAdditionalExample example);

    int deleteByExample(ShareActivityAdditionalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShareActivityAdditional record);

    int insertSelective(ShareActivityAdditional record);

    List<ShareActivityAdditional> selectByExample(ShareActivityAdditionalExample example);

    ShareActivityAdditional selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShareActivityAdditional record, @Param("example") ShareActivityAdditionalExample example);

    int updateByExample(@Param("record") ShareActivityAdditional record, @Param("example") ShareActivityAdditionalExample example);

    int updateByPrimaryKeySelective(ShareActivityAdditional record);

    int updateByPrimaryKey(ShareActivityAdditional record);
}