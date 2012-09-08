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

    	resp.sendRedirect("/calculator.jsp");

    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws IOException {
    	
    	/* String systemCost = request.getParameter("systemCost");
    	 String systemSize = request.getParameter("systemSize");
    	  
         if (systemCost != null) {
        	 BusinessTier.InsertCalculatorData(systemCost, systemSize);
         }
         
       //temp insert methods
        BusinessTier.InsertSystemData("18000", "4.95","8","20","96","3220");
        BusinessTier.InsertSystemData("20000", "3.99","10", "20", "97", "3400");
        BusinessTier.InsertSystemData("13000", "5.11","4","11","89","2820");
        BusinessTier.InsertSystemData("20330", "5.11","10", "21", "99", "3799");
        BusinessTier.InsertSystemData("19889", "5.00","7", "17", "95", "3338");
        */
    	
    	double savings = Double.parseDouble(request.getParameter("savings"));
    	double avgDailyHoursSun = Double.parseDouble(request.getParameter("avgDailyHoursSun"));
    	double dayTimeHourlyUsage = Double.parseDouble(request.getParameter("dayTimeHourlyUsage"));
    	double tariff = Double.parseDouble(request.getParameter("tariff"));
    	double feedInFee = Double.parseDouble(request.getParameter("feedInFee"));
    	double systemSizeKw;
    
    		systemSizeKw = BusinessTier.calculateMinKw(savings, avgDailyHoursSun, dayTimeHourlyUsage, tariff, feedInFee);
    	
    		request.getSession().setAttribute("systemSizeKw",systemSizeKw);
    		resp.sendRedirect("/calculatorresult.jsp");
   
    }
  
   
}