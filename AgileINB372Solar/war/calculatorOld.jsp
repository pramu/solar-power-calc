<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<META NAME="Author1" CONTENT="n7484798 honggyu kim"> 
    <META NAME="Subject" CONTENT="user input data form">
	<title>Calculator form</title>
	<link href="css/stylesOld.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="validation.js"></script>

</head>

<body>

<div id="container">

<div id="navigation">

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


</div><!-- End Navigation -->

<form name = "calculator" method="post" action = "/calculatorAct" id = "calculator" onsubmit = "return Validate()" onreset = "resetBtn()"> 
<div  class = "calculatorForm">
<p>
     Savings (per Year):
     </br> 
     <input type="text" name="savings" id ='savings' placeholder="eg: 500" size="25" />
     <span id='systemCostErrorMessage' style = 'visibility:hidden;'> </span>
     </br>     
     AvgDailyHoursSun: (read only) 
     <input type="text" name="avgDailyHoursSun" id ='avgDailyHoursSun' placeholder="eg: 500" size="25" value="4.5" readonly="True"/>
     <span id='systemCostErrorMessage' style = 'visibility:hidden;'> </span>
     </br>
     DayTimeHourlyUsage: (read only)
     <input type="text" name="dayTimeHourlyUsage" id ='dayTimeHourlyUsage' placeholder="eg: 500" size="25" value="1" readonly="True"/>
     <span id='systemCostErrorMessage' style = 'visibility:hidden;'> </span>
     </br>
     Tariff: (read only)
     <input type="text" name="tariff" id ='tariff' placeholder="eg: 500" size="25" value="0.1941" readonly="True"/>
     <span id='systemCostErrorMessage' style = 'visibility:hidden;'> </span>
     </br>
     FeedInFee: (read only)
     <input type="text" name="feedInFee" id ='feedInFee' placeholder="eg: 500" size="25" value="0.05" readonly="True"/>
     <span id='systemCostErrorMessage' style = 'visibility:hidden;'> </span>
     </br>
 
<input type="submit" id="calculatorSubmit" value="Submit"/> <input type="submit" id="calculatorReset" value="Reset"/>

</p>
</div> <!-- End calculatorForm -->
</form><!-- End calculator -->


<div id="footerPan">

    <p><a href="#">HOME</a> | <a href="#">ABOUT US</a> | <a href="#">SOLUTIONS</a> | <a href="#">PRODUCTS</a> | <a href="#">NEWS</a> | <a href="#">CONTACT US</a><br/>
  <span>Copyright &copy; Agile Team One.</span></p>

</div><!-- End footerPan -->
</div><!-- End Container -->