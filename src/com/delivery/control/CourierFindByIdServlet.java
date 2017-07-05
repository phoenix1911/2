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

public class CourierFindByIdServlet extends HttpServlet {

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
		
		String cname=request.getParameter("cname");		
		try {
		    CourierDaoImpl cdao = new CourierDaoImpl();
			Courier c=cdao.findById(cname);
			request.setAttribute("c", c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("isErrorpage.jsp");return;
		}
		
	   RequestDispatcher view = request.getRequestDispatcher("courier_c.jsp");
		   view.forward(request, response);

}
}