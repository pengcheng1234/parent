package com.jd.m.cms.bjshare.client.activity;

import com.jd.m.cms.bjshare.common.result.ResultData;
import com.jd.m.cms.bjshare.domain.po.ShareActivity;
import com.jd.m.cms.bjshare.domain.vo.IdsAndAuditStatus;

import java.util.List;
import java.util.Map;

public interface ShareActivityCommonService {


	/**
	 * 更新活动审批状态 by lipengcheng 2018.7.6
	 */
	ResultData updateByPrimaryKeySelective(ShareActivity shareActivity);

	/**
	 * 获取pop商品id的数据列表
	 */
	ShareActivity getThingIdsListByPop(Map<String, Object> map);
	/**
	 * 通过运维活动id获取的商品id数据列表
	 */
	List<IdsAndAuditStatus> getThingIdsListByOperation(Map<String, Object> map);





}
