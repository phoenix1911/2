package com.delivery.dao;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.delivery.pojo.Good;

public interface GoodDao {
	    //��ӷ���
		public void add(Good g)throws SQLException;
		
		//���·���
		void update(String gno, String gname, String gaddress, String rname,
				String cname, Date intime, Date outtime, Date endtime,
				String state, String ogno) throws SQLException;
		
		//ɾ������
		public void delete(String gno)throws SQLException;
		
		//���ҷ���
		public Good findById(String gno)throws SQLException;
		
		//��������
		public List<Good> findAll()throws SQLException;

		//����δ����
		 public List<Good> findWei() throws SQLException;
		 
        //�����޸�
		 public void fahuo(String gno,Date outtime) throws SQLException;
		 
		//�����ѷ���
		 public List<Good> findYi() throws SQLException;
		 
		//���������
		 public List<Good> findWan() throws SQLException;
        
		//�����޸�
		 public void jieshu(String gno, Date endtime) throws SQLException; 
		 
		//�쳣����
		 public List<Good> findYu() throws SQLException ;

	
		
}
