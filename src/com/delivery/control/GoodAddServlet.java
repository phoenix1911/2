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

public class GoodAddServlet extends HttpServlet {

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
		
		SimpleDateFormat sim1=new SimpleDateFormat("yyyy-MM-dd");
/*		SimpleDateFormat sim2=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sim3=new SimpleDateFormat("yyyy-MM-dd");*/
		String gno=request.getParameter("gno");
		String gname=request.getParameter("gname");
		String gaddress=request.getParameter("gaddress");
		String rname=request.getParameter("rname");
		String cname=request.getParameter("cname");
		Date intime = null;
		Date outtime = null;
		Date endtime = null;
		try {
			intime = sim1.parse(request.getParameter("intime"));
/*			outtime = sim2.parse(request.getParameter("outtime"));
			endtime = sim3.parse(request.getParameter("endtime"));*/
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String state=request.getParameter("state");
		try {
			Good good = new Good(gno,gname,gaddress,rname,cname,intime,outtime,endtime,state); 
		    GoodDaoImpl gdao = new GoodDaoImpl();
			gdao.add(good);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NumberFormatException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("isErrorpage.jsp");return;
		}

		   RequestDispatcher view = request.getRequestDispatcher("/goodfindall");
		   view.forward(request, response);

	}

}