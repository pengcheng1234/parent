package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.ShareActivityAdditional;
import com.jd.m.cms.bjshare.domain.po.ShareActivityAdditionalExample;
import com.jd.m.cms.bjshare.domain.po.ShareActivityAdditionalWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShareActivityAdditionalMapper {
    int countByExample(ShareActivityAdditionalExample example);

    int deleteByExample(ShareActivityAdditionalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShareActivityAdditionalWithBLOBs record);

    int insertSelective(ShareActivityAdditionalWithBLOBs record);

    List<ShareActivityAdditionalWithBLOBs> selectByExampleWithBLOBs(ShareActivityAdditionalExample example);

    List<ShareActivityAdditional> selectByExample(ShareActivityAdditionalExample example);

    ShareActivityAdditionalWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShareActivityAdditionalWithBLOBs record, @Param("example") ShareActivityAdditionalExample example);

    int updateByExampleWithBLOBs(@Param("record") ShareActivityAdditionalWithBLOBs record, @Param("example") ShareActivityAdditionalExample example);

    int updateByExample(@Param("record") ShareActivityAdditional record, @Param("example") ShareActivityAdditionalExample example);

    int updateByPrimaryKeySelective(ShareActivityAdditionalWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShareActivityAdditionalWithBLOBs record);

    int updateByPrimaryKey(ShareActivityAdditional record);
}