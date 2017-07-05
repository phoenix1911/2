package com.delivery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.delivery.dao.ReceiverDao;
import com.delivery.pojo.Receiver;
import com.delivery.util.DBUtils;

/**
 * RecevierDao的具体实现类
 * @author lamp
 *
 */
public class ReceiverDaoImpl implements ReceiverDao{

	/**
	 * 实现添加方法
	 */
	@Override
	public void add(Receiver r) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into receiver(rname,rsex,rage,rphone)values(?,?,?,?)";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, r.getRname());
			ps.setString(2, r.getRsex());
			ps.setInt(3, r.getRage());
			ps.setString(4, r.getRphone());
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
	public void update(String rname,String rsex,int rage,String rphone,String orname) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update receiver set rname=?,rsex=?,rage=?,rphone=? where rname=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, rname);
			ps.setString(2, rsex);
			ps.setInt(3, rage);
			ps.setString(4, rphone);
			ps.setString(5,orname);
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
	public void delete(String rname) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from receiver where rname=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,rname);
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
	public Receiver findById(String rname) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Receiver p = null;
		String sql = "select rname,rsex,rage,rphone from receiver where rname=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, rname);
			rs = ps.executeQuery();
			if(rs.next()){
				p = new Receiver();
				p.setRname(rs.getString(1));
				p.setRsex(rs.getString(2));
				p.setRage(rs.getInt(3));
				p.setRphone(rs.getString(4));
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
	public List<Receiver> findAll() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Receiver r = null;
		List<Receiver> receivers = new ArrayList<Receiver>();
		String sql = "select rname,rsex,rage,rphone from receiver";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				r = new Receiver();
				r.setRname(rs.getString(1));
				r.setRsex(rs.getString(2));
				r.setRage(rs.getInt(3));
				r.setRphone(rs.getString(4));
				receivers.add(r);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("查询所有数据失败");
		}finally{
			DBUtils.close(rs, ps, conn);
		}
		return receivers;
	}

}
