package com.delivery.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delivery.dao.impl.ReceiverDaoImpl;
import com.delivery.pojo.Receiver;

public class ReceiverDeleteServlet extends HttpServlet {

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
		
		String rname=new String(request.getParameter("rname").getBytes("ISO-8859-1"),"UTF-8");		
		try {
			ReceiverDaoImpl rdao = new ReceiverDaoImpl();
			Receiver r=rdao.findById(rname);
		    if(r==null){
		    	response.sendRedirect("isErrorpage.jsp");return;
		    }
			rdao.delete(r.getRname());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("isErrorpage.jsp");return;
		}
		
	   RequestDispatcher view = request.getRequestDispatcher("/receiverfindall");
		   view.forward(request, response);

	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
