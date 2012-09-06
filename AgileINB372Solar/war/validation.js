//To set error message
	var invalidBlank = "<font color='red'><i> Invalid - blank field</i></font>";
	var invalidChar = "<font color='red'><i> Invalid - illegal characters</i></font>";
	var message = "";
	
//declare all the values for getting texts from fields	
	var checkSystemCost;
 	var checkSystemSize;

function Validate() {
// to get the values from fields
	checkSystemCost = document.getElementById('systemCost');
 	checkSystemSize = document.getElementById('systemSize');
	checkReturn = true;
	
// call all the functions
	checkSystemCostFunction(checkSystemCost);	
	checkSystemSizeFunction(checkSystemSize);

	if(checkReturn){
		alert("This form has been sucessfully submitted!");
		return checkReturn;
	}
	else{
		alert("Please consider of validation");
		return checkReturn;
	}

}

/*#######################Validation of User Name ##################################*/	
function checkSystemCostFunction(checkSystemCost){	
 	
 	if(checkSystemCost.value == ""){ //check if it's blank
 		document.getElementById('systemCostErrorMessage').innerHTML = invalidBlank;
 		document.getElementById('systemCostErrorMessage').style.visibility = "visible"; 
 		checkSystemCost.focus();  //after Error Message, point out the text field
 		checkReturn = false;
 	}
	else{
		document.getElementById('systemCostErrorMessage').innerHTML = ""; //make it unvisiable
	}
	
}

/*#######################Validation of Phone Number ###############################*/			   	
function checkSystemSizeFunction(checkSystemSize){
 	var phoneNumLength = 10;
 	if(checkSystemSize.value == ""){
 		document.getElementById('systemSizeErrorMessage').innerHTML = invalidBlank;
 		checkSystemSize.focus();
 		checkReturn = false;
 	}
 	else if (!onlyDigits(checkSystemSize.value)) { //check if phone numbe has non-digits
 		document.getElementById('systemSizeErrorMessage').innerHTML = invalidChar; //giving Error Message
		checkSystemSize.focus();
		checkReturn = false;
	}
	else{
		document.getElementById('systemSizeErrorMessage').innerHTML = ""; //make it unvisiable
	}
	
}
	
/*#################Set reset button to clear error messages ############################*/	
function resetBtn(){ // delete all the error message after pressing reset button
	document.getElementById('systemCostErrorMessage').style.visibility = "hidden";
 	document.getElementById('systemSizeErrorMessage').innerHTML = message;									
}

/*#################Making another functions to vaildate some parts ############################*/	
// check to get only digits
function onlyDigits(String) { //using regular experession 
	digitExpression = /^[0-9]+$/; //expression only number 
    return digitExpression.test(String);
}
// check to get only Alphabets
function onlyAlphabetic(String) {
    alphabetExpression = /^[A-Za-z ]+$/; // expression only alphabetes, both upper and lower cases allow
	return alphabetExpression.test(String);
}

    

