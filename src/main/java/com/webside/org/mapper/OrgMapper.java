package com.webside.org.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.webside.base.basemapper.BaseMapper;
import com.webside.org.model.OrgEntity;

@Repository
public interface OrgMapper extends BaseMapper<OrgEntity, Long>{
	
	/**
	 * 查询组织机构
	 * @param 
	 * @return
	 */
    public List<OrgEntity> queryOrgList(Map<String, Object> parameter);
}
