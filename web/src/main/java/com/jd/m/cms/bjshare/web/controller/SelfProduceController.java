package com.jd.m.cms.bjshare.web.controller;

import com.jd.jsf.gd.util.JsonUtils;
import com.jd.m.cms.bjshare.client.activity.SelfItemCateJsfService;
import com.jd.m.cms.bjshare.common.result.ResultCode;
import com.jd.m.cms.bjshare.common.result.ResultData;
import com.jd.m.cms.bjshare.domain.po.SelfItemCate;
import com.jd.m.cms.bjshare.domain.vo.CodeAndName;
import com.jd.m.cms.bjshare.domain.vo.UserVo;
import com.jd.m.njf.server.client.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author huanglong
 * @Description: 自营商品的接口
 * @date 2018/6/2014:39
 */
@Controller
@RequestMapping("/selfProduce")
public class SelfProduceController {

    @Resource
    private SelfItemCateJsfService selfItemCateJsfService;

    /**
     * 根据父节点查询子节点 by lipengcheng 2018.7.3
     */
    @RequestMapping(value = "/selectByParentCode.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectByParentCode(HttpServletRequest request, Integer itemFirstCateCd, Integer itemSecondCateCd) {
        if(itemFirstCateCd!=null&&itemSecondCateCd!=null){
            return  JsonUtil.write2JsonStr(new ResultData("1","参数错误：传递的两个参数都有值"));
        }
        ResultData resultData = new ResultData();
        UserVo userVo=new UserVo();
        // cookie中的用户信息
//        UserVo userVo = UserInfo.getUserVo(request);
//        logger.info("UserInfo获取的用户userVo============"+ JsonUtil.write2JsonStr(userVo));
//        Cookie cookie = CookieUtil.getCookieByName(request, "user_inf");
//        logger.info("SelfProduceController中方法cookie=============" + JsonUtil.write2JsonStr(cookie));
//        if (cookie != null) {
//            try {
//                ResultData re = (ResultData) JsonUtil.json2Object(URLDecoder.decode(cookie.getValue(), "UTF-8"), ResultData.class);
//                userVo = (UserVo) JsonUtil.json2Object(JsonUtil.write2JsonStr(re.getResult()), UserVo.class);
//                logger.info("userVo:" + JsonUtil.write2JsonStr(userVo));
//            } catch (Exception e) {
//                logger.info("从cookie中获取用户信息失败：", e);
//            }
//        }
//
//        if (userVo == null) {
//            resultData.setCode(ResultCode.EMPTY_COOKIE.getCode());
//            resultData.setMessage(ResultCode.EMPTY_COOKIE.getMessage());
//            return JsonUtil.write2JsonStr(resultData);
//        }
//        String erp = userVo.getErp();
        SelfItemCate selfItemCate = new SelfItemCate();
//        int leavel = userVo.getLevel();
//        if (leavel == 1) {/* 账号类型 0：运营，1：采销 */
//            selfItemCate.setSalerErpAcct(erp);
//        }
        selfItemCate.setItemFirstCateCd(itemFirstCateCd);
        selfItemCate.setItemSecondCateCd(itemSecondCateCd);
        try {
            List<CodeAndName> listselfItemCate = selfItemCateJsfService.selectByParentCode(selfItemCate);
            resultData.setCode(ResultCode.success.getCode());
            resultData.setMessage(ResultCode.success.getMessage());
            resultData.setResult(JsonUtils.toJSONString(listselfItemCate));
        } catch (Exception e) {
            resultData.setCode(ResultCode.sysError.getCode());
            resultData.setMessage(ResultCode.sysError.getMessage());
            resultData.setResult(e);
        }
        return JsonUtil.write2JsonStr(resultData);
    }

}
