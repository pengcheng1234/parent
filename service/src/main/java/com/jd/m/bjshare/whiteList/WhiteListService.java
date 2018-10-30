package com.jd.m.bjshare.whiteList;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jd.m.cms.bjshare.common.result.ResultData;
import com.jd.m.cms.bjshare.dao.WhiteListMapper;
import com.jd.m.cms.bjshare.domain.po.Role;
import com.jd.m.cms.bjshare.domain.po.WhiteList;
import com.jd.m.cms.bjshare.domain.po.WhiteListExample;
import com.jd.m.cms.bjshare.domain.vo.ActivityDataStatisticalExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by LPC on 2018/10/2
 */
@Service
public class WhiteListService {

    @Autowired
    private WhiteListMapper whiteListMapper;

    //查询白名单
    public  PageInfo<WhiteList> selectByExample(Map<String, Object> map){
        PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));
        WhiteListExample example = new WhiteListExample();
        WhiteListExample.Criteria criteria = example.createCriteria();
        if(map.get("userErp")!=null){
            criteria.andUserErpEqualTo(map.get("userErp").toString());
        }
        if(map.get("applyUserErp")!=null){
            criteria.andApplyUserErpEqualTo(map.get("applyUserErp").toString());
        }
        criteria.andIsDeleteEqualTo(0);
        List<WhiteList> list=whiteListMapper.selectByExample(example);
        PageInfo<WhiteList> pageInfo = new PageInfo<WhiteList>(list);
        return pageInfo;
    }

    //新增白名单
    public int insertSelective(Map<String, Object> map){
        WhiteList dto=new WhiteList();
        dto.setUserErp(map.get("userErp").toString());
        dto.setApplyUserErp(map.get("applyUserErp").toString());
        dto.setUserName("京东1号");
        dto.setCreateTime(new Date());
        dto.setModifyTime(new Date());
        dto.setOpenTime(new Date());
        return whiteListMapper.insertSelective(dto);
    }

    //删除白名单
    public int deleteByExample(Map<String, Object> map){
        WhiteListExample example = new WhiteListExample();
        WhiteListExample.Criteria criteria = example.createCriteria();
        criteria.andUserErpEqualTo(map.get("userErp").toString());
        return whiteListMapper.deleteByExample(example);
    }

    //通过erplist查询用户
    public Set<String> selectByErpList(Map<String, Object> map){
        return whiteListMapper.selectByErpList(map);
    }

    //批量新增白名单
    public int insertRoleSetList(List<WhiteList> roleList){
        return whiteListMapper.insertRoleSetList(roleList);
    }

}
