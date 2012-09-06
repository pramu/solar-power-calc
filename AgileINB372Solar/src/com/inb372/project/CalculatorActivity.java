package com.inb372.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class CalculatorActivity extends HttpServlet {
	 
    public void doGet(HttpServletRequest request, HttpServletResponse resp)
                throws IOException {

    	resp.sendRedirect("/calculatetor.jsp");

    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws IOException {
    	
    	 String systemCost = request.getParameter("systemCost");
    	 String systemSize = request.getParameter("systemSize");
    	  
         if (systemCost != null) {
        	 BusinessTire.InsertCalculatorData(systemCost, systemSize);
         }
         
       //temp insert methods
        BusinessTire.InsertSystemData("18000", "4.95","8","20","96","3220");
        BusinessTire.InsertSystemData("20000", "3.99","10", "20", "97", "3400");
        BusinessTire.InsertSystemData("13000", "5.11","4","11","89","2820");
        BusinessTire.InsertSystemData("20330", "5.11","10", "21", "99", "3799");
        BusinessTire.InsertSystemData("19889", "5.00","7", "17", "95", "3338");
        
        
         resp.sendRedirect("/calculatetorresult.jsp");
    }
  
   
}