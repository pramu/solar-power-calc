<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.inb372.project.BusinessTier"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<META NAME="Author1" CONTENT="n7484798 honggyu kim"> 
    <META NAME="Subject" CONTENT="user input data form">
	<title>Calculator form</title>
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="validation.js"></script>

</head>

<body>

<div id="container">

<div id="headerPan">

<ul class="menu">
    <li class="b01"><a href="/homeAct" title="home page">home page</a></li>
    <li class="linem"></li>
    <li class="b02"><a href="/calculatorAct" title="calculator">calculator</a></li>
    <li class="linem"></li>
    <li class="b03"><a href="#" title="solutions">solutions</a></li>
    <li class="linem"></li>
    <li class="b04"><a href="/systemAct" title="products">products</a></li>
    <li class="linem"></li>
    <li class="b05"><a href="#" title="news">news</a></li>
    <li class="linem"></li>
    <li class="b06"><a href="#" title="contacts">contacts</a></li>
</ul>


</div>

<form name = "calculator" method="post" action = "/calculatorAct" id = "calculator" onsubmit = "return Validate()" onreset = "resetBtn()"> 
 
<div  class = "calculatorForm">
<h1>Calculation Result</h1>
<pre>
You require a system of a minimum size <%
 double systemSizeKw = (Double)request.getSession().getAttribute("systemSizeKw");	
 out.print(systemSizeKw);
	request.getSession().removeAttribute("systemSizeKw");%> kw.
 
 <center>  
<input type="submit" value="Back"> 
</center>
</pre>
</div>
</form>


<div class="clear"></div>

</div>

<div id="footerPan">

    <p><a href="#">HOME</a> | <a href="#">ABOUT US</a> | <a href="#">SOLUTIONS</a> | <a href="#">PRODUCTS</a> | <a href="#">NEWS</a> | <a href="#">CONTACT US</a><br/>
  <span>Copyright &copy; Your Company Name. Designed by <a href="http://www.templateyes.com" target="_blank">TemplateYes</a></span></p>

</div>