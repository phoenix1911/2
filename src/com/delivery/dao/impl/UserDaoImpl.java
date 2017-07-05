package com.delivery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.delivery.dao.UserDao;
import com.delivery.pojo.User;
import com.delivery.util.DBUtils;

public class UserDaoImpl implements UserDao{
	
	public User login(User user) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User resultUser=null;
		String sql="select * from user where username=? and password=?";
		
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
	        ps.setString(2, user.getPassword());
	        rs = ps.executeQuery();
	        if(rs.next()){
	            resultUser=new User();
	            resultUser.setUsername(rs.getString("username"));
	            resultUser.setPassword(rs.getString("password"));
	        }
        }catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("错误");
		}finally{
			DBUtils.close(rs, ps, conn);
		}
        return resultUser;
    }

}
