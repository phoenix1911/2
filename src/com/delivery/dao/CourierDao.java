package com.delivery.dao;

import java.sql.SQLException;
import java.util.List;

import com.delivery.pojo.Courier;

public interface CourierDao {
	//��ӷ���
	public void add(Courier c)throws SQLException;
	
	//���·���
	void update(String cname, String csex, int cage, String cphone,String ocname) throws SQLException;
	
	//ɾ������
	public void delete(String cname)throws SQLException;
	
	//���ҷ���
	public Courier findById(String cname)throws SQLException;
	
	//��������
	public List<Courier> findAll()throws SQLException;


	
}
