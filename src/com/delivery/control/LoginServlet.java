package com.delivery.control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.delivery.dao.impl.UserDaoImpl;
import com.delivery.pojo.User;

public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
    	
    	String username=request.getParameter("username");
        String password=request.getParameter("password");
        try {
        	UserDaoImpl uDao = new UserDaoImpl();
            User user=new User(username,password);
            User currentUser=uDao.login(user);
            if(currentUser==null){
                //System.out.println("no");
                request.setAttribute("error", "用户名或者密码错误");
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }else{
                //System.out.println("yes");
                HttpSession session=request.getSession();
                session.setAttribute("currentUser",currentUser);
                response.sendRedirect("demo.html");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    
}