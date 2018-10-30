package com.jd.m.cms.bjshare.web.service;

import com.jd.m.cms.bjshare.domain.vo.UserVo;
import com.jd.m.cms.bjshare.web.exception.ShareException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author huanglong
 * @Description: 登录服务
 * @date 2018/6/1411:13
 */
public interface LoginService {

    /**
     * 获取用户的信息
     * @param
     * @return
     */
    UserVo getAllUserInf() throws ShareException;

    UserVo getUserInf(String erp, String name) throws ShareException;

    UserVo getUserInfFromCookie(HttpServletRequest request);

    List<String> getUsers(UserVo userVo);

}
