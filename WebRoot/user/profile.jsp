<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html;charset=utf-8"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="model.TbUser"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../lib/system/css/left_menu.css" rel="stylesheet" />
</head>
<body>
<% 
	 HttpServletRequest request1=ServletActionContext.getRequest();
		   String limit=(String) request1.getSession().getAttribute("limit");
		   TbUser user=(TbUser) request1.getSession().getAttribute("user");%>
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
                <!--<li class="active"><a href="#">登录</a></li>-->
                <!--<li><a href="#">注册</a></li>-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img height="20" class="dropdown-image" src="../lib/system/img/silverHugh.jpg">
                        <%=user.getName() %>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href='./userinformationAction'>修改个人信息</a></li>
                        <li><a href="../deletesessionAction">注销</a></li>
                    </ul>
                </li>
            </ul>

        </div>
    </div>
</nav>
<!-- 顶部导航栏结束 -->
<div class="container wrap_content">
    <div class="col-md-3 left_menu">
        <div class="panel-group" id="accordion">
            <div class="panel-body">
                <div class="list-group" style="margin:0">
                     <a class="list-group-item" href='../meeting/meetingApplyPrepare'>
                        会议申请
                    </a>
                    <a class="list-group-item" href="/MRMS/meeting/meetingForRoomAction">
                        会议室选择
                    </a>
                   <a class="list-group-item" href="../user/shownoticeAction">
                        通知<span class="badge">20</span>
                    </a>
                    <a class="list-group-item" href='../meeting/meetingInforAction'>
                        会议信息
                    </a>
                    <a class="list-group-item" href='../user/userinformationAction'>
                        个人信息
                    </a>

                </div>
            </div>

        <% 
		  if(Integer.parseInt(limit)>1){
		 %>
            <div class="panel-body">
                <div class="list-group" style="margin:0">
                    <a class="list-group-item"  href='../user/usercheckAction'>
                        用户注册审查<span class="badge">20</span>
                    </a>
                    <a class="list-group-item" href='../meeting/showWaitMeetingAction'>
                        会议审查<span class="badge">10</span>
                    </a>
                    <a class="list-group-item" href="../department/deparManaAction_show">
                        部门信息管理
                    </a>
                    <a class="list-group-item" href="/MRMS/meetingRoom/showMeetingRoomAction">
                        会议室信息管理
                    </a>
                    <a class="list-group-item" href="../user/usermanageAction">
                        用户信息管理
                    </a>
                </div>
            </div><%}  if(Integer.parseInt(limit)>2){%>


            <div class="panel-body">
                <div class="list-group" style="margin:0">
                    <a class="list-group-item" href="../admin/right_change.jsp">
                        权限管理
                    </a>
                </div>
            </div><%} %>

        </div>
    </div>
    <!-- 左侧可伸缩菜单栏结束 -->
        <div id="PersonalInformationDiv" class="col-md-9">
		   <div class="page-header">
            <h3><strong>个人信息详情</strong></h3>
        </div>
        <form class="col-md-9">
            <fieldset class="form-horizontal">
                <legend>填写个人信息</legend>
                <div class="form-group">
                	<label for="head">用户头像：</label><br/>
                    <img style="-webkit-border-radius: 5px;margin-bottom: 10px;" src="./img/gongfu.jpg" width="120px" height="150px" id="image"/><br/> 
                    <input type="file" alt="文件损坏" accept="image/jpeg,image/gif,image/png" id="pic"/>
                </div>
                <div class="form-group">
                    <label for="name">姓名：</label>
                    <input type="text" id="name" value=<s:property value="user.name"/> class="form-control" disabled="disabled"/>
                </div>
                <div class="form-group">
                    <label for="account">账号：</label>
                    <input type="text" id="account" value= <s:property value="user.id"/> class="form-control" disabled="disabled"/>
                </div>
                <div class="form-group">
                    <label for="gender">性别：</label>
                    <div>
                        <label class="radio-inline">
                            
                            <input id="male" name="gender" type="radio" value="1" checked="checked" disabled="disabled"/>
                            <s:set name="gd" value="%{user.gender}"/>
                            <s:if test="#gd==true">男</s:if>
                            <s:else>女</s:else>
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="department">部门：</label>
                    <select id="department" class="form-control" disabled="disabled">
                        <option selected="selected"><s:property value="user.tbDepartment.name"/></option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="password">密码：</label>
                    <input type="password" id="password" value=<s:property value="user.password"/> class="form-control" />
                </div>
                <div class="form-group">
                    <label for="email">邮箱：</label>
                    <input type="text" id="email" value=<s:property value="user.email"/> class="form-control" />
                </div>
                <div class="form-group">
                    <label for="tel">电话：</label>
                    <input type="text" id="tel" value=<s:property value="user.phone"/> class="form-control" />
                </div>
            </fieldset>
            <div class="text-center form-group">
                <button type="button" class="btn btn-primary" onclick="sure()">确定</button>
                <button type="button" class="btn btn-default" onclick="cancel()">取消</button>
            </div>
        </form>
		</div>
    </div>
    <div class="container text-center">
        <hr />
        北京工业大学&bull;<span class="team_name">平乐园中央陆军</span>开发小组
        <br />
        <br />
    </div>
</body>
<script src="../lib/scripts/jquery-1.11.0.min.js"></script>
<script src="../lib/bootstrap/js/bootstrap.min.js"></script>
<script src="../lib/scripts/bootbox.min.js"></script>
<script src="js/profile.js"></script>
<script>
function cancel(){
	window.location.href="backwelcomeAction";
}
function sure(){
	var password=document.getElementById("password").value;
	var email=document.getElementById("email").value;
	var tel=document.getElementById("tel").value;
	var account=document.getElementById("account").value;
	var pic=document.getElementById("pic").value;
	var data={userpassword:password,useremail:email,usertel:tel,useraccount:account,userpic:pic};
	$.post("updateuserAction",data,function(result){
		alert("修改成功！");
		window.location.ref="userinformationAction";
	});
}
</script>
</html>