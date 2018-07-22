package com.jd.m.cms.bjshare.client.activity;

import com.jd.m.cms.bjshare.domain.po.SelfItemCate;
import com.jd.m.cms.bjshare.domain.vo.CodeAndName;

import java.util.List;

/**
 * 商品三级分类
 * Created by lipengcheng on 2018/7/3.
 */
public interface SelfItemCateJsfService {

  /**
   * 根据父节点id查询子节点信息
   * @param
   * @return
   */
    public List<CodeAndName> selectByParentCode(SelfItemCate selfItemCate);

}
