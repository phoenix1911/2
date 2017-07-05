package com.delivery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.delivery.dao.CourierDao;
import com.delivery.pojo.Courier;
import com.delivery.util.DBUtils;

/**
 * CourierDao的具体实现类
 * @author lamp
 *
 */
public class CourierDaoImpl implements CourierDao{

	/**
	 * 实现添加方法
	 */
	@Override
	public void add(Courier c) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into courier(cname,csex,cage,cphone)values(?,?,?,?)";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getCname());
			ps.setString(2, c.getCsex());
			ps.setInt(3, c.getCage());
			ps.setString(4, c.getCphone());
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("添加数据失败");
		}finally{
			DBUtils.close(null, ps, conn);
		}
	}

	/**
	 * 更新方法
	 */
	@Override
	public void update(String cname,String csex,int cage,String cphone,String ocname) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update courier set cname=?,csex=?,cage=?,cphone=? where cname=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cname);
			ps.setString(2, csex);
			ps.setInt(3, cage);
			ps.setString(4, cphone);
			ps.setString(5,ocname);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		}finally{
			DBUtils.close(null, ps, conn);
		}		
	}

	/**
	 * 删除方法
	 */
	@Override
	public void delete(String cname) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from courier where cname=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,cname);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException(" 删除数据失败");
		}finally{
			DBUtils.close(null, ps, conn);
		}		
	}

	/**
	 * 根据ID查询一个对象
	 */
	@Override
	public Courier findById(String cname) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Courier p = null;
		String sql = "select cname,csex,cage,cphone from courier where cname=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cname);
			rs = ps.executeQuery();
			if(rs.next()){
				p = new Courier();
				p.setCname(rs.getString(1));
				p.setCsex(rs.getString(2));
				p.setCage(rs.getInt(3));
				p.setCphone(rs.getString(4));
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("根据ID查询数据失败");
		}finally{
			DBUtils.close(rs, ps, conn);
		}
		return p;
	}

	/**
	 * 查询所有数据
	 */
	@Override
	public List<Courier> findAll() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Courier c = null;
		List<Courier> couriers = new ArrayList<Courier>();
		String sql = "select cname,csex,cage,cphone from courier";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				c = new Courier();
				c.setCname(rs.getString(1));
				c.setCsex(rs.getString(2));
				c.setCage(rs.getInt(3));
				c.setCphone(rs.getString(4));
				couriers.add(c);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("查询所有数据失败");
		}finally{
			DBUtils.close(rs, ps, conn);
		}
		return couriers;
	}

}