<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>汉字转拼音</title>
	<meta name="decorator" content="cms_default_${site.theme}"/>
	<meta name="description" content="${site.description}" />
	<meta name="keywords" content="${site.keywords}" />
	<style type="text/css">
		dl.map{border:1px solid #efefef;border-top:0;margin:10px 8px 8px;}
		dl.map dt{border-top:1px solid #efefef;padding:10px 15px;}
		dl.map dd{margin:10px 30px 20px;}
		dl.map span{border:1px solid #efefef;padding:8px 10px;}
		dl.map span:hover{border:1px solid #bbb;}
		dl.map span a:hover{text-decoration:none;color:#333;}
	</style>
</head>
<body>
	<br/>
	<form:form id="inputForm" modelAttribute="pinyin" action="${ctx}/pinyin/trans" method="post" class="form-horizontal">
		
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