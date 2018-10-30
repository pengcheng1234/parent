package com.jd.m.bjshare.databoard.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jd.m.cms.bjshare.client.databoard.ExcelJsfService;
import com.jd.m.cms.bjshare.dao.ActivityDataStatisticalDao;
import com.jd.m.cms.bjshare.dao.ShareActivityDao;
import com.jd.m.cms.bjshare.dao.ShareActivityOrderStatisticsDao;
import com.jd.m.cms.bjshare.domain.po.ActivityDataStatistical;
import com.jd.m.cms.bjshare.domain.po.CouponRecord;
import com.jd.m.cms.bjshare.domain.po.ShareActivity;
import com.jd.m.cms.bjshare.domain.vo.ActivityDataStatisticalExtend;
import com.jd.m.cms.bjshare.domain.vo.CouponDataVo;
import com.jd.m.cms.bjshare.dao.CouponRecordMapper;
import com.jd.m.cms.bjshare.domain.vo.OrderDataVo;
import com.jd.m.cms.bjshare.domain.vo.export.excelShareActivity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by LPC on 2018/6/29
 */
@Service
public class ExcelServiceJspImpl implements ExcelJsfService {

    private static final Logger log = Logger.getLogger(ExcelServiceJspImpl.class);

    @Autowired
    private ShareActivityOrderStatisticsDao sosDao;

    @Autowired
    private ActivityDataStatisticalDao adsDao;

    @Autowired
    private ShareActivityDao shareActivityDao;

    @Autowired
    private  CouponRecordMapper couponRecordMapper;



    @Override
    public List<OrderDataVo> getOrderList(Map<String, Object> map) {
        List<OrderDataVo> list =  sosDao.getOrderList(map);
        return list;
    }

    /**
     * 查询优惠券列表
     */
    @Override
    public  List<CouponRecord> getCouponList(Map<String, Object> map) {
        List<CouponRecord> list =  couponRecordMapper.getCouponList(map);
        return list;
    }

    @Override
    public List<ActivityDataStatisticalExtend> getDataListByDate(Map<String, Object> map) {
        List<ActivityDataStatisticalExtend> list =  adsDao.getDataListByDate(map);
        return list;
    }

    @Override
    public List<ActivityDataStatisticalExtend> getActivityListByDate(Map<String, Object> map) {
        List<ActivityDataStatisticalExtend> list =  adsDao.getActivityListByDate(map);
        return list;
    }


    @Override
    public PageInfo<ActivityDataStatistical> getDataListByActivityId(Map<String, Object> map) {
        PageHelper.startPage((Integer) map.get("pageNum"), (Integer)map.get("pageSize"));
        List<ActivityDataStatistical> list = adsDao.getDataListByActivityId(map);
        PageInfo<ActivityDataStatistical> pageInfo = new PageInfo<ActivityDataStatistical>(list);
        return pageInfo;
    }

    @Override
    public List<ActivityDataStatisticalExtend> getBizList(Map<String, Object> map) {
        List<ActivityDataStatisticalExtend> list =  adsDao.getBizList(map);
        return list;
    }

    @Override
    public List<ShareActivity> exceldataData(Map<String, Object> map) {
        List<ShareActivity> list =  shareActivityDao.exceldataData(map);
        return list;
    }

    @Override
    public List<excelShareActivity> excelDate(Map<String, Object> map) {
        List<excelShareActivity> list =  shareActivityDao.excelDate(map);
        return list;
    }


}
