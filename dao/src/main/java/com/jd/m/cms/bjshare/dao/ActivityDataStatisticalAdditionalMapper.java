package com.jd.m.cms.bjshare.dao;

import com.jd.m.cms.bjshare.domain.po.ActivityDataStatisticalAdditional;
import com.jd.m.cms.bjshare.domain.po.ActivityDataStatisticalAdditionalExample;
import com.jd.m.cms.bjshare.domain.vo.UvData;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ActivityDataStatisticalAdditionalMapper {
    int countByExample(ActivityDataStatisticalAdditionalExample example);

    int deleteByExample(ActivityDataStatisticalAdditionalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivityDataStatisticalAdditional record);

    int insertSelective(ActivityDataStatisticalAdditional record);

    List<ActivityDataStatisticalAdditional> selectByExample(ActivityDataStatisticalAdditionalExample example);

    ActivityDataStatisticalAdditional selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivityDataStatisticalAdditional record, @Param("example") ActivityDataStatisticalAdditionalExample example);

    int updateByExample(@Param("record") ActivityDataStatisticalAdditional record, @Param("example") ActivityDataStatisticalAdditionalExample example);

    int updateByPrimaryKeySelective(ActivityDataStatisticalAdditional record);

    int updateByPrimaryKey(ActivityDataStatisticalAdditional record);
    // 删除数据
    int test(Map<String, Object> map);

    //批量更新活动状态
    int updateActivityStatusByIds(Map<String, Object> map);

}