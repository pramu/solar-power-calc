<?xml version="1.0" encoding="UTF-8"?>
<%@ page import="com.inb372.project.BusinessTire"%>
<lists>
	<% for(int i=0; i<BusinessTire.GetSystemListSize(); i++){
		out.print("<data><systemTotal>"+BusinessTire.GetSystemTotal(i)+"</systemTotal><systemSize>"+BusinessTire.GetSystemSize(i)+"</systemSize><panelPrice>"+BusinessTire.GetPanelPrice(i)+"</panelPrice><panelEfficency>"+BusinessTire.GetPanelEfficency(i)+"</panelEfficency><panelSize>"+BusinessTire.GetPanelSize(i)+"</panelSize></data>");	
	}%>
</lists>

