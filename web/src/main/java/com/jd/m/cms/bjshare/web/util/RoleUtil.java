package com.jd.m.cms.bjshare.web.util;

/**
 * @author huanglong
 * @Description:  角色工具类
 * @date 2018/10/1810:37
 */
public class RoleUtil {

    public final static Long ROLE_SYSTEM  = 1L << 0; //   系统管理员，    第一个状态  0000 0001
    public final static Long ROLE_TOWER = 1L << 1;//    通天塔运营人员， 第二个状态 0000 0010
    public final static Long ROLE_SALER = 1L << 2;//    采销人员，    第三个状态   0000 0100
    public final static Long ROLE_VIDEO = 1L << 3;//    直播运营人员， 第四个状态  0000 1000


    /**
     * @param states       当前的位状态码
     * @param operateState 判断是否存在的状态
     * @return 是否存在 true存在,false不存在
     * @Description: 判断是否存在某个状态
     */
    public static boolean hasState(long states, long operateState) {
        return (states & operateState) != 0;
    }

    /**
     * @param states       当前的位状态码
     * @param operateState 添加的状态
     * @return 添加后的位状态码
     * @Description: 添加某个状态
     */
    public static long addState(long states, long operateState) {
        //当不存在该状态时才执行添加操作,否则直接返回原位状态码
        if (hasState(states, operateState)) {
            return states;
        }
        return (states | operateState);
    }

    /**
     * @param states       当前的位状态码
     * @param operateState 需要删除状态
     * @return 删除后的位状态码
     * @Description: 删除某个状态
     */
    public static long removeState(long states, long operateState) {
        //当存在该状态时才执行删除操作,否则直接返回原位状态码
        if (!hasState(states, operateState)) {
            return states;
        }
        return states ^ operateState;
    }




}
