<%@ include file="/layout/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>KaltiaControl</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="<%=request.getContextPath()%>/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="<%=request.getContextPath()%>/css/complementoBody2.css" rel="stylesheet" type="text/css" media="all">
</head>
<body id="top">
<!-- ################################################################################################ -->
<!-- Top Background Image Wrapper -->
<div class="bgded overlay light" style="background-image:url('<%=request.getContextPath()%>/images/imagen.jpg');"> 
  <div class="wrapper row0">
    <div id="topbar" class="hoc clear"> 
      <div class="fl_left"> 
        <ul class="nospace">
          <li><i class="fa fa-phone"></i> +00 (123) 456 7890</li>
          <li><i class="fa fa-envelope-o"></i> info@domain.com</li>
        </ul>
      </div>
    </div>
  </div>
  <!-- ################################################################################################ -->
  <div class="wrapper row1">
    <header id="header" class="hoc clear"> 
      <div id="logo" class="fl_left">
        <h1><a href="#">K A L T I A Control</a></h1>
      </div>
    </header>
  </div>
  <!-- ################################################################################################ -->

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="container auth" class="clear">
    <h1 class="text-rigth">Actualiza tu Password</h1>
    <div id="big-form" class="well auth-box">
      <form  class="" action="inicioEmpresa.htm" method="post" modelAttribute="userKaltiaControl">
        <fieldset>
          <!-- Text input-->
          <div class="form-group">
			
            <a  id="general"></a>
            <label class=" control-label" for="textinput">Usuarios</label>
                            
              <a id="usuario"></a>
	             <label class=" control-label" for="textinput">Usuario</label>
	              <input id="userUser" name="userUser" placeholder="Usuario Kaltia Control" class="form-control input-md" readonly type="text" value="<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlUser()}"/>">
	              <input id="userKaltiaControlPass" name="passUser" placeholder="Password" class="form-control input-md" type="password">
	              <input id="userKaltiaControlPass1" name="passUser1" placeholder="Confirma Password" class="form-control input-md" type="password">
	              
	              <br>

              <br>
			  <br>
			  <br>
			  
	            <label class=" control-label" for="singlebutton">Datos Correctos</label>
	            <div class="">
	              <button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>

	          </div>
            </div>
<!--     section     -->
          
     	   </fieldset>
     	 </form>
		</div>
     <div class="clearfix"></div>
   </div>
   </div>
<!-- JAVASCRIPTS -->
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.backtotop.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/complementoBody2.js"></script>
<script src="<%=request.getContextPath()%>/js/complemento.js"></script>

</body>
</html>