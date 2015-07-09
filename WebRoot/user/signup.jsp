<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="model.TbDepartment" %>
<%@page import="java.util.List" %>
<!--用户注册页面-->
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="/MRMS/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/MRMS/lib/system/css/left_menu.css" rel="stylesheet" />
    <link href="/MRMS/user/css/signup.css" rel="stylesheet" />
            <style type="text/css">
        	#poster{
        		width:450px;
        		height:450px;
        		margin: 50px 100px !important;
        		animation: 3s slide_in;
        	}
			@keyframes slide_in{
			    0%{opacity: 0}
			    50%{opacity: 0}
			    100%{opacity: 1}
			}
        </style>
</head>
<body>
<% 
	       HttpServletRequest request1=ServletActionContext.getRequest();
		   List departments=(List)request1.getSession().getAttribute("department");%>
<!-- 顶部导航栏开始 -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#nav">
                <span class="sr-only">Toggle</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand system_title" href="#">会议室管理系统</a>
        </div>
        <div class="collapse navbar-collapse navbar-right" id="nav">
            <ul class="nav navbar-nav">
                <li><a href="../index.jsp">登录</a></li>
                <li class="active"><a href="registerAction">注册</a></li>
            </ul>

        </div>
    </div>
</nav>
<!-- 顶部导航栏结束 -->
<div class="container wrap_content">
<img src="/MRMS/lib/images/meeting_room.png" id="poster" />
    <div id="register_box">
        <p id="register_title">注册</p>
        <div id="form_register">
            <form name="register_form"  id="register_form" action="userAction">
                <table>
                    <tbody>
                    <tr>
                        <td><label id="label_name" for="name">姓名</label></td>
                        <td><input class="input_text" id="name" name="name"  placeholder="输入你的用户名" type="text" /></td>
                    </tr>
                    <tr>
                        <td><label id="label_password" for="password">密码</label></td>
                        <td><input class="input_text" id="password" name="password" placeholder="输入密码" type="password" /></td>
                    </tr>
                    <tr>
                        <td><label id="label_ensure_password" for="ensure_password">确认密码</label></td>
                        <td><input class="input_text" id="ensure_password" name="ensure_password" placeholder="再次输入密码" type="password" /></td>
                    </tr>

                    <tr>
                        <td><label id="label_gender" for="gender">性别</label></td>
                        <td>
                            <select id="gender" name="gender">
                                <option>男</option>
                                <option>女</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label id="label_department" for="department">所在部门</label></td>
                        <td>
                            <select id="department" name="department">
                                <% for(int i=0;i<departments.size();i++) {
                                %>
                                <option> <%=((TbDepartment)departments.get(i)).getName()%></option>
                               
                               <%} %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label id="label_email" for="email">邮箱</label></td>
                        <td><input class="input_text" id="email" name="email" placeholder="输入邮箱地址" type="text" /></td>
                    </tr>
                    <tr>
                        <td><label id="label_tel" for="tel">手机</label></td>
                        <td><input class="input_text" id="tel" name="tel" placeholder="输入手机号" type="text" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input id="button_submit" name="button_submit"  type="button" value="注册" onclick="check()"/></td>
                    </tr>
                    <tr align="right">
                        <td colspan="2">
                            <p id="login_redirect">已有账号？
                                <span id="login_link" onclick="document.location.href='../index.jsp'">点我登录</span>
                            </p>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
<div class="container text-center">
    <hr />
    北京工业大学&bull;<span class="team_name">平乐园中央陆军</span>开发小组
    <br />
    <br />
</div>
</body>
<script src="/MRMS/lib/scripts/jquery-1.11.0.min.js"></script>
<script src="/MRMS/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="/MRMS/lib/scripts/bootbox.min.js"></script>
<script>
function check(){
	var name=document.getElementById("name").value;
	var password=document.getElementById("password").value;
	var ensurepassword=document.getElementById("ensure_password").value;
	var gender=document.getElementById("gender").value;
	var department=document.getElementById("department").value;
	var email=document.getElementById("email").value;
	var tel=document.getElementById("tel").value;
	var data={username:name,userpassword:password,userensurepassword:ensurepassword,usergender:gender,useremail:email,usertel:tel,userdepartment:department};
	$.post("registercheckAction",data,function(result){
		if(result=="1"){
		alert("注册信息不能为空！");	
		}
		if(result=="2"){
			alert("两次输入密码不同！");	
			}
		if(result=="3"){
			alert("已注册，等待审核！");	
			$("#register_form").submit();
		}
	});
}
</script>
</html>