package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.ShareRule;
import com.jd.m.cms.bjshare.domain.vo.ShareRuleVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShareRuleDao {
    int deleteByPrimaryKey(Long id);

    int insertSelective(ShareRule record);

    ShareRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShareRule record);

	/**
	 * 批量插入京豆奖励
	 */
	void insertShareRulePatch(List<ShareRule> shareRuleList);

    List<ShareRuleVo> queryShareRuleInfo(Map<String, Object> map);
}