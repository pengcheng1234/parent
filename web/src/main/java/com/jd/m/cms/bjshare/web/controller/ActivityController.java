package com.jd.m.cms.bjshare.web.controller;


import com.jd.m.cms.bjshare.client.activity.ShareActivityCommonService;
import com.jd.m.cms.bjshare.client.checkFlow.CheckFlowJsfService;
import com.jd.m.cms.bjshare.client.dto.JsfResultData;
import com.jd.m.cms.bjshare.common.result.ResultCode;
import com.jd.m.cms.bjshare.common.result.ResultData;
import com.jd.m.njf.server.client.util.JsonUtil;
import com.jd.m.cms.bjshare.domain.po.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Controller
@RequestMapping("/activity")
public class ActivityController {

	@Resource
	private ShareActivityCommonService shareActivityCommonService;

	@Resource
	private CheckFlowJsfService checkFlowJsfService;





	/**
	 * 更新活动审批状态和各审批信息 by lipengcheng 2018.7.6
	 * 参数活动id,审批内容，审批结果
	 */
	@RequestMapping(value = "/updateCheckFlow.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateCheckFlow(HttpServletRequest request, Integer activityId, Integer checkResult, String checkMessage) {
		ResultData resultData = new ResultData();
//		UserVo userVo = UserInfo.getUserVo(request);
//		if (userVo == null) {
//			resultData.setCode(ResultCode.EMPTY_COOKIE.getCode());
//			resultData.setMessage(ResultCode.EMPTY_COOKIE.getMessage());
//			return JsonUtil.write2JsonStr(resultData);
//		}
		if (activityId == null || checkResult == null || checkMessage == null) {
			resultData.setCode(ResultCode.paramError.getCode());
			resultData.setMessage(ResultCode.paramError.getMessage());
			return JsonUtil.write2JsonStr(resultData);
		}
		try {
			//1.更新审批信息
			CheckFlow checkFlow = new CheckFlow();
			checkFlow.setActivityId(activityId);
//			checkFlow.setCheckErp(userVo.getErp());
			checkFlow.setCheckErp(request.getParameter("erp"));/////////////////////////////////
			checkFlow.setCheckComment(checkMessage);
			checkFlow.setCheckResult(checkResult);
			checkFlowJsfService.updateCheckFlow(checkFlow);
			//2.活动审批结果
			if (checkResult == 2) {//0:未审批，1：审批通过，2:审批未通过'
				//更新活动审批状态为未通过
				ShareActivity shareActivity = new ShareActivity();
				shareActivity.setId((long) checkFlow.getActivityId());
				shareActivity.setAuditStatus((byte) 2);
				shareActivityCommonService.updateByPrimaryKeySelective(shareActivity);
			} else {
				CheckFlowExample example = new CheckFlowExample();
				example.setOrderByClause("last_check_person");
				CheckFlowExample.Criteria criteria = example.createCriteria();
				criteria.andActivityIdEqualTo(checkFlow.getActivityId());//只通过活动ID查询审批集合
				JsfResultData result = checkFlowJsfService.selectByExample(example);
				List<CheckFlow> list = (List<CheckFlow>) result.getResult();
				if (list != null && list.size() > 0) {
					//审批人是否全部审批完毕
					boolean ifAllCheck = true;
					for (CheckFlow dto : list) {
						if (dto.getCheckResult() == 0) {//0:未审批，1：审批通过，2:审批未通过'
							ifAllCheck = false;
						}
					}
					if (ifAllCheck) {//全部审批完毕
						ShareActivity shareActivity = new ShareActivity();
						shareActivity.setId((long) checkFlow.getActivityId());
						shareActivity.setAuditStatus((byte) 1);
						shareActivityCommonService.updateByPrimaryKeySelective(shareActivity);
					}
				}
			}
		} catch (Exception e) {
			resultData.setCode(ResultCode.sysError.getCode());
			resultData.setMessage(ResultCode.sysError.getMessage());
		}
		return JsonUtil.write2JsonStr(resultData);
	}






}
