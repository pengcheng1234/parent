package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.ShareActivityOrderStatistics;
import com.jd.m.cms.bjshare.domain.vo.CouponDataVo;
import com.jd.m.cms.bjshare.domain.vo.OrderDataVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShareActivityOrderStatisticsDao {
    int deleteByPrimaryKey(Long id);

    int insertSelective(ShareActivityOrderStatistics record);

    ShareActivityOrderStatistics selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShareActivityOrderStatistics record);

	List<OrderDataVo> getOrderList(Map<String, Object> map);

	List<CouponDataVo> getCouponList(Map<String, Object> map);
}