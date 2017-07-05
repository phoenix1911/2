package com.delivery.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delivery.dao.impl.GoodDaoImpl;
import com.delivery.pojo.Good;

public class GoodDeleteServlet extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		String gno=new String(request.getParameter("gno").getBytes("ISO-8859-1"),"UTF-8");		
		try {
		    GoodDaoImpl gdao = new GoodDaoImpl();
		    Good g=gdao.findById(gno);
		    if(g==null){
		    	response.sendRedirect("isErrorpage.jsp");return;
		    }
			gdao.delete(g.getGno());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("isErrorpage.jsp");return;
		}
		
	   RequestDispatcher view = request.getRequestDispatcher("/goodfindall");
		   view.forward(request, response);

	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
