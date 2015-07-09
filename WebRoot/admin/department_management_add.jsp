<%@ page language="java" pageEncoding="UTF-8"%>  
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
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img height="20" class="dropdown-image" src="../lib/system/img/silverHugh.jpg">
                          <%=user.getName() %>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href='../user/userinformationAction'>修改个人信息</a></li>
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
                    <a class="list-group-item" href="'meeting/meetingApplyPrepare'">
                        会议申请
                    </a>
                    <a class="list-group-item" href="../meeting/meeting_room_pick.jsp">
                        会议室选择
                    </a>
                    <a class="list-group-item" href="../user/notice.jsp">
                        通知<span class="badge">20</span>
                    </a>
                    <a class="list-group-item" href="'meetingInforAction'">
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
                    <a class="list-group-item" href='../user/usercheckAction'>
                        用户注册审查<span class="badge">20</span>
                    </a>
                    <a class="list-group-item" href="'meeting/showWaitMeetingAction'">
                        会议审查<span class="badge">10</span>
                    </a>
                    <a class="list-group-item active" href="../department/deparManaAction_show">
                        部门信息管理
                    </a>
                    <a class="list-group-item" href="../admin/meeting_room_management.jsp">
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
        <div class="col-md-9" style="margin-top: -25px;">
        <div class="page-header">
            <h3><strong>添加部门</strong></h3>
        </div>
        <form id="depar_name" action="../department/deparManaAction_add" class="col-md-8">
            <fieldset class="form-horizontal">
                <legend>填写部门名称</legend>
                <div class="form-group">
                    <label for="name" class="col-md-3 control-label">部门名称：</label>
                    <div class="col-md-8">
                        <input type="text" id="name" name="name" placeholder="名称" class="form-control" />
                    </div>
                </div>
            </fieldset>
            <div class="text-center form-group" style="margin-left:90px;">
                <button type="button" class="btn btn-success"
                	onclick="modify_depar()" >确定</button>
                <button type="button" class="btn btn-default"
                	onclick="window.location.href='../department/deparManaAction_show'" >取消</button>
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
<script>
	function modify_depar(){
		$("#depar_name").submit();
	}
</script>
</html>