package com.inb372.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class SystemActivity extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse resp)
                throws IOException {

    	resp.sendRedirect("/systemview.jsp");

    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws IOException {
    	
    	
    }
  
   
}