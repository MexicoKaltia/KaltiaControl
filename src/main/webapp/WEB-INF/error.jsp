<%@ include file="/layout/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlDescr()}"/>
	<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlStatus()}"/>
</body>
</html>