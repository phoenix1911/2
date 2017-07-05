package com.delivery.dao;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.delivery.pojo.Good;

public interface GoodDao {
	    //添加方法
		public void add(Good g)throws SQLException;
		
		//更新方法
		void update(String gno, String gname, String gaddress, String rname,
				String cname, Date intime, Date outtime, Date endtime,
				String state, String ogno) throws SQLException;
		
		//删除方法
		public void delete(String gno)throws SQLException;
		
		//查找方法
		public Good findById(String gno)throws SQLException;
		
		//查找所有
		public List<Good> findAll()throws SQLException;

		//查找未发货
		 public List<Good> findWei() throws SQLException;
		 
        //发货修改
		 public void fahuo(String gno,Date outtime) throws SQLException;
		 
		//查找已发货
		 public List<Good> findYi() throws SQLException;
		 
		//查找已完成
		 public List<Good> findWan() throws SQLException;
        
		//结束修改
		 public void jieshu(String gno, Date endtime) throws SQLException; 
		 
		//异常处理
		 public List<Good> findYu() throws SQLException ;

	
		
}
