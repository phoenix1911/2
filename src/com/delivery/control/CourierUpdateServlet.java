package com.delivery.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delivery.dao.impl.CourierDaoImpl;
import com.delivery.pojo.Courier;

public class CourierUpdateServlet extends HttpServlet {

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
		
/*		String cname=new String(request.getParameter("cname").getBytes("ISO-8859-1"),"UTF-8");
		String csex=new String(request.getParameter("csex").getBytes("ISO-8859-1"),"UTF-8");
		int cage=Integer.parseInt(new String(request.getParameter("cage").getBytes("ISO-8859-1"),"UTF-8"));
		String cphone=new String(request.getParameter("cphone").getBytes("ISO-8859-1"),"UTF-8");
		String ocname=new String(request.getParameter("ocname").getBytes("ISO-8859-1"),"UTF-8");*/
		String cname=request.getParameter("cname");
		String csex=request.getParameter("csex");
		int cage=Integer.parseInt(request.getParameter("cage"));
		String cphone=request.getParameter("cphone");
		String ocname=request.getParameter("ocname");
		try {
		    CourierDaoImpl cdao = new CourierDaoImpl();
		    cdao.update(cname,csex,cage,cphone,ocname);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("isErrorpage.jsp");return;
		}
		
		   RequestDispatcher view = request.getRequestDispatcher("/courierfindall");
		   view.forward(request, response);
	}

}
