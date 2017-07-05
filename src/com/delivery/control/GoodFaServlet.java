package com.delivery.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delivery.dao.impl.GoodDaoImpl;
import com.delivery.pojo.Good;

public class GoodFaServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String gno=new String(request.getParameter("gno").getBytes("ISO-8859-1"),"UTF-8");		
		try {
		    GoodDaoImpl gdao = new GoodDaoImpl();
		    Good g=gdao.findById(gno);
		    if(g==null){
		    	response.sendRedirect("isErrorpage.jsp");return;
		    }
			gdao.fahuo(g.getGno(),df.parse(df.format(date)));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("isErrorpage.jsp");return;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   RequestDispatcher view = request.getRequestDispatcher("goodfindwei.do");
		   view.forward(request, response);

	}

}
