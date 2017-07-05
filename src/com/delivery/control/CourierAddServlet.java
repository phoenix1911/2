package com.delivery.control;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delivery.dao.impl.CourierDaoImpl;
import com.delivery.pojo.Courier;

public class CourierAddServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		String cname=request.getParameter("cname");
		String csex=request.getParameter("csex");
		int cage=Integer.parseInt(request.getParameter("cage"));
		String cphone=request.getParameter("cphone");
		
		try {
			Courier courier = new Courier(cname,csex,cage,cphone); 
		    CourierDaoImpl cdao = new CourierDaoImpl();
			cdao.add(courier);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NumberFormatException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("isErrorpage.jsp");return;
		}

		   RequestDispatcher view = request.getRequestDispatcher("/courierfindall");
		   view.forward(request, response);

}
}
