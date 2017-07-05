package com.delivery.dao;

import java.sql.SQLException;
import java.util.List;

import com.delivery.pojo.Receiver;
	
public interface ReceiverDao {
		//��ӷ���
		public void add(Receiver r)throws SQLException;
		
		//���·���
		void update(String rname, String rsex, int rage, String rphone,String orname) throws SQLException;
		
		//ɾ������
		public void delete(String rname)throws SQLException;
		
		//���ҷ���
		public Receiver findById(String rname)throws SQLException;
		
		//��������
		public List<Receiver> findAll()throws SQLException;

		
		
}

