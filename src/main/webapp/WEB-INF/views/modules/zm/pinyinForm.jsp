<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>拼音测试</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#content").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
<br/>
	<form:form id="inputForm" modelAttribute="pinyin" action="${ctx}/zm/pinyin/trans" method="post" class="form-horizontal">
		
		<sys:message content="${message}"/>
		<div class="control-group">
			<div class="controls">
				<form:textarea id="content" htmlEscape="true" path="content" rows="4" maxlength="100" class="input-xxlarge"/>
			</div>
		</div>
		<div class="control-group">
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="转换"/>
		</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<form:textarea htmlEscape="true" path="contentResult" rows="4" maxlength="100" class="input-xxlarge"/>
			</div>
		</div>
	</form:form>
		
</body>
</html>
