package com.delivery.dao;


import java.sql.SQLException;

import com.delivery.pojo.User;

public interface UserDao {
	
	public User login(User u)throws SQLException;
    
    
}
