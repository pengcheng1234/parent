package com.jd.m.cms.bjshare.web.util;

import com.jd.m.cms.bjshare.common.result.ResultData;
import com.jd.m.cms.bjshare.domain.vo.UserVo;
import com.jd.m.njf.server.client.util.JsonUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;

/**
 * 通过cookie获取用户信息
 *
 * @author zhulx
 */
public class UserInfo {

    /**
     * 通过cookie获取用户信息
     *
     * @param request
     */
    public static UserVo getUserVo(HttpServletRequest request) {
        UserVo userVo = new UserVo();
        userVo.setErp("test2");
//        userVo.setErp("test2");
        return userVo;
    }
}
