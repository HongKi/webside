package com.webside.org.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.webside.base.basemodel.BaseEntity;

public class OrgEntity extends BaseEntity
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	/*
	 * 父节点ID
	 */
	private Integer				parentId;
	/*
	 * 名称
	 */
	private String				name;
	/*
	 * 层级,即菜单的展开层级
	 */
	private Integer				level;
	/*
	 * 描述
	 */
	private String				description;
	/*
	 * 创建时间
	 */
	private Date				createTime;
	/*
	 * 更新时间
	 */
	private Date				updateTime;
	/*
	 * 父节点名称
	 */
	private String				parentName;

	private List<OrgEntity>		children			= new ArrayList<OrgEntity>();

	public Integer getParentId()
	{
		return parentId;
	}

	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getLevel()
	{
		return level;
	}

	public void setLevel(Integer level)
	{
		this.level = level;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	public String getParentName()
	{
		return parentName;
	}

	public void setParentName(String parentName)
	{
		this.parentName = parentName;
	}

	public List<OrgEntity> getChildren()
	{
		return children;
	}

	public void setChildren(List<OrgEntity> children)
	{
		this.children = children;
	}

	@Override
	public String toString()
	{
		return "OrgEntity [id=" + id + ", parentId=" + parentId + ", name=" + name + ", sourceKey=" + ", description="
				+ description + ", createTime=" + createTime + ", updateTime=" + updateTime + ", parentName="
				+ parentName + "]";
	}

}
