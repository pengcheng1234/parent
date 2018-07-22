package com.jd.m.bjshare.activity.client.service.impl;


import com.jd.m.cms.bjshare.client.activity.ShareActivityCommonService;
import com.jd.m.cms.bjshare.common.result.ResultCode;
import com.jd.m.cms.bjshare.common.result.ResultData;
import com.jd.m.cms.bjshare.dao.*;
import com.jd.m.cms.bjshare.domain.po.*;
import com.jd.m.cms.bjshare.domain.vo.IdsAndAuditStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.jd.m.cms.bjshare.dao.ActivityBizsMapper;

import java.util.*;

@Service
public class ActivityServiceImpl implements ShareActivityCommonService {

	@Autowired
	private ShareActivityDao shareActivityDao;

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Autowired
	private ActivityBizsMapper activityBizsMapper;

	/**
	 * 更新活动审批状态 by lipengcheng 2018.7.6
	 *
	 * @param shareActivity
	 */
	@Override
	public ResultData updateByPrimaryKeySelective(ShareActivity shareActivity) {
		ResultData resultData = new ResultData();
		TransactionStatus status = null;
		try {
			/* 开启事务 */
			DefaultTransactionDefinition def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(def);
			shareActivityDao.updateByPrimaryKeySelective(shareActivity);
			transactionManager.commit(status);
		} catch (Exception e) {
			if(status!=null){
				transactionManager.rollback(status);
				return  new ResultData(ResultCode.dbError.getCode(), ResultCode.dbError.getMessage(),null);
			}
			resultData.setCode(ResultCode.sysError.getCode());
			resultData.setMessage(ResultCode.sysError.getMessage());
		}
		return resultData;
	}
	/**
	 * 获取商品id的数据列表
	 */
	@Override
	public ShareActivity getThingIdsListByPop(Map<String, Object> map){
		String id=map.get("activityId").toString();
		long aid=Long.valueOf(id);
		ShareActivity dto=shareActivityDao.selectByPrimaryKey(aid);
		return dto;
	}
	/**
	 * 通过运维活动id获取的商品id数据列表
	 */
	@Override
	public List<IdsAndAuditStatus> getThingIdsListByOperation(Map<String, Object> map){
		List<IdsAndAuditStatus> list =activityBizsMapper.getThingIdsListByOperation(map);
		return list;
	}


}
