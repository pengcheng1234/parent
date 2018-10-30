package com.jd.m.cms.bjshare.web.controller;

import com.github.pagehelper.PageInfo;
import com.jd.m.bjshare.whiteList.WhiteListService;
import com.jd.m.cms.bjshare.client.databoard.DataStatisticalJsfService;
import com.jd.m.cms.bjshare.common.log.TraceLog;
import com.jd.m.cms.bjshare.common.log.TraceLogFactory;
import com.jd.m.cms.bjshare.common.result.ResultCode;
import com.jd.m.cms.bjshare.common.result.ResultData;
import com.jd.m.cms.bjshare.domain.po.WhiteList;
import com.jd.m.njf.server.client.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by LPC on 2018/10/2
 */
@Controller
@RequestMapping("/whiteList")
public class WhiteListController {

    private static final TraceLog log = TraceLogFactory.getTraceLog(DataStaticController.class);

    @Resource
    private WhiteListService whiteListService;

    /**
     * 获取数据 by lipengcheng 2018.10.02
     *
     * @param pageSize       每页显示数量
     */
    @RequestMapping(value = "/getData.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getData(String userErp, String applyUserErp,
                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        ResultData resultData = new ResultData();
        System.out.println("查询白名单参数userErp=" + userErp + "&applyUserErp=" + applyUserErp);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userErp", userErp);
        map.put("applyUserErp", applyUserErp);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        try {
            PageInfo<WhiteList> pageInfo = whiteListService.selectByExample(map);
            resultData.setCode(ResultCode.success.getCode());
            resultData.setMessage(ResultCode.success.getMessage());
            resultData.setResult(pageInfo);

        } catch (Exception e) {
            resultData.setCode(ResultCode.sysError.getCode());
            resultData.setMessage(ResultCode.sysError.getMessage());
            e.printStackTrace();
        }
        return JsonUtil.write2JsonStr(resultData);
    }

    /**
     * 新增数据 by lipengcheng 2018.10.02
     *
     * @param userErp
     * @param roleType
     */
    @RequestMapping(value = "/insertData.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String insertData(String userErp, String roleType) {
        ResultData resultData = new ResultData();
        System.out.println("新增白名单参数userErp=" + userErp + "&roleType=" + roleType);

        Map<String, Object> map = new HashMap<String, Object>();
        userErp=userErp.replace("，",",");//统一转化为英文逗号
        String erpList[]=userErp.split(",");
//        List<String> erpList = Arrays.asList(erpArray);
        map.put("erpList",erpList);
        map.put("roleType", roleType);
        try {
            Set<String> result = whiteListService.selectByErpList(map);
            resultData.setCode(ResultCode.success.getCode());
            resultData.setMessage(ResultCode.success.getMessage());
            resultData.setResult(result);

        } catch (Exception e) {
            resultData.setCode(ResultCode.sysError.getCode());
            resultData.setMessage(ResultCode.sysError.getMessage());
            e.printStackTrace();
        }
        return JsonUtil.write2JsonStr(resultData);
    }

    /**
     * 删除数据 by lipengcheng 2018.10.02
     *
     * @param userErp
     */
    @RequestMapping(value = "/deleteData.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String deleteData(String userErp) {
        ResultData resultData = new ResultData();
        System.out.println("删除白名单参数userErp=" + userErp);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userErp", userErp);
        try {
            int result = whiteListService.deleteByExample(map);
            resultData.setCode(ResultCode.success.getCode());
            resultData.setMessage(ResultCode.success.getMessage());

        } catch (Exception e) {
            resultData.setCode(ResultCode.sysError.getCode());
            resultData.setMessage(ResultCode.sysError.getMessage());
            e.printStackTrace();
        }
        return JsonUtil.write2JsonStr(resultData);
    }

    /**
     * 删除数据 by lipengcheng 2018.10.02
     *
     * @param userErp
     */
    @RequestMapping(value = "/insertbatchData.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String insertbatchData(String userErp) {
        ResultData resultData = new ResultData();
        List<WhiteList> roleList=new ArrayList<WhiteList>();
        for(int i=0;i<2;i++){
            WhiteList dto1=new WhiteList();
            dto1.setUserErp("erp"+i);
            dto1.setApplyUserErp("lipengcheng");
            dto1.setUserName("name"+i);
            dto1.setTelphone("phone"+i);
            dto1.setDeptName("deptname"+i);
            dto1.setRole("role"+i);
            dto1.setCreateTime(new Date());
            dto1.setModifyTime(new Date());
            roleList.add(dto1);
            System.out.println(roleList.toString());
        }
        try {
            int result = whiteListService.insertRoleSetList(roleList);
            resultData.setCode(ResultCode.success.getCode());
            resultData.setMessage(ResultCode.success.getMessage());
            resultData.setResult(result);

        } catch (Exception e) {
            resultData.setCode(ResultCode.sysError.getCode());
            resultData.setMessage(ResultCode.sysError.getMessage());
            e.printStackTrace();
        }
        return JsonUtil.write2JsonStr(resultData);
    }



}
