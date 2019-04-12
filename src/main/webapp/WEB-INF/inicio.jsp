<%@ include file="/layout/head.jsp" %>
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
<!--             <label class=" control-label" for="textinput">Usuarios</label> -->
                            
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
	              <button class="btn btn-lg btn-primary btn-block" type="submit" disabled="true" id="savePass">Guardar</button>

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