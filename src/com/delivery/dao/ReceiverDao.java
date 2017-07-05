package com.delivery.dao;

import java.sql.SQLException;
import java.util.List;

import com.delivery.pojo.Receiver;
	
public interface ReceiverDao {
		//添加方法
		public void add(Receiver r)throws SQLException;
		
		//更新方法
		void update(String rname, String rsex, int rage, String rphone,String orname) throws SQLException;
		
		//删除方法
		public void delete(String rname)throws SQLException;
		
		//查找方法
		public Receiver findById(String rname)throws SQLException;
		
		//查找所有
		public List<Receiver> findAll()throws SQLException;

		
		
}

