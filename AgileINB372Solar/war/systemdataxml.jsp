<?xml version="1.0" encoding="UTF-8"?>
<%@ page import="com.inb372.project.BusinessTier"%>
<lists>
	<% for(int i=0; i<BusinessTier.GetSystemListSize(); i++){
		out.print("<data><systemTotal>"+BusinessTier.GetSystemTotal(i)+"</systemTotal><systemSize>"+BusinessTier.GetSystemSize(i)+"</systemSize><panelPrice>"+BusinessTier.GetPanelPrice(i)+"</panelPrice><panelEfficency>"+BusinessTier.GetPanelEfficency(i)+"</panelEfficency><panelSize>"+BusinessTier.GetPanelSize(i)+"</panelSize><panelQuentity>"+BusinessTier.GetPanelQuentity(i)+"</panelQuentity></data>");	
	}%>
</lists>

