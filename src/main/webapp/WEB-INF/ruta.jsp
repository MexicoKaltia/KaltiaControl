    <%@ include file="/layout/head.jsp" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
RUTA
        <ul>
          <li  class="active"><a href="../index.html">Inicio</a></li>
          <li><a class="drop" href="<c:url value="edicion.htm"/>">Edicion</a>
          <li><a class="drop" href="${pageContext.request.contextPath}/edicion.htm">Estadistica</a></li>
        </ul>
</body>
</html>

