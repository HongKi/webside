package com.webside.org.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.webside.base.basecontroller.BaseController;
import com.webside.exception.AjaxException;
import com.webside.exception.SystemException;
import com.webside.org.model.OrgEntity;
import com.webside.org.service.OrgService;
import com.webside.util.Common;
import com.webside.util.PageUtil;
import com.webside.util.Pager;
import com.webside.util.Select2Entity;
import com.webside.util.TreeUtil;

@Controller
@Scope("prototype")
@RequestMapping("/org/")
public class OrgController extends BaseController {

	@Autowired
	private OrgService orgService;
	
	@RequestMapping("listUI.html")
	public String listUI(Model model, HttpServletRequest request) {
		try
		{
			PageUtil page = new PageUtil();
			if(request.getParameterMap().containsKey("page")){
				page.setPageNum(Integer.valueOf(request.getParameter("page")));
				page.setPageSize(Integer.valueOf(request.getParameter("rows")));
				page.setOrderByColumn(request.getParameter("sidx"));
				page.setOrderByType(request.getParameter("sord"));
			}
			model.addAttribute("page", page);
			return Common.BACKGROUND_PATH + "/org/list";
		}catch(Exception e)
		{
			throw new SystemException(e);
		}
	}
	
	
	@RequestMapping("list.html")
	@ResponseBody
	public Object list(String dtGridPager) throws Exception{
		Map<String,Object> parameters = null;
		// 映射Pager对象
		Pager pager = JSON.parseObject(dtGridPager, Pager.class);
		// 判断是否包含自定义参数
		parameters = pager.getParameters();
		if (parameters.size() < 0) {
			parameters.put("name", null);
		}
		// 设置分页，page里面包含了分页信息
		Page<Object> page = PageHelper.startPage(pager.getNowPage(),pager.getPageSize(), "o_id DESC");
	
		List<OrgEntity> list = orgService.queryListByPage(parameters);
		parameters.clear();
		parameters.put("isSuccess", Boolean.TRUE);
		parameters.put("nowPage", pager.getNowPage());
		parameters.put("pageSize", pager.getPageSize());
		parameters.put("pageCount", page.getPages());
		parameters.put("recordCount", page.getTotal());
		parameters.put("startRecord", page.getStartRow());
		//列表展示数据
		parameters.put("exhibitDatas", list);
		return parameters;
	}
	
	@RequestMapping("addUI.html")
	public String addUI(Model model, HttpServletRequest request) {
		try
		{
			List<OrgEntity> list = orgService.queryListByPage(new HashMap<String,Object>());
//			List<Select2Entity> select2List = new TreeUtil().getSelectTree(list, null);
			List<Select2Entity> select2List = null;
			//TODO

			model.addAttribute("select2List", select2List);
			return Common.BACKGROUND_PATH + "/org/form";
		}catch(Exception e)
		{
			throw new SystemException(e);
		}
	}
	
	@RequestMapping("add.html")
	@ResponseBody
	public Object add(OrgEntity orgEntity)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		try
		{
			orgEntity.setCreateTime(new Date());
			int result = orgService.insert(orgEntity);
			if(result > 0)
			{
				map.put("success", Boolean.TRUE);
				map.put("data", null);
				map.put("message", "添加成功");
			}else
			{
				map.put("success", Boolean.FALSE);
				map.put("data", null);
				map.put("message", "添加失败");
			}
		}catch(Exception e)
		{
			throw new AjaxException(e);
		}
		return map;
	}
	
	
	@RequestMapping("editUI.html")
	public String editUI(Model model, HttpServletRequest request, Long id) {
		try
		{
			OrgEntity orgEntity = orgService.findById(id);
			PageUtil page = new PageUtil();
			page.setPageNum(Integer.valueOf(request.getParameter("page")));
			page.setPageSize(Integer.valueOf(request.getParameter("rows")));
			page.setOrderByColumn(request.getParameter("sidx"));
			page.setOrderByType(request.getParameter("sord"));
			
			List<OrgEntity> list = orgService.queryListByPage(new HashMap<String,Object>());
			
//			List<Select2Entity> select2List = new TreeUtil().getSelectTree(list, null);
			List<Select2Entity> select2List = null;
			//TODO
			model.addAttribute("page", page);
			model.addAttribute("OrgEntity", orgEntity);
			model.addAttribute("select2List", select2List);
			return Common.BACKGROUND_PATH + "/org/form";
		}catch(Exception e)
		{
			throw new SystemException(e);
		}
	}
	
	@RequestMapping("edit.html")
	@ResponseBody
	public Object update(OrgEntity orgEntity)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		try
		{
			int result = orgService.update(orgEntity);
			if(result > 0)
			{
				map.put("success", Boolean.TRUE);
				map.put("data", null);
				map.put("message", "编辑成功");
			}else
			{
				map.put("success", Boolean.FALSE);
				map.put("data", null);
				map.put("message", "编辑失败");
			}
		}catch(Exception e)
		{
			throw new AjaxException(e);
		}
		return map;
	}
	
	
	@RequestMapping("deleteBatch.html")
	@ResponseBody
	public Object deleteBatch(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			String[] roleIds = ids.split(",");
			List<Long> list = new ArrayList<Long>();
			for (String string : roleIds) {
				list.add(Long.valueOf(string));
			}
			int cnt = orgService.deleteBatchById(list);
			if(cnt == list.size())
			{
				result.put("success", true);
				result.put("data", null);
				result.put("message", "删除成功");
			}else
			{
				result.put("success", false);
				result.put("data", null);
				result.put("message", "删除失败");
			}
		}catch(Exception e)
		{
			throw new AjaxException(e);
		}
		return result;
	}
	
}
