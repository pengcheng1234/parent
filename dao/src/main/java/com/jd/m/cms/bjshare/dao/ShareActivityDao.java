package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.ShareActivity;
import com.jd.m.cms.bjshare.domain.vo.ActivityFullInfoVo;
import com.jd.m.cms.bjshare.domain.vo.AddActivityVo;
import com.jd.m.cms.bjshare.domain.vo.export.excelShareActivity;
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
	 * bizId是否已参加活动
	 * @param map
	 * @return
	 */
	Integer bizIdIsInActivity(Map<String, Object> map);

    /**
     * 批量查询bizId是否已参加活动（返回的是不符合要求的数据）
     *
     * @param map
     * @return
     */
    List<String> batchBizIdIsInActivity(Map<String, Object> map);


	List<ShareActivity> exceldataData(Map<String, Object> map);

	/**
	 * 武靖文导出数据专用 by lipengcheng 2018.09.13
	 */
	List<excelShareActivity> excelDate(Map<String, Object> map);
}