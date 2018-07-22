package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.ShareContent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShareContentDao {

	List<ShareContent> getByCondition(Map<String, Object> condition);

	void insert(ShareContent sharecontent);

	void insertShareContentBatch(List<ShareContent> shareContentList);
	
	void update(ShareContent sharecontent);
	void deleteShareContent(Map<String, Object> condition);

	Integer countByCondition(Map<String, Object> condition);

	ShareContent getByType(Byte type);
}