package com.delivery.dao;

import java.sql.SQLException;
import java.util.List;

import com.delivery.pojo.Courier;

public interface CourierDao {
	//添加方法
	public void add(Courier c)throws SQLException;
	
	//更新方法
	void update(String cname, String csex, int cage, String cphone,String ocname) throws SQLException;
	
	//删除方法
	public void delete(String cname)throws SQLException;
	
	//查找方法
	public Courier findById(String cname)throws SQLException;
	
	//查找所有
	public List<Courier> findAll()throws SQLException;


	
}
