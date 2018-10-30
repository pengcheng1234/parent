package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.TagRecord;
import com.jd.m.cms.bjshare.domain.po.TagRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagRecordMapper {
    int countByExample(TagRecordExample example);

    int deleteByExample(TagRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TagRecord record);

    int insertSelective(TagRecord record);

    List<TagRecord> selectByExample(TagRecordExample example);

    TagRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TagRecord record, @Param("example") TagRecordExample example);

    int updateByExample(@Param("record") TagRecord record, @Param("example") TagRecordExample example);

    int updateByPrimaryKeySelective(TagRecord record);

    int updateByPrimaryKey(TagRecord record);
}