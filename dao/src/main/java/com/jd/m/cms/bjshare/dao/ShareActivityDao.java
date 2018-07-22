package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.ShareActivity;
import com.jd.m.cms.bjshare.domain.vo.ActivityFullInfoVo;
import com.jd.m.cms.bjshare.domain.vo.AddActivityVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShareActivityDao {
    int deleteByPrimaryKey(Long id);

    int insertSelective(ShareActivity record);

    ShareActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShareActivity record);

	List<ShareActivity> queryActivityList(Map<String, Object> map);

	AddActivityVo queryActivityDetail(Long id);

	void updateActivityStatu(Map<String, Object> map);

	/**
	 * 查询该venderId已创建活动的spu和venderId
	 */
	List<ShareActivity> queryExistBiz(Map<String, Object> map);

	List<String> queryDistinctShopId();

	ActivityFullInfoVo queryActivityFullInfo(Map<String, Object> map);

	List<ActivityFullInfoVo> queryActivityFullInfoList(Map<String, Object> map);

	/**
	 * sku是否已参加活动
	 * @param map
	 * @return
	 */
	List<ActivityFullInfoVo> skuIsInActivity(Map<String, Object> map);

	/**
	 * bizId是否已参加活动
	 * @param map
	 * @return
	 */
	List<ActivityFullInfoVo> bizIdIsInActivity(Map<String, Object> map);


}