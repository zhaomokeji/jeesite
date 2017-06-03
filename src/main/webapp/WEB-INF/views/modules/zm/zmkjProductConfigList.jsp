<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>产品配置管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/zm/zmkjProductConfig/">产品配置列表</a></li>
		<shiro:hasPermission name="zm:zmkjProductConfig:edit"><li><a href="${ctx}/zm/zmkjProductConfig/form">产品配置添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zmkjProductConfig" action="${ctx}/zm/zmkjProductConfig/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>产品名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>技术平台：</label>
				<form:input path="technologyPlatform" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>版本号：</label>
				<form:input path="version" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>版本号NUM：</label>
				<form:input path="versionNum" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>产品名称</th>
				<th>技术平台</th>
				<th>版本号 </th>
				<th>版本号NUM</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="zm:zmkjProductConfig:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zmkjProductConfig">
			<tr>
				<td><a href="${ctx}/zm/zmkjProductConfig/form?id=${zmkjProductConfig.id}">
					${zmkjProductConfig.name}
				</a></td>
				<td>
					${zmkjProductConfig.technologyPlatform}
				</td>
				<td>
					${zmkjProductConfig.version}
				</td>
				<td>
					${zmkjProductConfig.versionNum}
				</td>
				<td>
					<fmt:formatDate value="${zmkjProductConfig.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zmkjProductConfig.remarks}
				</td>
				<shiro:hasPermission name="zm:zmkjProductConfig:edit"><td>
    				<a href="${ctx}/zm/zmkjProductConfig/form?id=${zmkjProductConfig.id}">修改</a>
					<a href="${ctx}/zm/zmkjProductConfig/delete?id=${zmkjProductConfig.id}" onclick="return confirmx('确认要删除该产品配置吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>