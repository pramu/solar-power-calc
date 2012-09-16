<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.inb372.project.BusinessTier"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>System View</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="validation.js"></script>

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
	<h1>System Detail:</h1>
	<table id="systemTable" border="1">
		<tr>
			<th>Cost</th>
			<th>Size</th>
			<th>Detail</th>
		</tr>
		<%for(int i = 0; i <BusinessTier.GetSystemListSize(); i++){ %>
		<tr>
			<td><% out.print("$"+BusinessTier.GetSystemTotal(i)); %></td>
			<td><% out.print(BusinessTier.GetSystemSize(i)+"KW"); %></td>
		<%long name=BusinessTier.GetSystemID(i);%>
			<td><a href=panelview.jsp?Detail=<%=name%>>Detail</a></td>
		</tr>
		<% } %>
	</table><!-- End systemTable -->
</div><!-- End content -->


<div id="footer">
	<p><a href="#">HOME PAGE</a> | <a href="#">CALCULATOR</a> | <a href="#">SOLUTIONS</a> | <a href="#">PRODUCTS</a> | <a href="#">NEWS</a> | <a href="#">CONTACT US</a><br/>
	<span>Copyright © Agile Team One.</span></p>
</div><!-- End footer -->

</div><!-- End wrapper -->
</body>
</html>