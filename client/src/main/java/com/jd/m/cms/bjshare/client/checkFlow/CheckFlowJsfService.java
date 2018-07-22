package com.jd.m.cms.bjshare.client.checkFlow;

import com.jd.m.cms.bjshare.client.dto.JsfResultData;
import com.jd.m.cms.bjshare.common.spring.JsfException;
import com.jd.m.cms.bjshare.domain.po.CheckFlow;
import com.jd.m.cms.bjshare.domain.po.CheckFlowExample;

import java.util.List;

/**
 * 审批流程
 * Created by lipengcheng on 2018/7/4.
 */
public interface CheckFlowJsfService {

  /**
   * 插入
   * @param
   * @return
   */
    public JsfResultData insertCheckFlow(List<CheckFlow> list) throws JsfException;

  /**
   * 更新
   * @param
   * @return
   */
  public JsfResultData  updateCheckFlow(CheckFlow checkFlow) throws JsfException;

  /**
   * 活动对应的流程信息
   * @param
   * @return
   */
  public JsfResultData  getCheckFlow(String erp, Long activtyId) throws JsfException;

  /**
   * 查询审批流程集合
   * @param
   * @return
   */
  public JsfResultData  selectByExample(CheckFlowExample example) throws JsfException;
}
