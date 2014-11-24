package com.helloqidi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.helloqidi.model.Info;

public class InfoDao {

	//列表
	public ArrayList<Info> getInfoList(Connection con,String sql)throws Exception{
		//后期的查询会比较负责，所以sql的拼写放到action层
		ArrayList<Info> infoList=new ArrayList<Info>();
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Info info=new Info();
			info.setId(rs.getInt("id"));
			info.setTypeId(rs.getInt("typeId"));
			info.setTitle(rs.getString("title"));
			info.setContent(rs.getString("content"));
			info.setLinkman(rs.getString("linkman"));
			info.setPhone(rs.getString("phone"));
			info.setEmail(rs.getString("email"));
			info.setInfoDate(rs.getDate("infoDate"));
			info.setState(rs.getInt("state"));
			info.setPayfor(rs.getInt("payfor"));
			info.setTypeName(rs.getString("typeName"));
			infoList.add(info);
		}
		
		return infoList;
		
	}

	//根据id查询
	public Info getInfoById(Connection con,String id)throws Exception{
		String sql="select * from t_info t1,t_infotype t2 where t1.typeId=t2.id and t1.id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		Info info=new Info();
		while(rs.next()){
			info.setId(rs.getInt("id"));
			info.setTypeId(rs.getInt("typeId"));
			info.setTitle(rs.getString("title"));
			info.setContent(rs.getString("content"));
			info.setLinkman(rs.getString("linkman"));
			info.setPhone(rs.getString("phone"));
			info.setEmail(rs.getString("email"));
			info.setInfoDate(rs.getDate("infoDate"));
			info.setState(rs.getInt("state"));
			info.setPayfor(rs.getInt("payfor"));
			info.setTypeName(rs.getString("typeName"));
		}
		return info;
	}
	
	//增加
	public int addInfo(Connection con,Info info)throws Exception{
		String sql="insert into t_info values(null,?,?,?,?,?,?,now(),0,0)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, info.getTypeId());
		pstmt.setString(2, info.getTitle());
		pstmt.setString(3, info.getContent());
		pstmt.setString(4, info.getLinkman());
		pstmt.setString(5, info.getPhone());
		pstmt.setString(6, info.getEmail());
		return pstmt.executeUpdate();
	}

	//删除
	public int deleteInfo(Connection con,String id)throws Exception{
		String sql="delete from t_info where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	//审核
	public int checkInfo(Connection con,String id)throws Exception{
		String sql="update t_info set state=1 where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}

}
