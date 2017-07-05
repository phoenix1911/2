package com.delivery.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.delivery.dao.GoodDao;
import com.delivery.pojo.Good;
import com.delivery.util.DBUtils;

/**
 * GoodDao�ľ���ʵ����
 * @author lamp
 *
 */
public class GoodDaoImpl implements GoodDao{
	/**
	 * ʵ����ӷ���
	 */
	@Override
	public void add(Good g) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into good(gno,gname,gaddress,rname,cname,intime,outtime,endtime,state)values(?,?,?,?,?,?,?,?,?)";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, g.getGno());
			ps.setString(2, g.getGname());
			ps.setString(3, g.getGaddress());
			ps.setString(4, g.getRname());
			ps.setString(5, g.getCname());
			ps.setDate(6, new java.sql.Date(g.getIntime().getTime()));
			ps.setDate(7, null/*new java.sql.Date(g.getOuttime().getTime())*/);
			ps.setDate(8, null/*new java.sql.Date(g.getEndtime().getTime())*/);
			ps.setString(9, g.getState());
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("�������ʧ��");
		}finally{
			DBUtils.close(null, ps, conn);
		}
	}

	/**
	 * ���·���
	 */
	@Override
	public void update(String gno,String gname,String gaddress,String rname,String cname,Date intime,Date outtime,Date endtime,String state,String ogno) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update good set gno=?,gname=?,gaddress=?,rname=?,cname=?,intime=?,outtime=?,endtime=?,state=? where gno=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, gno);
			ps.setString(2, gname);
			ps.setString(3, gaddress);
			ps.setString(4, rname);
			ps.setString(5, cname);
			ps.setDate(6, new java.sql.Date (intime.getTime()));
			ps.setDate(7, null);
			ps.setDate(8, null);
			ps.setString(9, state);
			ps.setString(10,ogno);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("��������ʧ��");
		}finally{
			DBUtils.close(null, ps, conn);
		}		
	}

	/**
	 * ɾ������
	 */
	@Override
	public void delete(String gno) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from good where gno=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,gno);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException(" ɾ������ʧ��");
		}finally{
			DBUtils.close(null, ps, conn);
		}		
	}

	/**
	 * ����ID��ѯһ������
	 */
	@Override
	public Good findById(String gno) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Good p = null;
		String sql = "select* from good where gno=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, gno);
			rs = ps.executeQuery();
			if(rs.next()){
				p = new Good();
				p.setGno(rs.getString(1));
				p.setGname(rs.getString(2));
				p.setGaddress(rs.getString(3));
				p.setRname(rs.getString(4));
				p.setCname(rs.getString(5));
				p.setIntime(rs.getDate(6));
				p.setOuttime(rs.getDate(7));
				p.setEndtime(rs.getDate(8));
				p.setState(rs.getString(9));
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("����ID��ѯ����ʧ��");
		}finally{
			DBUtils.close(rs, ps, conn);
		}
		return p;
	}

	/**
	 * ��ѯ��������
	 */
	@Override
	public List<Good> findAll() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Good g = null;
		List<Good> goods = new ArrayList<Good>();
		String sql = "select * from good";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				g = new Good();
				g.setGno(rs.getString(1));
				g.setGname(rs.getString(2));
				g.setGaddress(rs.getString(3));
				g.setRname(rs.getString(4));
				g.setCname(rs.getString(5));
				g.setIntime(rs.getDate(6));
				g.setOuttime(rs.getDate(7));
				g.setEndtime(rs.getDate(8));
				g.setState(rs.getString(9));
				goods.add(g);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("��ѯ��������ʧ��");
		}finally{
			DBUtils.close(rs, ps, conn);
		}
		return goods;
	}
	/**
	 * ��ѯδ��������
	 */
	@Override
	public List<Good> findWei() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Good g = null;
		List<Good> goods = new ArrayList<Good>();
		String sql = "select * from good where outtime is null";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				g = new Good();
				g.setGno(rs.getString(1));
				g.setGname(rs.getString(2));
				g.setGaddress(rs.getString(3));
				g.setRname(rs.getString(4));
				g.setCname(rs.getString(5));
				g.setIntime(rs.getDate(6));
				g.setOuttime(rs.getDate(7));
				g.setEndtime(rs.getDate(8));
				g.setState(rs.getString(9));
				goods.add(g);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("��ѯδ��������ʧ��");
		}finally{
			DBUtils.close(rs, ps, conn);
		}
		return goods;
	}

	public void fahuo(String gno,Date outtime) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update good set outtime=?,state='已发货' where gno=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setDate(1,  new java.sql.Date (outtime.getTime()));
			ps.setString(2, gno);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("��������ʧ��");
		}finally{
			DBUtils.close(null, ps, conn);
		}	
	}

	public List<Good> findYi() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Good g = null;
		List<Good> goods = new ArrayList<Good>();
		String sql = "select * from good where (endtime is null and outtime is not null) ";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				g = new Good();
				g.setGno(rs.getString(1));
				g.setGname(rs.getString(2));
				g.setGaddress(rs.getString(3));
				g.setRname(rs.getString(4));
				g.setCname(rs.getString(5));
				g.setIntime(rs.getDate(6));
				g.setOuttime(rs.getDate(7));
				g.setEndtime(rs.getDate(8));
				g.setState(rs.getString(9));
				goods.add(g);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("��ѯδ��������ʧ��");
		}finally{
			DBUtils.close(rs, ps, conn);
		}
		return goods;
	}

	public void jieshu(String gno, Date endtime) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update good set endtime=?,state='结束派送' where gno=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setDate(1,  new java.sql.Date (endtime.getTime()));
			ps.setString(2, gno);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("��������ʧ��");
		}finally{
			DBUtils.close(null, ps, conn);
		}	
	}

	public List<Good> findWan() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Good g = null;
		List<Good> goods = new ArrayList<Good>();
		String sql = "select * from good where endtime is not null";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				g = new Good();
				g.setGno(rs.getString(1));
				g.setGname(rs.getString(2));
				g.setGaddress(rs.getString(3));
				g.setRname(rs.getString(4));
				g.setCname(rs.getString(5));
				g.setIntime(rs.getDate(6));
				g.setOuttime(rs.getDate(7));
				g.setEndtime(rs.getDate(8));
				g.setState(rs.getString(9));
				goods.add(g);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("��ѯδ��������ʧ��");
		}finally{
			DBUtils.close(rs, ps, conn);
		}
		return goods;
	}

public List<Good> findYu() throws SQLException {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Good g = null;
	List<Good> goods = new ArrayList<Good>();
	String sql = "select * from good where outtime is null and CURDATE()-intime>3";
	try{
		conn = DBUtils.getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()){
			g = new Good();
			g.setGno(rs.getString(1));
			g.setGname(rs.getString(2));
			g.setGaddress(rs.getString(3));
			g.setRname(rs.getString(4));
			g.setCname(rs.getString(5));
			g.setIntime(rs.getDate(6));
			g.setOuttime(rs.getDate(7));
			g.setEndtime(rs.getDate(8));
			g.setState(rs.getString(9));
			goods.add(g);
		}
	}catch(SQLException e){
		e.printStackTrace();
		throw new SQLException("��ѯδ��������ʧ��");
	}finally{
		DBUtils.close(rs, ps, conn);
	}
	return goods;
}

}
