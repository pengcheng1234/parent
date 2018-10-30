package com.jd.m.cms.bjshare.common.result;

/**
 * @author njzhufeifei 返回码枚举
 */
public enum ResultCode {

    success("0", "响应成功"),

    paramError("1", "参数错误"),

    methodNone("2", "方法不存在"),

    notLogin("3", "用户未登录"),

    FileError("4", "文件名错误"),

    EmptyError("5", "未查到数据"),

    ExistError("6", "数据已经存在"),

	notBelongVender("7","活动id与venderId不匹配"),

	endTimeError("8","活动结束时间小于当前时间"),

	typeError("9","优惠券类型错误"),

	couponTimeError("10", "活动时间不在优惠券有效时间范围之内"),

    couponNumError("11", "优惠券发送的数量超过了可用的数量"),

    EMPTY_SKU("12", "sku为空"),

    EMPTY_COOKIE("13", "用户的cookie信息为空"),

    IMAGE_UPLOAD_ERROR("14","图片上传异常，请稍后重试"),

    PERMISSIONS_ERROR("15","该用户没有审批权限"),

    timeError("16", "查询间隔超过半年"),// 查询时间超过6个月

    sysError("-1", "系统异常"),
    
    limitError("-2", "风控限流"),

    dbError("-3", "数据库异常"),
    
    otherError("-99", "服务器异常");// 预留异常code，客户端见到此code直接显示errorMsg，方便后期扩展


    private String code;

    private String message;

    private ResultCode(String code) {
        this.code = code;
    }

    private ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}