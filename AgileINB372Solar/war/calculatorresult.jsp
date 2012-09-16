<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="wrapper">

<div id="header">
	<img src="/images/SolarCalculator.jpg" />
</div><!-- End header -->

<div id="navigation">
	<ul id="menu">
	    <li><a href="/homeAct" title="home page">Home Page</a></li>
	    <li><a href="/calculatorAct" title="calculator">Calculator</a></li>
	    <li><a href="#" title="solutions">Solutions</a></li>
	    <li><a href="/systemAct" title="products">Products</a></li>
	    <li><a href="#" title="news">News</a></li>
	    <li><a href="#" title="contacts">Contact Us</a></li>
	</ul>
</div><!-- End navigation -->

<div id="content">
	<h1>Calculation Result</h1>
	<p>You require a system of a minimum size 
	<b> 
	<% double systemSizeKw = (Double)request.getSession().getAttribute("systemSizeKw");	
		out.print(systemSizeKw);
		request.getSession().removeAttribute("systemSizeKw");%> 
	</b> kw.
</div><!-- End content -->

<div id="buttons">
	<% %> <!-- code for response.redirect here, return to calculator page -->
	<input type="button" value="Back" onclick="redirect()"> 
</div><!-- End buttons -->

<div id="footer">
	<p><a href="#">HOME PAGE</a> | <a href="#">CALCULATOR</a> | <a href="#">SOLUTIONS</a> | <a href="#">PRODUCTS</a> | <a href="#">NEWS</a> | <a href="#">CONTACT US</a><br/>
	<span>Copyright © Agile Team One.</span></p>
</div><!-- End footer -->

</div><!-- End wrapper -->
</body>
</html>