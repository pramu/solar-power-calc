<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Calculator Results</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="validation.js"></script>
<script type="text/javascript" src="script.js"></script>
</head>
<body onload="load();">
<div id="wrapper">

<div id="header"></div><!-- End header -->

<div id="navigation"></div><!-- End navigation -->

<div id="content">
	<h1>Calculation Result</h1>
	<p>The System will payoff in
	<b> 
	<% double numMonths = (Double)request.getSession().getAttribute("numMonths");	
		out.print(numMonths);
		request.getSession().removeAttribute("numMonths");%> 
	</b> months.
</div><!-- End content -->

<div id="buttons">
	<% %> <!-- code for response.redirect here, return to calculator page -->
	<input type="button" value="Back" onclick="redirect()"/> 
</div><!-- End buttons -->

<div id="footer"></div><!-- End footer -->

</div><!-- End wrapper -->
</body>
</html>