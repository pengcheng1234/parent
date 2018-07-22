package com.jd.m.bjshare.activity.client.service.impl;

import com.jd.m.cms.bjshare.client.checkFlow.CheckFlowJsfService;
import com.jd.m.cms.bjshare.client.dto.JsfResultData;
import com.jd.m.cms.bjshare.common.result.ResultCode;
import com.jd.m.cms.bjshare.dao.CheckFlowMapper;
import com.jd.m.cms.bjshare.dao.ShareActivityDao;
import com.jd.m.cms.bjshare.domain.po.CheckFlow;
import com.jd.m.cms.bjshare.domain.po.CheckFlowExample;
import com.jd.m.cms.bjshare.domain.vo.CheckFlowMessage;
import com.jd.m.cms.bjshare.domain.vo.CheckFlowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LPC on 2018/7/4
 */
@Service
public class CheckFlowJsfServiceImpl implements CheckFlowJsfService {

    @Autowired
    private CheckFlowMapper checkFlowMapper;

    @Autowired
    private ShareActivityDao shareActivityDao;

//    @Autowired
//    private PlatformTransactionManager transactionManager;

    /**
     * 插入审批信息
     *
     * @param
     * @return
     */
    @Override
    public JsfResultData insertCheckFlow(List<CheckFlow> list) {
//        TransactionStatus status = null;
        try {
			/* 开启事务 */
//            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//            status = transactionManager.getTransaction(def);
            for (CheckFlow dto : list) {
                checkFlowMapper.insertSelective(dto);
            }
//            transactionManager.commit(status);
        } catch (Exception e) {
//            if(status!=null){
//                transactionManager.rollback(status);
//            }
            return new JsfResultData(e, false, "0", "insertCheckFlow方法请求异常");

        }
        JsfResultData jsfResultData = new JsfResultData();
        jsfResultData.setCode(ResultCode.success.getCode());
        jsfResultData.setSuccess(true);
        jsfResultData.setMessage(ResultCode.success.getMessage());
        jsfResultData.setResult(null);
        return jsfResultData;
    }

    /**
     * 更新审批信息
     *
     * @param
     * @return
     */
    @Override
    public JsfResultData updateCheckFlow(CheckFlow checkFlow) {
//        TransactionStatus status = null;
        try {
			/* 开启事务 */
//            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//            status = transactionManager.getTransaction(def);
            checkFlowMapper.updateByActivityIdSelective(checkFlow);
//            transactionManager.commit(status);
        } catch (Exception e) {
//            if(status!=null){
//                transactionManager.rollback(status);
//                return new JsfResultData(e, false, ResultCode.dbError.getCode(),ResultCode.dbError.getMessage());
//            }
            return new JsfResultData(e, false, "0", "updateCheckFlow方法请求异常");
        }
        JsfResultData jsfResultData = new JsfResultData();
        jsfResultData.setCode(ResultCode.success.getCode());
        jsfResultData.setSuccess(true);
        jsfResultData.setMessage(ResultCode.success.getMessage());
        jsfResultData.setResult(null);
        return jsfResultData;
    }

    /**
     * 活动对应的流程信息
     *
     * @param
     * @return
     */
    @Override
    public JsfResultData getCheckFlow(String erp, Long activtyId) {
        CheckFlowExample example = new CheckFlowExample();
        example.setOrderByClause("last_check_person");
        CheckFlowExample.Criteria criteria = example.createCriteria();
        criteria.andActivityIdEqualTo(activtyId.intValue());//只通过活动ID查询审批集合
        List<CheckFlow> list;
        try {
            list = checkFlowMapper.selectByExample(example);
        } catch (Exception e) {
            return new JsfResultData(e, false, "0", "getCheckFlow方法请求异常");
        }
        //Map<String, Object> map = new HashMap<String, Object>();
        CheckFlowVo checkFlowVo = new CheckFlowVo();
        List checkMessage = new ArrayList();
        boolean ifCheck = false;
        if (list.size() > 0) {
            //显示审批信息
            for (CheckFlow dto : list) {
                CheckFlowMessage message=new CheckFlowMessage();
                message.setMessage(dto.getCheckComment());
                message.setCheckErp(dto.getCheckErp());
                checkMessage.add(message);
            }
            //判断该用户是否有待审批
            for (CheckFlow dto : list) {//0:未审批，1：审批通过，2:审批未通过'
                if (dto.getCheckResult() == 0 && dto.getCheckErp().equals(erp)) {
                    ifCheck = true;
                }
            }
            //前一个审批人是否未通过
            for (CheckFlow dto : list) {//0:未审批，1：审批通过，2:审批未通过'
                if (dto.getCheckResult() == 2) {
                    ifCheck = false;
                }
            }
        }
        //map.put("checkMessage", checkMessage);
        //map.put("ifCheck", ifCheck);
        checkFlowVo.setCheckFlowMessages(checkMessage);
        checkFlowVo.setIfCheck(ifCheck);

        JsfResultData jsfResultData = new JsfResultData();
        jsfResultData.setCode(ResultCode.success.getCode());
        jsfResultData.setSuccess(true);
        jsfResultData.setMessage(ResultCode.success.getMessage());
        jsfResultData.setResult(checkFlowVo);

        return jsfResultData;

    }

    /**
     * 查询审批流程集合
     * @param
     * @return
     */
    public JsfResultData selectByExample(CheckFlowExample example){
        List<CheckFlow> list=new ArrayList<CheckFlow>(3);
        try{
            list=checkFlowMapper.selectByExample(example);
        }catch (Exception e){
            return new JsfResultData(e, false, "0", "getCheckFlow方法请求异常");
        }
        JsfResultData jsfResultData = new JsfResultData();
        jsfResultData.setCode(ResultCode.success.getCode());
        jsfResultData.setSuccess(true);
        jsfResultData.setMessage(ResultCode.success.getMessage());
        jsfResultData.setResult(list);

        return jsfResultData;
    }

}
