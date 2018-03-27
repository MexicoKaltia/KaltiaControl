<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>prueba</title>
</head>
<body>
	<ul>
		<li><iframe src="<%=request.getContextPath()%>/layout/frame/header.jsp"></iframe></li>
		<li><iframe src="<%=request.getContextPath()%>/layout/frame/body.jsp"></iframe></li>
		<li><iframe src="<%=request.getContextPath()%>/layout/frame/footer.jsp"></iframe></li>
	</ul>
</body>
</html>