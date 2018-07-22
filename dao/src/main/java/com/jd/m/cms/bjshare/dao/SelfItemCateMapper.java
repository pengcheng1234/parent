package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.SelfItemCate;
import com.jd.m.cms.bjshare.domain.po.SelfItemCateExample;
import com.jd.m.cms.bjshare.domain.vo.CodeAndName;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelfItemCateMapper {
    int countByExample(SelfItemCateExample example);

    int deleteByExample(SelfItemCateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SelfItemCate record);

    int insertSelective(SelfItemCate record);
//    根据父节点查询子节点
    List<CodeAndName> selectByParentCode(SelfItemCate selfItemCate);

    List<SelfItemCate> selectByExample(SelfItemCateExample example);

    SelfItemCate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SelfItemCate record, @Param("example") SelfItemCateExample example);

    int updateByExample(@Param("record") SelfItemCate record, @Param("example") SelfItemCateExample example);

    int updateByPrimaryKeySelective(SelfItemCate record);

    int updateByPrimaryKey(SelfItemCate record);
}