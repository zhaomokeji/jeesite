<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>活跃度管理</title>
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
		<li class="active"><a href="${ctx}/zm/zmkjProductActivity/">活跃度列表</a></li>
		<shiro:hasPermission name="zm:zmkjProductActivity:edit"><li><a href="${ctx}/zm/zmkjProductActivity/form">活跃度添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zmkjProductActivity" action="${ctx}/zm/zmkjProductActivity/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>用户标志：</label>
				<form:input path="userid" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>客户端标志：</label>
				<form:input path="clientid" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>产品名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>技术平台：</label>
				<form:input path="technologyPlatform" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>操作系统：</label>
				<form:input path="os" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>版本号：</label>
				<form:input path="version" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>活动事件名称：</label>
				<form:input path="eventName" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>ip地址：</label>
				<form:input path="ip" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>用户标志</th>
				<th>客户端标志</th>
				<th>产品名称</th>
				<th>技术平台</th>
				<th>操作系统</th>
				<th>版本号</th>
				<th>活动事件名称</th>
				<th>ip地址</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="zm:zmkjProductActivity:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zmkjProductActivity">
			<tr>
				<td><a href="${ctx}/zm/zmkjProductActivity/form?id=${zmkjProductActivity.id}">
					${zmkjProductActivity.userid}
				</a></td>
				<td>
					${zmkjProductActivity.clientid}
				</td>
				<td>
					${zmkjProductActivity.name}
				</td>
				<td>
					${zmkjProductActivity.technologyPlatform}
				</td>
				<td>
					${zmkjProductActivity.os}
				</td>
				<td>
					${zmkjProductActivity.version}
				</td>
				<td>
					${zmkjProductActivity.eventName}
				</td>
				<td>
					${zmkjProductActivity.ip}
				</td>
				<td>
					<fmt:formatDate value="${zmkjProductActivity.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zmkjProductActivity.remarks}
				</td>
				<shiro:hasPermission name="zm:zmkjProductActivity:edit"><td>
    				<a href="${ctx}/zm/zmkjProductActivity/form?id=${zmkjProductActivity.id}">修改</a>
					<a href="${ctx}/zm/zmkjProductActivity/delete?id=${zmkjProductActivity.id}" onclick="return confirmx('确认要删除该活跃度吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>