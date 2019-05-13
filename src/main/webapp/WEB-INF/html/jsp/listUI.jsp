<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/resources/common/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>用户管理</title>
    
    <script type="text/javascript">
      	//全选、全反选
		function doSelectAll(){
			$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
		}
		function doAdd(){
		     document.forms[0].action="${basePath}/user_addUI.action";
		     document.forms[0].submit();
		
		}
			function doEdit(id){
		     document.forms[0].action="${basePath}/user_editUI.action?user.id="+id;
		     document.forms[0].submit();
		
		}
			function doDelete(id){
		     document.forms[0].action="${basePath}/user_delete.action?user.id="+id;
		     document.forms[0].submit();
		
		}
			function doDeleteAll(){
		     document.forms[0].action="${basePath}/user_deleteSelected.action";
		     document.forms[0].submit();
		
		}
		function doExportExcel(){
		     window.open("${basePath}/user_downexcel.action");
		  
		    
		
		}
		function doImportExcel(){
		     document.forms[0].action="${basePath}/user_importExcel.action";
		     document.forms[0].submit();
		
		}
		function doSearch(){
		   document.forms[0].action="${basePath}/user_listUI.action";
		   document.forms[0].submit();
		
		}
		function doGoPage(page){
		   document.forms[0].action="${basePath}/user_listUI.action?page="+page;
		   document.forms[0].submit();
		}
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>用户管理</strong></div> </div>
                <div class="search_art">
                    <li>
                  
                        用户名：<input name="user.name" cssClass="s_text" id="userName"  cssStyle="width:160px;"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/>&nbsp;&nbsp;&nbsp;<span style="color:red;font-size:18px;">${error}</span></li>
                    
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd()"/>&nbsp;
                        <input type="button" value="删除" class="s_button" onclick="doDeleteAll()"/>&nbsp;
                        <input type="button" value="导出" class="s_button" onclick="doExportExcel()"/>&nbsp;
                    	<input name="headImg" type="file"/>
                        <input type="button" value="导入" class="s_button" onclick="doImportExcel()"/>&nbsp;

                    </li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()" value=/></td>
                            <td width="140" align="center">用户名</td>
                            <td width="140" align="center">帐号</td>
                            <td width="160" align="center">所属部门</td>
                            <td width="80" align="center">性别</td>
                            <td align="center">电子邮箱</td>
                            <td width="100" align="center">操作</td>
                        </tr>
                         <c:forEach  items="userList" var="user" varStatus="sta">
                            <tr <c:if test="#sta.odd">bgcolor="#f8f8f8" </c:if>>
                                <td align="center"><input type="checkbox" name="selectedRow" value='${id}'/></td>
                                <td align="center">${name}</td>
                                <td align="center">${account}</td>
                                <td align="center">${dept}</td>
                                <td align="center">${gender?'男':'女'}</td>
                                <td align="center">${email}</td>
                                <td align="center">
                                    <a href="javascript:doEdit('${id}')">编辑</a>
                                    <a href="javascript:doDelete('${id}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        
                    </table>
                </div>
            </div>
        <div class="c_pate" style="margin-top: 5px;">
		<table width="100%" class="pageDown" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="right">
                 	总共 ${pageBean.count}条记录，当前第 ${pageBean.page} 页，共  ${pageBean.totalPage}页 &nbsp;&nbsp;
                 	        <a href="javascript:doGoPage(1)">首页</a> &nbsp;&nbsp;
                 	        <c:if test="pageBean.page>=1&&pageBean.page<pageBean.totalPage">
                            <a href="javascript:doGoPage(${pageBean.page +1})">下一页</a>&nbsp;&nbsp;
                            </c:if>
                            <c:if test="pageBean.page>1">
                            <a href="javascript:doGoPage(${pageBean.page -1})">上一页</a> &nbsp;&nbsp;
                            </c:if>
                            <a href="javascript:doGoPage(${pageBean.totalPage})">尾页</a>&nbsp;
					到&nbsp;<input type="text" style="width: 30px;" onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1"
					max="${pageBean.totalPage}" value="1" /> &nbsp;&nbsp;
			    </td>
			</tr>
		</table>	
        </div>
        </div>
    </div>
</form>

</body>
</html>