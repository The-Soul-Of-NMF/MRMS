<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>

<%@ taglib uri="/struts-tags" prefix="s" %>

<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="model.TbUser"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<link href="/MRMS/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
   		<link href="/MRMS/lib/system/css/left_menu.css" rel="stylesheet" />
    	<link href="/MRMS/meeting/css/meeting_apply.css" rel="stylesheet" />
		<title>会议预约</title>
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
                         <a class="list-group-item" href='../meeting/meetingApplyPrepare'>
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

                        <a class="list-group-item" href="../admin/department_management.jsp">
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
        <div id="content_panel" class="col-md-9">
			<div class="page-header">
				<h3><strong>会议申请</strong></h3>
			</div>
			<form name="meetinginfor" class="col-md-8" action=".。/meeting/meetingApplyAction" method="post">
            <fieldset id="content_fieldset">
                <legend>填写申请信息</legend>
                <div class="form-group">
                    <label for="name">会议名称</label>
                    <input type="text" id="name" placeholder="会议名称" class="form-control" name="name"/>
                </div>
                <div class="form-group">
                    <label for="date">预期会议日期</label>
                    <input type="date" id="date" class="form-control" name="date"/>
                </div>
                <div class="form-group">
                    <label for="time">会议时长</label>
                    <input type="text" id="time" placeholder="必填，时间单位:分钟" class="form-control" name="time"/>
                </div>
                <div class="form-group">
                    <label>会议简介</label>
                    <input type="text" id="introduce" placeholder="会议简介。。。" class="form-control" name="introduce"/>
                </div>
                <div class="form-group">
                    <label for="invited">参会人员</label>
                    <div  id="invited">
                  		<s:iterator value="allUser">
                  			<label class="radio-inline">
                  				<input name="invited" type="checkbox" value="<s:property value="id"/>"/><s:property value="name"/>
                  			</label>
                  		</s:iterator>
                    </div>
                </div>
            </fieldset>
            <div id="button_panel" class="text-center form-group">
                <button type="button" class="btn btn-primary" onclick="checkinfor()">申请</button>
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
	<script src="/MRMS/lib/scripts/jquery-1.11.0.min.js"></script>
	<script src="/MRMS/lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="/MRMS/lib/scripts/bootbox.min.js"></script>
	<script src="/MRMS/meeting/js/meeting_apply.js"></script>
</html>
