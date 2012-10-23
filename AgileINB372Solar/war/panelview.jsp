<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.inb372.project.BusinessTier"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Panel Information</title>
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
			<h1>System ID:</h1>
			<%
				String panelID = request.getParameter("Detail");
				out.print(panelID);
			%>
			<h1>Panel Detail:</h1>
			<table id="panelTable" border="1">
				<tr>
					<th>Price</th>
					<th>Efficiency</th>
					<th>Size</th>
					<th>Quantity</th>
				</tr>
				<%
					for (int i = 0; i < BusinessTier.GetPanelListSize(); i++) {
				%>
				<%
					if (BusinessTier.GetPanelSystemID(i).equals(panelID)) {
				%>
				<tr>
					<td>
						<%
							out.print("$" + BusinessTier.GetPanelPrice(i));
						%>
					</td>
					<td>
						<%
							out.print(BusinessTier.GetPanelEfficency(i) + "%");
						%>
					</td>
					<td>
						<%
							out.print(BusinessTier.GetPanelSize(i));
						%>
					</td>
					<td>
						<%
							out.print(BusinessTier.GetPanelQuentity(i));
						%>
					</td>
				</tr>
				<%
					}
				%>
				<%
					}
				%>
			</table>
			<!-- End panelTable -->
		</div>
		<!-- End content -->


		<div id="footer"></div>
		<!-- End footer -->

	</div>
	<!-- End wrapper -->
</body>
</html>