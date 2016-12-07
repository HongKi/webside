package com.webside.org.service;

import java.util.List;
import java.util.Map;

import com.webside.org.model.OrgEntity;

public interface OrgService
{

	public List<OrgEntity> queryListByPage(Map<String, Object> parameter);
	
	public int insert(OrgEntity orgEntity);
	
	public OrgEntity findById(Long id);

	public int update(OrgEntity orgEntity);
    
    public int deleteBatchById(List<Long> orgIds);
    
    public List<OrgEntity> queryOrgList(Map<String, Object> parameter);
}
