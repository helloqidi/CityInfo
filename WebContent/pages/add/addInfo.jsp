<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>发布信息</title>
    <script type="text/javascript">
    	function resetValue(){
    		document.getElementById("infoTypeId").value="";
    		document.getElementById("title").value="";
    		document.getElementById("content").value="";
    		document.getElementById("phone").value="";
    		document.getElementById("linkman").value="";
    		document.getElementById("email").value="";
    	}
    	
    	function checkForm(){
    		var typeId=document.getElementById("typeId").value;
    		var title=document.getElementById("title").value;
    		var content=document.getElementById("content").value;
    		var phone=document.getElementById("phone").value;
    		var linkman=document.getElementById("linkman").value;
    		var email=document.getElementById("email").value;
    		if(typeId==null || typeId==""){
    			alert("请选择信息类别！");
    			return;
    		}else if(title==null || title==""){
    			alert("请输入标题！");
    			return;
    		}else if(content==null || content==""){
    			alert("请输入内容！");
    			return;
    		}else if(phone==null || phone==""){
    			alert("请输入联系电话！");
    			return;
    		}else if(linkman==null || linkman==""){
    			alert("请输入联系人！");
    			return;
    		}else if(email==null || email==""){
    			alert("请输入Email！");
    			return;
    		}else{
    			document.getElementById("addInfoForm").submit();
    		}
    	}
    </script>
</head>
<body>
    <center>
    <table border="0" cellpadding="0" cellspacing="0" width="688" height="100%">
        <tr height="20"><td><img src="images/default_t.jpg"></td></tr>
        <tr>
            <td background="images/default_m.jpg" valign="top" align="center">
            	<form id="addInfoForm" action="cityinfo/info!addInfo" method="post">
                <input type="hidden" name="addType" value="add"/>
                <table border="0" width="650" height="300" rules="all" cellspacing="0">
                    <tr height="30"><td style="text-indent:10"><font color="#004790"><b>■发布信息</b></font></td></tr>
                    <tr>
                        <td align="center">
                            <table border="0" width="650" rules="all" cellspacing="8">                    
                                <tr>
                                    <td width="20%" style="text-indent:10">信息类别：</td>
                                    <td>
                                    	<select id="typeId" name="info.typeId">
                                    	<option value="">请选择...</option>
                                    	<c:forEach var="infoType" items="${infoTypeList }">
                                    		<option value="${infoType.id }">${infoType.typeName}</option>
                                    	</c:forEach>
                                    	</select>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-indent:10">信息标题：</td>
                                    <td><input type="text" id="title" name="info.title" value="${info.title }" size="80" maxlength="40"/></td>                        
                                </tr>
                                <tr>
                                    <td style="text-indent:10" valign="top">信息内容：</td> 
                                    <td align="center"><textarea id="content" name="info.content" rows="12" cols="60">${info.content }</textarea></td>
                                </tr>
                                <tr>
                                    <td style="text-indent:10">联系电话：</td>
                                    <td ><input type="text" id="phone" name="info.phone" value="${info.phone }" size="55"/></td>
                                </tr>
                                <tr>
                                    <td style="text-indent:10">联 系 人：</td>
                                    <td><input type="text" id="linkman" name="info.linkman" value="${info.linkman }" size="55"/></td>
                                </tr>
                                <tr>
                                    <td style="text-indent:10">E - mail：</td>
                                    <td ><input type="text" id="email" name="info.email" value="${info.email }" size="55"></td>                    
                                </tr>
                            </table>                
                        </td>
                    </tr>
                    <tr align="center" height="50">
                        <td>
                        	<input type="button" onclick="checkForm()" value="发布"/>
                        	<input type="button" onclick="resetValue()" value="重填"/>
                        </td>
                    </tr>
                </table>
                </form>         
            </td>
        </tr>
        <tr height="26"><td><img src="images/default_e.jpg"/></td></tr>        
    </table>
    </center>
    ${error }
</body>
</html>
