package com.jd.m.cms.bjshare.web.service.impl;

import com.jd.m.cms.bjshare.common.result.ResultCode;
import com.jd.m.cms.bjshare.common.result.ResultData;
import com.jd.m.cms.bjshare.dao.OperaterListMapper;
import com.jd.m.cms.bjshare.domain.enums.ShareExceptionEnum;
import com.jd.m.cms.bjshare.domain.po.OperaterList;
import com.jd.m.cms.bjshare.domain.po.OperaterListExample;
import com.jd.m.cms.bjshare.domain.vo.UserVo;
import com.jd.m.cms.bjshare.web.exception.ShareException;
import com.jd.m.cms.bjshare.web.service.LoginService;
import com.jd.m.njf.server.client.util.JsonUtil;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huanglong
 * @Description: 登录服务
 * @date 2018/6/1411:13
 */
@Service
public class LoginServiceImpl implements LoginService {

    public static Logger logger = Logger.getLogger(LoginServiceImpl.class);


    @Override
    public UserVo getUserInf(String erp, String name) throws ShareException {
        UserVo userVo = null;
        /* 1.是否是master */
//        OperaterListExample example = new OperaterListExample();
//        OperaterListExample.Criteria criteria = example.createCriteria();
//        criteria.andErpEqualTo(erp);
//        List<OperaterList> operaterLists = operaterListMapper.selectByExample(example);
//        if (operaterLists != null && operaterLists.size() > 0) {
//            OperaterList operaterList = operaterLists.get(0);
//            userVo = new UserVo();
//            userVo.setErp(operaterList.getErp());
//            userVo.setLevel(0);
//            userVo.setName(operaterList.getName());
//        } else {
//            ClientInfo clientInfo = new ClientInfo();
//            clientInfo.setDeployAppName(Constants.APP_NAME);
//            clientInfo.setApiVersion("1.0.0");
//            /* 是否是运营人员 */
//            boolean isSaler;
//            try {
//                isSaler = mySalerService.isSaler(erp, clientInfo);
//            } catch (CommodityException e) {
//                throw new ShareException(ShareExceptionEnum.JSF_ERROR.getCode(), ShareExceptionEnum.JSF_ERROR.getMsg());
//            }
//            if (isSaler) {
//
//                userVo = new UserVo();
//                userVo.setLevel(1);
//                userVo.setErp(erp);
//                userVo.setName(name);
//
//            } else {
//                throw new ShareException(ResultCode.USER_UNLEGAL.getCode(), ResultCode.USER_UNLEGAL.getMessage());
//            }
//        }
        return userVo;
    }

    @Override
    public UserVo getAllUserInf() throws ShareException {
        UserVo userVo = null;
        userVo = new UserVo();
        userVo.setLevel(1);
        userVo.setErp("test");
        userVo.setName("test");
                /* 获取二级上级 */
        UserVo higher = new UserVo();
        higher.setLevel(1);
        higher.setErp("higher1");
        higher.setName("higher1");
        UserVo higherer = new UserVo();
        higherer.setLevel(1);
        higherer.setErp("higher2");
        higherer.setName("higher2");
        higher.setHigher(higherer);
        userVo.setHigher(higher);

        /* 获取二级下级 */
        List<UserVo> lowers1 =new ArrayList<UserVo>();
        UserVo lower1=new UserVo();
        lower1.setLevel(1);
        lower1.setErp("lower1");
        lower1.setName("lower1");
        List<UserVo> lowers2=new ArrayList<UserVo>();
        UserVo lower2=new UserVo();
        lower2.setLevel(1);
        lower2.setErp("lower2");
        lower2.setName("lower2");
        lowers2.add(lower2);
        lower1.setLowers(lowers2);
        lowers1.add(lower1);
        userVo.setLowers(lowers1);

        return userVo;
    }


    @Override
    public UserVo getUserInfFromCookie(HttpServletRequest request) {
        UserVo allUserVo=null;
        try{
             allUserVo = getAllUserInf();
        }catch (Exception e){

        }

        return allUserVo;
    }

    @Override
    public List<String> getUsers(UserVo userVo) {
        List<String> users = new ArrayList<String>();
        if (userVo.getLevel() == 1) {
            /* 采销 */
            users.add(userVo.getErp());
            List<UserVo> lowers = userVo.getLowers();
            if (lowers != null && lowers.size() > 0) {
                for (UserVo lower : lowers) {
                    users.add(lower.getErp());
                    List<UserVo> lower_lowers = lower.getLowers();
                    if (lower_lowers != null && lower_lowers.size() > 0) {
                        for (UserVo lower_lower : lower_lowers) {
                            users.add(lower_lower.getErp());
                        }
                    }
                }
            }
        }
        return users;
    }
}
