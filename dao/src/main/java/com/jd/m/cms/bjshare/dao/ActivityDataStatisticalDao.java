package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.ActivityDataStatistical;
import com.jd.m.cms.bjshare.domain.vo.ActivityDataStatisticalExtend;
import com.jd.m.cms.bjshare.domain.vo.UvData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ActivityDataStatisticalDao {

    void  excuteSql(@Param("sql") String  sql);

//    二期时间查询合并到一个方法 by lipengcheng 2018.7.19
    List<ActivityDataStatisticalExtend> getAllDataListByDate(Map<String, Object> map);

    // 删除数据
    int test(Map<String, Object> map);

    //统计设计商品数量 by lipengcheng
    List<ActivityDataStatisticalExtend> getGoodsNum(Map<String, Object> map);

    //统计参与店铺/ERP数量
    int  getShopOrErpSum(Map<String, Object> map);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(ActivityDataStatistical record);

    ActivityDataStatistical selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivityDataStatistical record);

	List<ActivityDataStatisticalExtend> getDataListByDate(Map<String, Object> map);

    long getDataListCountByDate(Map<String, Object> map);

    //按活动分组查数据看板列表 by lipengcheng 2018.8.14
    List<ActivityDataStatisticalExtend> getActivityListByDate(Map<String, Object> map);

	List<ActivityDataStatistical> getDataListByActivityId(Map<String, Object> map);

	List<ActivityDataStatisticalExtend> getBizList(Map<String, Object> map);

    List<ActivityDataStatistical> getYesterdayByActivityId(Map<String, Object> map);

    //统计活动维度的点击cionUV
    List<UvData> countClick_number_uv(Map<String, Object> condition);

    //统计活动总和的点击cionUV
    List<UvData> getClickNumberUv(Map<String, Object> mapParam);
    //统查询总分享成功UV
    List<UvData> getShareSuccessUv(Map<String, Object> mapParam);
    //线程查询分享者打开UV
    List<UvData> getShareOpenUv(Map<String, Object> mapParam);
    //线程查询被分享者打开UV
    List<UvData> getSharedOpenUv(Map<String, Object> mapParam);



}