package com.demo3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo3.entity.DemoEntity;
import com.demo3.service.DemoService;
import com.demo3.service.DemoServiceInterface;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlobalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       out.println("<html><body>");
       
       String option=request.getParameter("ac");
       if(option.equals("login"))
{
	 String username=request.getParameter("username");
	 String password=request.getParameter("pass");
        DemoEntity de=new DemoEntity();
        de.setUsername(username);
        de.setPassword(password);
        
        DemoServiceInterface dsi=DemoService.createServiceObject();
        int i=dsi.createProfile(de);
        if(i>0)
        	out.println("profile created");
        else
        	out.println("not crerated");


}out.println("</body></html>");
       
	
	
	
	
	}

}
