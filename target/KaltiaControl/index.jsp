<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="images/favicon.ico">

    <title>Kaltia -- Mexico.  SistemaControlKaltia</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/complemento.css">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
    <style type="text/css">
/*     html, body, div, iframe { margin:0; padding:0; height:100%; } */
    span {color:red}
	</style>
    
  </head>

  <body class="text-center">
    <form:form  class="form-signin" action="login.htm" method="post" modelAttribute="userKaltiaControlFront">
      <img class="mb-4 " src="images/kaltiaLogo2.jpg" alt="" width="150px" height="150px">
      <h1 class="h3 mb-3 font-weight-normal">Ingresar Sistema de Control Kaltia</h1>
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="email" id="inputEmail" name="userUser" class="form-control" placeholder="Email address" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" name="passUser" class="form-control" placeholder="Password" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <div>
      	<span>
      		<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlDescr()}"/>
			<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlStatus()}"/>	
      	</span>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
      <p class="mt-5 mb-3 text-muted"><a href="http://www.kaltiaservicios.com">Kaltia Servicios Informatica - Mexico&copy; 2021</a></p>
      <hiden class="version">01012021</hiden>
    </form:form>


    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
