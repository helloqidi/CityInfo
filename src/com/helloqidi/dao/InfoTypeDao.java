package com.helloqidi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.helloqidi.model.InfoType;

public class InfoTypeDao {

	public ArrayList<InfoType> getInfoTypeList(Connection con)throws Exception{
		
		ArrayList<InfoType> infoTypeList=new ArrayList<InfoType>();
		String sql="select * from t_infoType order by typeSign";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			InfoType infoType=new InfoType();
			infoType.setId(rs.getInt("id"));
			infoType.setTypeSign(rs.getInt("typeSign"));
			infoType.setTypeName(rs.getString("typeName"));
			infoTypeList.add(infoType);
		}
		
		return infoTypeList;
	}
}
