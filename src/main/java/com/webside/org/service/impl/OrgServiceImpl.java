package com.webside.org.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webside.base.baseservice.impl.AbstractService;
import com.webside.org.mapper.OrgMapper;
import com.webside.org.model.OrgEntity;
import com.webside.org.service.OrgService;
import com.webside.resource.model.ResourceEntity;

@Service("orgService")
public class OrgServiceImpl extends AbstractService<OrgEntity, Long> implements OrgService{

	@Autowired
	private OrgMapper orgMapper;
	
	//这句必须要加上。不然会报空指针异常，因为在实际调用的时候不是BaseMapper调用，而是具体的mapper，这里为userMapper
	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(orgMapper);
	}
	
	
	@Override
	public List<OrgEntity> queryOrgList(Map<String, Object> parameter) {
		return orgMapper.queryOrgList(parameter);
	}

}
