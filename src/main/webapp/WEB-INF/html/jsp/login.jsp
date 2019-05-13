<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
<title>登录界面</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link href="${pageContext.request.contextPath}/resources/iconfont/style.css" type="text/css" rel="stylesheet">
<style>
	body{color:#fff; font-family:"微软雅黑"; font-size:14px;}
	.wrap1{position:absolute; top:0; right:0; bottom:0; left:0; margin:auto }/*把整个屏幕真正撑开--而且能自己实现居中*/
	.main_content{background:url(${pageContext.request.contextPath}/resources/images/mains_bg.png) repeat; margin-left:auto; margin-right:auto; text-align:left; float:none; border-radius:8px;}
	.form-group{position:relative;}
	.login_btn{display:block; background:#3872f6; color:#fff; font-size:15px; width:100%; line-height:50px; border-radius:3px; border:none; }
	.login_input{width:100%; border:1px solid #3872f6; border-radius:3px; line-height:40px; padding:2px 5px 2px 30px; background:none;}
	.icon_font{position:absolute; bottom:15px; left:10px; font-size:18px; color:#3872f6;}
	.font16{font-size:16px;}
	.mg-t20{margin-top:20px;}
	@media (min-width:200px){.pd-xs-20{padding:20px;}}
	@media (min-width:768px){.pd-sm-50{padding:50px;}}
	#grad {
	  background: -webkit-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Safari 5.1 - 6.0 */
	  background: -o-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Opera 11.1 - 12.0 */
	  background: -moz-linear-gradient(#4990c1, #52a3d2, #6186a3); /* Firefox 3.6 - 15 */
	  background: linear-gradient(#4990c1, #52a3d2, #6186a3); /* 标准的语法 */
	}
body,td,th {
	font-size: 18px;
}
</style>


</head>

<body style="background:url(${pageContext.request.contextPath}/resources/images/bg.jpg) no-repeat;">
    
    <div class="container wrap1" style="height:450px;">
            <h2 class="mg-b20 text-center">登录页面</h2>
            <div class="col-sm-8 col-md-5 center-auto pd-sm-50 pd-xs-20 main_content">
                <p class="text-center font16">用户登录</p>
                <p style="color: red; font-weight: 900">${msg }</p>
                <form action="${pageContext.request.contextPath }/api/login/login" method="post" onsubmit="return checkerror()">
                    <div class="form-group mg-t20">
                        <i class="icon-user icon_font"></i>
                        <input type="text" class="login_input" id="Email1" placeholder="请输入用户名"  name="userName"/>
                    </div>
                    <div class="form-group mg-t20">
                        <i class="icon-lock icon_font"></i>
                        <input type="password" class="login_input" id="Password1" placeholder="请输入密码"  name="password"/>
                    </div>
                    <div class="checkbox mg-b25">
                        <label>
                        
                        验证码:<input type="text" name="image1"  size="7" style="color:red;"/>  <a href="javascript:void(0)" ><img id="imgid" src="${pageContext.request.contextPath }/front/user_check" width="130" height="40" onclick="changeImage()"></a>
                            
                        </label>
                    </div>
                    <button style="submit" class="login_btn">登 录</button>
               </form>
        </div><!--row end-->
    </div><!--container end-->
<div style="text-align:center;">

</div>  
   
</body>
<script type="text/javascript">
 function changeImage(){
   document.getElementById("imgid").src="${pageContext.request.contextPath }/front/user_check?time="+new Date().getTime();
}
function checkerror(){
 var x= document.getElementById("Email1").value;
 if(x.length==0||x==null){
    document.getElementById("Email1").placeholder="用户名不能为空";
    return false;
    }
   var x= document.getElementById("Password1").value;
  if(x.length==0||x==null){
    document.getElementById("Password1").placeholder="密码不能为空";
    return false;
    }     
   return true;
  

}
</script> 
</html>
