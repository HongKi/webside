<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/customer/org/list.js"></script>
<div class="page-header">
	<shiro:hasPermission name="org:add">
	<button id="btnAdd" type="button" onclick="addModel('/org/addUI.html')" class="btn btn-primary btn-sm">
	  	<i class="fa fa-user-plus"></i>&nbsp;添加
	</button>
	</shiro:hasPermission>
	<shiro:hasPermission name="org:edit">
	<button id="btnEdit" type="button" onclick="editModel('/org/editUI.html')" class="btn btn-info btn-sm">
		 <i class="fa fa-pencil-square-o"></i>&nbsp;编辑
	</button>
	</shiro:hasPermission>
	<shiro:hasPermission name="org:deleteBatch">
	<button id="btnDel" type="button" onclick="delModel('/org/deleteBatch.html', customSearch)" class="btn btn-danger btn-sm">
		<i class="fa fa-trash-o"></i>&nbsp;删除
	</button>
	</shiro:hasPermission>
</div>
<div class="input-group">
     <input id="searchKey" type="text" class="input form-control" placeholder="部门名称...">
     <span class="input-group-btn">
         <button id="btnSearch" class="btn btn-primary btn-sm" type="button"> <i class="fa fa-search"></i> 搜索</button>
     </span>
</div>
<div class="row" style="margin-top:5px;">
	<div class="col-xs-12 widget-container-col ui-sortable"
		style="min-height: 127px;">
		<!-- #section:custom/widget-box.options.transparent -->
		<div class="widget-box transparent ui-sortable-handle"
			style="opacity: 1; z-index: 0;">
			<div class="widget-header">
				<h4 class="widget-title lighter">组织架构</h4>
				<div class="widget-toolbar no-border">
					<a href="#" data-action="fullscreen" class="orange2"> 
						<i class="ace-icon fa fa-arrows-alt"></i>
					</a> 
					<a href="#" data-action="collapse" class="green"> 
						<i class="ace-icon fa fa-chevron-up"></i>
					</a>
				</div>
			</div>

			<div class="widget-body" style="display: block;">
				<div class="widget-main padding-6 no-padding-left no-padding-right">
					<input id="pageNum" type="hidden" value="${page.pageNum }">
					<input id="pageSize" type="hidden" value="${page.pageSize }">
					<input id="orderByColumn" type="hidden" value="${page.orderByColumn }">
					<input id="orderByType" type="hidden" value="${page.orderByType }">
					<div id="dtGridContainer" class="dt-grid-container"></div>
					<div id="dtGridToolBarContainer" class="dt-grid-toolbar-container"></div>
				</div>
			</div>
		</div>
	</div>
</div>


