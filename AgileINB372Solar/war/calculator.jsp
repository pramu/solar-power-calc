<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
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

<form name = "calculator" method="post" action = "/calculatorAct" id = "calculator" onsubmit = "return Validate()" onreset = "resetBtn()">
<div id="content">
	<table id="calculatorTable">
		<tr>
			<td>Savings (per Year):</td>
			<td><input type="text" name="savings" id="savings" placeholder="eg: 500" size="25"/>
				<span id="systemCostErrorMessage" style="visibility:hidden;"> </span></td>
		</tr>
		<tr>
			<td>AvgDailyHoursSun: (read only)</td>
			<td><input type="text" name="avgDailyHoursSun" id="avgDailyHoursSun" placeholder="eg: 500" size="25" value="4.5" readonly="True"/>
    			<span id="systemCostErrorMessage" style="visibility:hidden;"> </span></td>
		</tr>
		<tr>
			<td>DayTimeHourlyUsage: (read only)</td>
			<td><input type="text" name="dayTimeHourlyUsage" id="dayTimeHourlyUsage" placeholder="eg: 500" size="25" value="1" readonly="True"/>
    			<span id="systemCostErrorMessage" style="visibility:hidden;"> </span></td>
		</tr>
		<tr>
			<td>Tariff: (read only)</td>
			<td><input type="text" name="tariff" id="tariff" placeholder="eg: 500" size="25" value="0.1941" readonly="True"/>
    			<span id="systemCostErrorMessage" style="visibility:hidden;"> </span></td>
		</tr>
		<tr>
			<td>FeedInFee: (read only)</td>
			<td><input type="text" name="feedInFee" id="feedInFee" placeholder="eg: 500" size="25" value="0.05" readonly="True"/>
    			<span id="systemCostErrorMessage" style="visibility:hidden;"> </span></td>
		</tr>
	</table><!-- End calculatorTable -->
	
</div><!-- End content -->

<div id="buttons">
	<input type="submit" id="calculatorSubmit" value="Submit"/>
	<input type="submit" id="calculatorReset" value="Reset"/>
</div><!-- End buttons -->
</form><!-- End calculator -->

<div id="footer">
	<p><a href="#">HOME PAGE</a> | <a href="#">CALCULATOR</a> | <a href="#">SOLUTIONS</a> | <a href="#">PRODUCTS</a> | <a href="#">NEWS</a> | <a href="#">CONTACT US</a><br/>
	<span>Copyright � Agile Team One.</span></p>
</div><!-- End footer -->

</div><!-- End wrapper -->
</body>
</html>