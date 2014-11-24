package com.helloqidi.action;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.helloqidi.dao.InfoDao;
import com.helloqidi.model.Info;
import com.helloqidi.util.DbUtil;
import com.opensymphony.xwork2.ActionSupport;

public class InfoAction extends ActionSupport implements ServletRequestAware{
	
	private HttpServletRequest request;
	
	private static final long serialVersionUID = 1L;
	private String keyword;
	private String condition;
	private String searchType;
	private String id;
	private String typeId;
	
	private DbUtil dbUtil=new DbUtil();
	private InfoDao infoDao=new InfoDao();
	
	private Info info;

	
	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}


	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	//搜索列表
	public String searchInfo()throws Exception{
		request.setAttribute("mainPage", "/pages/show/searchInfo.jsp");
		StringBuffer sb=new StringBuffer("select * from t_info t1,t_infotype t2 where t1.typeId=t2.id ");
		if("like".equals(searchType)){
			sb.append(" and t1."+condition+" like '%"+keyword+"%'");
		}else{
			sb.append(" and t1."+condition+"='"+keyword+"'");
		}
		sb.append(" order by t1.infoDate desc ");
		Connection con=dbUtil.getCon();
		ArrayList<Info> searchInfoList=infoDao.getInfoList(con, sb.toString());
		request.setAttribute("searchInfoList", searchInfoList);
		return "searchInfo";
	}

	//详情
	public String detailsInfo()throws Exception{
		request.setAttribute("mainPage", "/pages/show/detailsInfo.jsp");
		Connection con=dbUtil.getCon();
		info=infoDao.getInfoById(con, id);
		return "detailsInfo";
	}

	//根据分类查询信息
	public String getInfoByType()throws Exception{
		request.setAttribute("mainPage", "/pages/show/searchInfo.jsp");
		String sql="select * from t_info t1,t_infotype t2 where t1.typeId=t2.id and t1.typeId="+typeId+" order by t1.infodate desc";
		Connection con=dbUtil.getCon();
		ArrayList<Info> searchInfoList=infoDao.getInfoList(con, sql);
		request.setAttribute("searchInfoList", searchInfoList);
		return "searchInfo";
	}


	//新增页面
	public String preparedAddInfo()throws Exception{
		request.setAttribute("mainPage", "/pages/add/addInfo.jsp");
		return "addInfo";
	}
	
	//新增表单
	public String addInfo()throws Exception{
		Connection con=dbUtil.getCon();
		int num=infoDao.addInfo(con, info);
		if(num==1){
			request.setAttribute("mainPage", "/pages/add/addInfoSuccess.jsp");
			return "addInfoSuccess";
		}else{
			request.setAttribute("error", "添加失败");
			request.setAttribute("mainPage", "/pages/add/addInfo.jsp");
			return "addInfo";
		}
	}


	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

}
