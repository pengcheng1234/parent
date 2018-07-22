package com.jd.m.cms.bjshare.domain.vo;

import java.util.List;

/**
 * @author huanglong
 * @Description: 用户登录的信息
 * @date 2018/6/1411:17
 */
public class UserVo {

    private UserVo higher;

    private List<UserVo> lowers;

    /* erp */
    private String erp;
    /* 账号类型 0：运营，1：采销 */
    private Integer level;
    /* 人员名称 */
    private String name;

    public String getErp() {
        return erp;
    }

    public void setErp(String erp) {
        this.erp = erp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserVo getHigher() {
        return higher;
    }

    public void setHigher(UserVo higher) {
        this.higher = higher;
    }

    public List<UserVo> getLowers() {
        return lowers;
    }

    public void setLowers(List<UserVo> lowers) {
        this.lowers = lowers;
    }
}
