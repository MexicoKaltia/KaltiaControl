<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/layout/head.jsp" %>
<!DOCTYPE html>
<html lang="">
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
      <div class="fl_right"> 
        <ul class="nospace">
          <li><a href="../index.html"><i class="fa fa-lg fa-home"></i></a></li>
          <li><a href="#" title="Help Centre"><i class="fa fa-life-bouy"></i></a></li>
          <li><a href="#" title="Login"><i class="fa fa-lg fa-sign-in"></i></a></li>
          <li><a href="#" title="Sign Up"><i class="fa fa-lg fa-edit"></i></a></li>
        </ul>
      </div>
    </div>
  </div>
  <!-- ################################################################################################ -->
  <div class="wrapper row1">
    <header id="header" class="hoc clear"> 
      <div id="logo" class="fl_left">
        <h1><a href="../index.html">K A L T I A Control</a></h1>
      </div>
      <nav id="mainav" class="fl_right">
        <ul class="clear">
          <li  class="active"><a href="../index.html">Inicio</a></li>
          <li><a class="drop" href="<c:url value="edicion.html"/>">Edicion</a>
          <li><a class="drop" href="${pageContext.request.contextPath}/edicion.htm">Estadistica</a></li>
        </ul>
      </nav>
    </header>
  </div>
  <!-- ################################################################################################ -->
  <div id="breadcrumb" class="hoc clear"> 
    <ul>
      <li><a href="#">KaltiaControl</a></li>
      <li><a href="#">IdEmpresa</a></li>
      <li><a href="#">User</a></li>
      <li><a href="#">Inicio</a></li>
    </ul>
  </div>

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="container auth" class="clear">
    <h1 class="text-rigth">Datos Generales Empresa</h1>
    <div id="big-form" class="well auth-box">
      <form>
        <fieldset>

          <!-- Form Name -->
          <legend>Nice form example</legend>

          <div class="btn-group">
            <a href="index.html" class="btn btn-default">All</a>
            <a href="example1.html" class="btn btn-default">example 1</a>
            <a href="example2.html" class="btn btn-default">example 2</a>
          </div>


          <!-- Text input-->
          <div class="form-group">
            <label class=" control-label" for="textinput">Username</label>  
            <div class="">
              <input id="textinput" name="textinput" placeholder="Username" class="form-control input-md" type="text">
              <span class="help-block">help</span>  
            </div>
          </div>

          <!-- Password input-->
          <div class="form-group">
            <label class=" control-label" for="passwordinput">Password</label>
            <div class="">
              <input id="passwordinput" name="passwordinput" placeholder="Password" class="form-control input-md" type="password">
              <span class="help-block">help</span>
            </div>
          </div>

          <!-- Select Basic -->
          <div class="form-group">
            <label class=" control-label" for="selectbasic">Country</label>
            <div class="">
              <select id="selectbasic" name="selectbasic" class="form-control">
                <option value="1">Option one</option>
                <option value="2">Option two</option>
              </select>
            </div>
          </div>

          <!-- Multiple Radios -->
          <div class="form-group">
            <label class=" control-label" for="radios">Are you awesome</label>
            <div class="">
              <div class="radio">
                <label for="radios-0">
                  <input name="radios" id="radios-0" value="1" checked="checked" type="radio">
                  Yes
                </label>
              </div>
              <div class="radio">
                <label for="radios-1">
                  <input name="radios" id="radios-1" value="2" type="radio">
                  No
                </label>
              </div>
            </div>
          </div>

          <!-- Button -->
          <div class="form-group">
            <label class=" control-label" for="singlebutton">Do you like this button</label>
            <div class="">
              <button id="singlebutton" name="singlebutton" class="btn btn-primary">Button</button>
            </div>
          </div>
          <div class="form-group">
            <label class=" control-label" for="singlebutton">And this?</label>
            <div class="">
              <button id="singlebutton" name="singlebutton" class="btn btn-default">Button</button>
            </div>
          </div>


          <!-- Button (Double) -->
          <div class="form-group">
            <label class=" control-label" for="button1id">Double the action</label>
            <div class="">
              <button id="button1id" name="button1id" class="btn btn-success">Good Button</button>
              <button id="button2id" name="button2id" class="btn btn-danger">Scary Button</button>
            </div>
          </div>

          <!-- File Button --> 
          <div class="form-group">
            <label class=" control-label" for="filebutton">Avatar</label>
            <div class="">
              <input id="filebutton" name="filebutton" class="input-file" type="file">
            </div>
          </div>

          <!-- Select Multiple -->
          <div class="form-group">
            <label class=" control-label" for="selectmultiple">Category</label>
            <div class="">
              <select id="selectmultiple" name="selectmultiple" class="form-control" multiple="multiple">
                <option value="1">Option one</option>
                <option value="2">Option two</option>
              </select>
            </div>
          </div>

          <!-- Multiple Radios (inline) -->
          <div class="form-group">
            <label class=" control-label" for="radios">Do you like pie?</label>
            <div class=""> 
              <label class="radio-inline" for="radios-0">
                <input name="radios" id="radios-0" value="1" checked="checked" type="radio">
                yes
              </label> 
              <label class="radio-inline" for="radios-1">
                <input name="radios" id="radios-1" value="2" type="radio">
                No
              </label> 
              <label class="radio-inline" for="radios-2">
                <input name="radios" id="radios-2" value="3" type="radio">
                what is pie?
              </label> 
              <label class="radio-inline" for="radios-3">
                <input name="radios" id="radios-3" value="4" type="radio">
                I hate it!
              </label>
            </div>
          </div>

          <!-- Multiple Checkboxes -->
          <div class="form-group">
            <label class=" control-label" for="checkboxes">Extra features</label>
            <div class="">
              <div class="checkbox">
                <label for="checkboxes-0">
                  <input name="checkboxes" id="checkboxes-0" value="1" type="checkbox">
                  Paper plains
                </label>
              </div>
              <div class="checkbox">
                <label for="checkboxes-1">
                  <input name="checkboxes" id="checkboxes-1" value="2" type="checkbox">
                  Iron man
                </label>
              </div>
            </div>
          </div>

          <!-- Multiple Checkboxes (inline) -->
          <div class="form-group">
            <label class=" control-label" for="checkboxes">Any more?</label>
            <div class="">
              <label class="checkbox-inline" for="checkboxes-0">
                <input name="checkboxes" id="checkboxes-0" value="1" type="checkbox">
                One
              </label>
              <label class="checkbox-inline" for="checkboxes-1">
                <input name="checkboxes" id="checkboxes-1" value="2" type="checkbox">
                Two
              </label>
              <label class="checkbox-inline" for="checkboxes-2">
                <input name="checkboxes" id="checkboxes-2" value="3" type="checkbox">
                Drum and bass
              </label>
              <label class="checkbox-inline" for="checkboxes-3">
                <input name="checkboxes" id="checkboxes-3" value="4" type="checkbox">
                Dub
              </label>
            </div>
          </div>

          <!-- Search input-->
          <div class="form-group">
            <label class=" control-label" for="searchinput">Search Input</label>
            <div class="">
              <input id="searchinput" name="searchinput" placeholder="placeholder" class="form-control input-md" type="search">
              <p class="help-block">help</p>
            </div>
          </div>

          <!-- Textarea -->
          <div class="form-group">
            <label class=" control-label" for="textarea">Text Area</label>
            <div class="">                     
              <textarea class="form-control" id="textarea" name="textarea">default text</textarea>
            </div>
          </div>

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

</body>
</html>