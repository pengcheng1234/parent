package com.jd.m.bjshare.databoard.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jd.m.cms.bjshare.client.activity.SelfItemCateJsfService;
import com.jd.m.cms.bjshare.client.databoard.DataStatisticalJsfService;
import com.jd.m.cms.bjshare.common.result.ResultCode;
import com.jd.m.cms.bjshare.common.result.ResultData;
import com.jd.m.cms.bjshare.common.utils.DateUtil;
import com.jd.m.cms.bjshare.common.utils.JsonUtil;
import com.jd.m.cms.bjshare.dao.ActivityDataStatisticalAdditionalMapper;
import com.jd.m.cms.bjshare.dao.ActivityDataStatisticalDao;
import com.jd.m.cms.bjshare.dao.CouponRecordMapper;
import com.jd.m.cms.bjshare.dao.ShareActivityOrderStatisticsDao;
import com.jd.m.cms.bjshare.domain.bean.SkuValidateResult;
import com.jd.m.cms.bjshare.domain.po.ActivityDataStatistical;
import com.jd.m.cms.bjshare.domain.po.CouponRecord;
import com.jd.m.cms.bjshare.domain.po.CouponRecordExample;
import com.jd.m.cms.bjshare.domain.po.ShareActivityOrderStatistics;
import com.jd.m.cms.bjshare.domain.vo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by LPC on 2018/6/29
 * 时间和活动维度的统计和分页展示
 */
@Service
public class DataStatisticalJsfServiceImpl implements DataStatisticalJsfService {

    private static final Logger log = Logger.getLogger(DataStatisticalJsfServiceImpl.class);

    @Autowired
    private ActivityDataStatisticalDao adsDao;
    @Autowired
    private ShareActivityOrderStatisticsDao sosDao;
    @Autowired
    private CouponRecordMapper couponRecordMapper;

//    @Autowired
//    private ActivityDataStatisticalAdditionalMapper additionalMapper;


    @Resource
    private SelfItemCateJsfService selfItemCateJsfService;

    private static ExecutorService executor = Executors.newFixedThreadPool(4);

    @Override
    public String excuteSql(String sql) {
        System.out.println("asdkfjaklsdfj");
        adsDao.excuteSql(sql);
        return "ok";

    }
    @Override
    public int test(Map<String, Object> map) {
        int a=adsDao.test(map);
//        int b=additionalMapper.test(map);
        return a;

    }



    @Override
    public ResultData getAllDataListByDate(Map<String, Object> map) {
        ResultData resultData = new ResultData();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        ActivityDataCountVo activityDataCountVo = new ActivityDataCountVo();
        PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));
        List<ActivityDataStatisticalExtend> listStatistical = adsDao.getAllDataListByDate(map);//没有分页的统计信息
        PageInfo<ActivityDataStatisticalExtend> pageInfo = new PageInfo<ActivityDataStatisticalExtend>(listStatistical);
        if (listStatistical != null && listStatistical.size() > 0) {
            if (map.get("Type").toString().equals("3")) {
                for (ActivityDataStatisticalExtend dto : listStatistical) {//把商品分类英语转化为中文
//                    String category = dto.getCategory();
//                    if(category.contains(",")){
//                        String[] item = category.split(",");
//                        String itemCategory = selfItemCateJsfService.getCategory(item);
//                        dto.setCategory(itemCategory);
//                    }
                }
            }
            activityDataCountVo = changeAllCountResult(map, listStatistical);//统计求和
        }
        log.error("二期时间查询合并到一个方法结果impl========================" + JsonUtil.write2JsonStr(activityDataCountVo));
        resultData.setCode(ResultCode.success.getCode());
        resultData.setMessage(ResultCode.success.getMessage());
        resultMap.put("pageInfo", pageInfo);
        resultMap.put("activityDataCountVo", activityDataCountVo);
        resultData.setResult(resultMap);
        return resultData;
    }

    //按日期分组查数据看板列表 by lipengcheng
    @Override
    public ResultData getDataListByDate(Map<String, Object> map) {
        ResultData resultData = new ResultData();
        Map<String, Object> resultMap = new HashMap<String, Object>();

        final Map<String,Object> mapParam=map;
        final int pageNum=(int)map.get("pageNum");
        final int pageSize=(int)map.get("pageSize");
        Future<ActivityDataStatisticalExtend> activityDataCountVo=  executor.submit(new Callable<ActivityDataStatisticalExtend>() {
            @Override
            public ActivityDataStatisticalExtend call() throws Exception {
                System.out.println("线程——按时间维度查询统计");
                return changeCountResult(mapParam,"time");//没有分页的统计信息
            }
        });
        Future<com.jd.m.cms.bjshare.domain.vo.PageInfo<ActivityDataStatisticalExtend>> listStatistical=  executor.submit(new Callable<com.jd.m.cms.bjshare.domain.vo.PageInfo<ActivityDataStatisticalExtend>>() {
            @Override
            public com.jd.m.cms.bjshare.domain.vo.PageInfo<ActivityDataStatisticalExtend> call() throws Exception {
                mapParam.put("groupby",1);
                int pageNum=((Integer) mapParam.get("pageNum")-1)*(Integer) mapParam.get("pageSize");
                int pageSize=(Integer) mapParam.get("pageSize");
                mapParam.put("pageNum", pageNum);
                mapParam.put("pageSize", pageSize);
                System.out.println("线程——按时间维度查询列表mapParam:"+mapParam);
//                PageHelper.startPage((Integer) mapParam.get("pageNum"), (Integer) mapParam.get("pageSize"));
                List<ActivityDataStatisticalExtend> listStatisticalResult= adsDao.getDataListByDate(mapParam);//没有分页的统计信息
                long total= adsDao.getDataListCountByDate(mapParam);//总条数
//                System.out.println("线程——按时间维度查询列表listStatisticalResult:"+JsonUtil.write2JsonStr(listStatisticalResult));
                com.jd.m.cms.bjshare.domain.vo.PageInfo pageInfo=new com.jd.m.cms.bjshare.domain.vo.PageInfo(listStatisticalResult,pageNum,pageSize,total);
                System.out.println("pageNum--pageSize:"+ mapParam.get("pageNum"));
//                PageInfo<ActivityDataStatisticalExtend> pageInfo = new PageInfo<ActivityDataStatisticalExtend>(listStatisticalResult);


                if(listStatisticalResult!=null&&listStatisticalResult.size()>0){
                    System.out.println("线程——按时间维度查询列表数据pageInfo"+JsonUtil.write2JsonStr(pageInfo));
                }else{
                    System.out.println("线程——按时间维度查询列表的数量="+0);
                }
                return pageInfo;
            }
        });




//        PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));
//        List<ActivityDataStatisticalExtend> listStatistical = adsDao.getDataListByDate(map);//没有分页的统计信息
//        ActivityDataStatisticalExtend activityDataCountVo = changeCountResult(map);//统计求和
//        System.out.println("按日期分组——采销统计值 ========================" + JsonUtil.write2JsonStr(activityDataCountVo));
//        PageInfo<ActivityDataStatisticalExtend> pageInfo = new PageInfo<ActivityDataStatisticalExtend>(listStatistical);
        try {

            resultData.setCode(ResultCode.success.getCode());
            resultData.setMessage(ResultCode.success.getMessage());
            resultMap.put("pageInfo", listStatistical.get());
            resultMap.put("activityDataCountVo", activityDataCountVo.get());
            resultData.setResult(resultMap);
        }catch (Exception e){
            System.out.println("发生异常"+ e.getMessage());
        }
        return resultData;
    }


    //按活动分组查数据看板列表 by lipengcheng
    @Override
    public ResultData getActivityListByDate(Map<String, Object> map) {
        System.out.println("线程——按活动维度查询传递的参数=" + JsonUtil.write2JsonStr(map));
        ResultData resultData = new ResultData();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));

        final Map<String,Object> mapParam1= new HashMap<String, Object>();
        mapParam1.putAll(map);
        final Map<String,Object> mapParam2=new HashMap<String, Object>();
        mapParam2.putAll(map);

        Future<ActivityDataStatisticalExtend> activityDataCountVo = executor.submit(new Callable<ActivityDataStatisticalExtend>() {
            @Override
            public ActivityDataStatisticalExtend call() throws Exception {
                return changeCountResult(mapParam1,"acticity");//没有分页的统计信息
            }
        });
        Future<PageInfo<ActivityDataStatisticalExtend>> listStatistical = executor.submit(new Callable<PageInfo<ActivityDataStatisticalExtend>>() {
            @Override
            public PageInfo<ActivityDataStatisticalExtend> call() throws Exception {
                mapParam2.put("groupby",1);
                long startTime=System.currentTimeMillis();
                PageHelper.startPage((Integer) mapParam2.get("pageNum"), (Integer) mapParam2.get("pageSize"));
                List<ActivityDataStatisticalExtend> listStatisticalResult = adsDao.getActivityListByDate(mapParam2);//没有分页的统计信息
                PageInfo<ActivityDataStatisticalExtend> pageInfo = new PageInfo<ActivityDataStatisticalExtend>(listStatisticalResult);
                if(pageInfo.getList()!=null && pageInfo.getList().size()>0){
                    getListUv(pageInfo, mapParam2);
                }
                long endTime=System.currentTimeMillis();
                System.out.println("线程——按活动维度查询列表需要时间=" + (endTime-startTime));
                if (listStatisticalResult != null && listStatisticalResult.size() > 0) {
                    System.out.println("线程——按活动维度查询列表size=" + JsonUtil.write2JsonStr(pageInfo.getList().size()));
                } else {
                    System.out.println("线程——按活动维度查询列表的数量=" + 0);
                }
                return pageInfo;
            }
        });
        try {
            resultData.setCode(ResultCode.success.getCode());
            resultData.setMessage(ResultCode.success.getMessage());
            resultMap.put("activityDataCountVo", activityDataCountVo.get());
            resultMap.put("pageInfo", listStatistical.get());
            resultData.setResult(resultMap);
        }catch (InterruptedException e) {
            System.out.println("活动维度统计"+e);
        } catch (ExecutionException e) {
            System.out.println("活动维度统计"+e);
        }
        return resultData;
    }

    //获取活动id和统计各UV
    public void getListUv(PageInfo pageInfo, Map<String, Object> Map) {
        String startDate=DateUtil.timeStamp2Date(Map.get("startDate").toString(),"yyyy-MM-dd HH:mm:ss");
        String endDate=DateUtil.timeStamp2Date(Map.get("endDate").toString(),"yyyy-MM-dd HH:mm:ss");
        Map.put("startDate",startDate);
        Map.put("endDate",endDate);
        List<ActivityDataStatisticalExtend> list = pageInfo.getList();
        System.out.println("前pageInfo==============="+JsonUtil.write2JsonStr(pageInfo));
        Set<Long> activityIds = new HashSet<Long>();
        for (ActivityDataStatisticalExtend dto : list) {
            activityIds.add(dto.getActivityId());
        }
        Map.put("activityIds", activityIds);
        List<Future<List<UvData>>> listExecutor = new ArrayList<Future<List<UvData>>>();
        for (int i = 0; i < 4; i++) {
            final Map<String, Object> mapParam = Map;
            final int iParam = i;
            System.out.println("列表统计UV启动线程"+i);
            Future<List<UvData>> future = executor.submit(
                    new Callable<List<UvData>>() {
                        @Override
                        public List<UvData> call() throws Exception {
                            return getData(mapParam, iParam);
                        }
                    }
            );
            listExecutor.add(future);
        }
        for (int i=0;i<listExecutor.size();i++) {//遍历多线程返回的结果
            try {
                if(i==0){//分享有礼点击UV
                    List<UvData> listResult=(List<UvData>)listExecutor.get(i).get();
                    System.out.println("单个线程返回的点击IconUV结果"+JsonUtil.write2JsonStr(listResult));
                    for(ActivityDataStatisticalExtend dto : list){
                        for(UvData uv:listResult){
                            if(dto.getActivityId().equals(uv.getActivityId())){
                                dto.setClickNumberUv(uv.getUvNum());
                                break;
                            }
                        }
                    }
                }else if(i==1){//分享成功次数UV
                    List<UvData> listResult=(List<UvData>)listExecutor.get(i).get();
                    System.out.println("单个线程返回的分享成功次数UV结果"+JsonUtil.write2JsonStr(listResult));
                    for(ActivityDataStatisticalExtend dto : list){
                        for(UvData uv:listResult){
                            if(dto.getActivityId().equals(uv.getActivityId())){
                                dto.setShareSuccessUv(uv.getUvNum());
                                break;
                            }
                        }
                    }
                } else if (i == 2) {//分享者打开UV
                    List<UvData> listResult=(List<UvData>)listExecutor.get(i).get();
                    System.out.println("单个线程返回的分享者打开UV结果"+JsonUtil.write2JsonStr(listResult));
                    for(ActivityDataStatisticalExtend dto : list){
                        for(UvData uv:listResult){
                            if(dto.getActivityId().equals(uv.getActivityId())){
                                dto.setShareOpenUv(uv.getUvNum());
                                break;
                            }
                        }
                    }
                } else if (i == 3) {//被分享者打开UV
                    List<UvData> listResult=(List<UvData>)listExecutor.get(i).get();
                    System.out.println("单个线程返回的被分享者打开UV结果"+JsonUtil.write2JsonStr(listResult));
                    for(ActivityDataStatisticalExtend dto : list){
                        for(UvData uv:listResult){
                            if(dto.getActivityId().equals(uv.getActivityId())){
                                dto.setSharedOpenUv(uv.getUvNum());
                                dto.setOpenSuccessUv(dto.getShareOpenUv()+dto.getSharedOpenUv());
                                break;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("获取线程返回结果出错了"+e);
            }
        }
        System.out.println("后pageInfo==============="+JsonUtil.write2JsonStr(pageInfo));
    }

    public List<UvData> getData(Map<String, Object> map, int i) {
        map.put("groupby",1);
        List<UvData> list =new ArrayList<UvData>() ;
        if (i == 0) {//分享有礼点击UV
            list=adsDao.getClickNumberUv(map);
            System.out.println("分享有礼点击UV==============="+JsonUtil.write2JsonStr(list));
        } else if (i == 1) {//分享成功次数UV
            list=adsDao.getShareSuccessUv(map);
            System.out.println("分享成功次数UV==============="+JsonUtil.write2JsonStr(list));
        } else if (i == 2) {//分享者打开UV
            list=adsDao.getShareOpenUv(map);
            System.out.println("分享者打开UV==============="+JsonUtil.write2JsonStr(list));
        } else if (i == 3) {//被分享者打开UV
            list=adsDao.getSharedOpenUv(map);
            System.out.println("被分享者打开UV==============="+JsonUtil.write2JsonStr(list));
        }
        return list;
    }

    @Override
    public ResultData getDataListByActivityId(Map<String, Object> map) {
        ResultData resultData = new ResultData();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<ActivityDataStatistical> listStatistical = adsDao.getDataListByActivityId(map);//没有分页的统计信息
//        ActivityDataCountVo activityDataCountVo = changeCountResult(map, listStatistical);//统计求和
//        log.error("活动维度统计的结果========================" + JsonUtil.write2JsonStr(activityDataCountVo));
        PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));
        List<ActivityDataStatistical> list = adsDao.getDataListByActivityId(map);
        PageInfo<ActivityDataStatistical> pageInfo = new PageInfo<ActivityDataStatistical>(list);
        resultData.setCode(ResultCode.success.getCode());
        resultData.setMessage(ResultCode.success.getMessage());
        resultMap.put("pageInfo", pageInfo);
//        resultMap.put("activityDataCountVo", activityDataCountVo);
        resultData.setResult(resultMap);
        return resultData;
    }


    /**
     * 查看sku的数据列表——采销 by  lipengchneg 2018.8.20
     */
    @Override
    public ResultData getBizList(Map<String, Object> map) {
        ResultData resultData = new ResultData();
        PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));
        List<ActivityDataStatisticalExtend> list = adsDao.getBizList(map);
        PageInfo<ActivityDataStatisticalExtend> pageInfo = new PageInfo<ActivityDataStatisticalExtend>(list);
        resultData.setCode(ResultCode.success.getCode());
        resultData.setMessage(ResultCode.success.getMessage());
        resultData.setResult(pageInfo);
        return resultData;
    }

    @Override
    public ResultData getOrderList(Map<String, Object> map) {
        ResultData resultData = new ResultData();
        PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));
        List<OrderDataVo> list = sosDao.getOrderList(map);
        PageInfo<OrderDataVo> pageInfo = new PageInfo<OrderDataVo>(list);
        resultData.setCode(ResultCode.success.getCode());
        resultData.setMessage(ResultCode.success.getMessage());
        resultData.setResult(pageInfo);
        return resultData;
    }

    //优惠券和订单数据 by lipengcheng 2018.9.10
    @Override
    public ResultData getCouponList(Map<String, Object> map) {
        ResultData resultData = new ResultData();
        PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));

        List<CouponRecord> list = couponRecordMapper.getCouponList(map);
        PageInfo<CouponRecord> pageInfo = new PageInfo<CouponRecord>(list);
        resultData.setCode(ResultCode.success.getCode());
        resultData.setMessage(ResultCode.success.getMessage());
        resultData.setResult(pageInfo);
        return resultData;
    }

    @Override
    public int insertSelective(ActivityDataStatistical record) {
        return adsDao.insertSelective(record);
    }

    @Override
    public int insertOrder(ShareActivityOrderStatistics record) throws Exception {
        return sosDao.insertSelective(record);
    }

    @Override
    public ResultData getYesterdayByActivityId(Map<String, Object> map) {
        List<ActivityDataStatistical> lis1 = new ArrayList<ActivityDataStatistical>();
        ActivityDataStatistical dto1 = new ActivityDataStatistical();
        dto1.setActivityId(1L);
        dto1.setBizid("12");
        lis1.add(dto1);
        ActivityDataStatistical dto2 = new ActivityDataStatistical();
        dto2.setActivityId(99L);
        dto2.setBizid("11");
        lis1.add(dto2);
        map.put("list", lis1);
        String todayBegin = "2018-01-01 00:00:00";
        String todayEnd = "2018-09-01 00:00:00";
        map.put("todayBegin", todayBegin);
        map.put("todayEnd", todayEnd);

        List<ActivityDataStatistical> list1 = adsDao.getYesterdayByActivityId(map);
        ResultData RR = new ResultData();
        RR.setResult(list1);

        return RR;
    }

    private ActivityDataStatisticalExtend changeCountResult(Map<String, Object> map,String type) {
        ActivityDataStatisticalExtend extend = new ActivityDataStatisticalExtend();
        map.put("groupby", null);
        if("time".equals(type)) {
            //时间维度
            List<ActivityDataStatisticalExtend> extendList = adsDao.getDataListByDate(map);//没有分页的统计信息
            if (extendList != null && extendList.size() > 0) {
                extend = extendList.get(0);
            }
        }
        //活动维度
        if("acticity".equals(type)){
            final Map<String,Object> mapParamDto=new HashMap<String, Object>();
            final Map<String,Object> mapParam=new HashMap<String, Object>();
            String startDate=DateUtil.timeStamp2Date(map.get("startDate").toString(),"yyyy-MM-dd HH:mm:ss");
            String endDate=DateUtil.timeStamp2Date(map.get("endDate").toString(),"yyyy-MM-dd HH:mm:ss");
            mapParamDto.putAll(map);
            mapParam.putAll(map);
            mapParam.put("startDate",startDate);
            mapParam.put("endDate",endDate);
            //1.没有分页的统计信息
            Future<ActivityDataStatisticalExtend> statisticalExtend = executor.submit(new Callable<ActivityDataStatisticalExtend>() {
                @Override
                public ActivityDataStatisticalExtend call() throws Exception {
                    return getStatisticalSum(mapParamDto);
                }
            });
            //2.线程查询总和分享有礼点击UV
            Future<UvData> clickNumberUv = executor.submit(new Callable<UvData>() {
                @Override
                public UvData call() throws Exception {
                    return getClickNumberUv(mapParam);
                }
            });
            //3.线程查询总分享成功UV
            Future<UvData> shareSuccessUv = executor.submit(new Callable<UvData>() {
                @Override
                public UvData call() throws Exception {
                    return getShareSuccessUv(mapParam);
                }
            });
            //4.线程查询分享者打开UV
            Future<UvData> shareOpenUv = executor.submit(new Callable<UvData>() {
                @Override
                public UvData call() throws Exception {
                    return getShareOpenUv(mapParam);
                }
            });
            //5.线程查询被分享者打开UV
            Future<UvData> sharedOpenUv = executor.submit(new Callable<UvData>() {
                @Override
                public UvData call() throws Exception {
                    return getSharedOpenUv(mapParam);
                }
            });
            try {
                extend=statisticalExtend.get();
                extend.setClickNumberUv(clickNumberUv.get().getUvNum());
                extend.setShareSuccessUv(shareSuccessUv.get().getUvNum());
                extend.setSharedOpenNum(sharedOpenUv.get().getUvNum());
                extend.setShareOpenUv(shareOpenUv.get().getUvNum());
                extend.setOpenSuccessUv(sharedOpenUv.get().getUvNum()+shareOpenUv.get().getUvNum());
            } catch (InterruptedException e) {
                log.error("活动维度统计总和出错"+e);
            } catch (ExecutionException e) {
                log.error("活动维度统计总和出错"+e);
            }
        }
        System.out.println("返回的统计和对象===="+JsonUtil.write2JsonStr(extend));
        return extend;
    }

    //1.没有分页的统计信息
    private ActivityDataStatisticalExtend getStatisticalSum(Map<String,Object> mapParam){
        ActivityDataStatisticalExtend extend = new ActivityDataStatisticalExtend();
        List<ActivityDataStatisticalExtend> extendList = adsDao.getDataListByDate(mapParam);//没有分页的统计信息
        if (extendList != null && extendList.size() > 0) {
            extend = extendList.get(0);
        }
        return extend;
    }
    //2.线程查询总和分享有礼点击UV
    private UvData getClickNumberUv(Map<String,Object> mapParam){
        UvData dto=new UvData();
        List<UvData> list=adsDao.getClickNumberUv(mapParam);
        if(list!=null&& list.size()>0){
            dto=list.get(0);
        }
        return dto;
    }

    //3.线程查询总分享成功UV——share_success_uv
    private UvData getShareSuccessUv(Map<String,Object> mapParam){
        UvData dto=new UvData();
        List<UvData> list=adsDao.getShareSuccessUv(mapParam);
        if(list!=null&& list.size()>0){
            dto=list.get(0);
        }
        return dto;
    }
    //4.线程查询分享者打开UV
    private UvData getSharedOpenUv(Map<String,Object> mapParam){
        UvData dto=new UvData();
        List<UvData> list=adsDao.getSharedOpenUv(mapParam);
        if(list!=null&& list.size()>0){
            dto=list.get(0);
        }
        return dto;
    }
    //5.线程查询被分享者打开UV
    private UvData getShareOpenUv(Map<String,Object> mapParam){
        UvData dto=new UvData();
        List<UvData> list=adsDao.getShareOpenUv(mapParam);
        if(list!=null&& list.size()>0){
            dto=list.get(0);
        }
        return dto;
    }


    private ActivityDataCountVo changeAllCountResult(Map<String, Object> map, List<ActivityDataStatisticalExtend> list) {
        ActivityDataCountVo activityDataCountVo = new ActivityDataCountVo();
        return activityDataCountVo;
    }


    //获取pop的商品数量 bylipengcheng 2018.7.24
    private int getPopGoodsNum(Map<String, Object> map) {
        int goodsNum = 0;
        List<ActivityDataStatisticalExtend> listGoodsNum = adsDao.getGoodsNum(map);
        if (listGoodsNum != null && listGoodsNum.size() > 0) {
            for (ActivityDataStatisticalExtend dto : listGoodsNum) {
                goodsNum += dto.getGoodsNum();
            }
        }
        return goodsNum;
    }

    //获取自营的商品数量 bylipengcheng 2018.7.24
    private int getOperationGoodsNum(Map<String, Object> map) {
        int goodsNum = 0;
//        List<ActivityDataStatisticalExtend> listGoodsNum = adsDao.getGoodsNum(map);
//        if (listGoodsNum != null && listGoodsNum.size() > 0) {
//            goodsNum = listGoodsNum.get(0).getGoodsNum();
//        }
        return goodsNum;
    }

    //获取pop+自营的商品数量 bylipengcheng 2018.7.24
    private int getAllGoodsNum(Map<String, Object> map) {
        int goodsNum = 0;
        map.put("activityType", 0);
        goodsNum += getOperationGoodsNum(map);
        map.put("activityType", 1);
        goodsNum += getOperationGoodsNum(map);
        return goodsNum;
    }

}