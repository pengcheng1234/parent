package com.jd.m.bjshare.activity.client.service.impl;

import com.jd.m.cms.bjshare.client.activity.SelfItemCateJsfService;
import com.jd.m.cms.bjshare.dao.SelfItemCateMapper;
import com.jd.m.cms.bjshare.domain.po.SelfItemCate;
import com.jd.m.cms.bjshare.domain.vo.CodeAndName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LPC on 2018/7/3
 */
@Service
public class SelfItemCateServiceJsfImpl implements SelfItemCateJsfService {

    @Resource
    private SelfItemCateMapper selfItemCateMapper;

    @Override
    public List<CodeAndName> selectByParentCode(SelfItemCate selfItemCate){
        List<CodeAndName> result=selfItemCateMapper.selectByParentCode(selfItemCate);
        return result;

    }


}
