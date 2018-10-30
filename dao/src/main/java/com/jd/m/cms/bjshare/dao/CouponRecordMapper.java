package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.CouponRecord;
import com.jd.m.cms.bjshare.domain.po.CouponRecordExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CouponRecordMapper {
    int countByExample(CouponRecordExample example);

    int deleteByExample(CouponRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouponRecord record);

    int insertSelective(CouponRecord record);

    List<CouponRecord> selectByExample(CouponRecordExample example);

    CouponRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouponRecord record, @Param("example") CouponRecordExample example);

    int updateByExample(@Param("record") CouponRecord record, @Param("example") CouponRecordExample example);

    int updateByPrimaryKeySelective(CouponRecord record);

    int updateByPrimaryKey(CouponRecord record);

    List<CouponRecord> getCouponList(Map<String, Object> map);
}