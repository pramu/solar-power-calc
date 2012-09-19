<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.inb372.project.BusinessTier"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>System View</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="validation.js"></script>
<script type="text/javascript" src="script.js"></script>


</head>
<body onload="load();">
	<div id="wrapper">

		<div id="header"></div>
		<!-- End header -->

		<div id="navigation"></div>
		<!-- End navigation -->

		<div id="content">
			<h1>System Detail:</h1>
			<table id="systemTable" border="1">
				<tr>
					<th>Cost</th>
					<th>Size</th>
					<th>Detail</th>
				</tr>
				<%
					for (int i = 0; i < BusinessTier.GetSystemListSize(); i++) {
				%>
				<tr>
					<td>
						<%
							out.print("$" + BusinessTier.GetSystemTotal(i));
						%>
					</td>
					<td>
						<%
							out.print(BusinessTier.GetSystemSize(i) + "KW");
						%>
					</td>
					<%long name=BusinessTier.GetSystemID(i);%>
					<td><a href=panelview.jsp?Detail=<%=name%>>Detail</a></td>
				</tr>
				<%
					}
				%>
			</table>
			<!-- End systemTable -->
		</div>
		<!-- End content -->


		<div id="footer"></div>
		<!-- End footer -->

	</div>
	<!-- End wrapper -->
</body>
</html>