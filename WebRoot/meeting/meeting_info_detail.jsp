<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>

<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="model.TbUser"%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>会议详情</title>
    <link href="/MRMS/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/MRMS/lib/system/css/left_menu.css" rel="stylesheet" />
	<link href="/MRMS/meeting/css/meeting_info_detail.css" rel="stylesheet" />
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
		<div class="col-md-9" style="margin-top:-25px">
		<div class="page-header">
            <h3><strong>会议详情</strong></h3>
        </div>
        <form class="col-md-8">
                <div class="form-group">
                    <label>会议编号:</label>
                    <input type="text" id="number" class="form-control" disabled="disabled" value="<s:property value="meeting.id"/>"/>
                </div>
               <div class="form-group">
                    <label>会议名称:</label>
                    <input type="text" id="meetingname"  class="form-control" disabled="disabled" value="<s:property value="meeting.title"/>" />
                </div>
                <div class="form-group">
                    <label>会议发起者:</label>
                    <input type="text" id="name"  class="form-control" disabled="disabled" value="<s:property value="meeting.tbUser.name"/>" />
                </div>
                 <div class="form-group">
                    <label>会议状态:</label>
                    <input type="text" id="state"  class="form-control" disabled="disabled" value="<s:property value="meeting.tbMeetingState.name"/>" />
                </div>
                <div class="form-group">
                    <label>会议起止时间:</label></br>
                    <input type="text" id="time1" class="form-control" disabled="disabled" value="<s:date name="meeting.startTime" format="HH:mm"/>"/>
					<p id="p">——</p>
				    <input type="text" id="time2" class="form-control" disabled="disabled" value="<s:date name="meeting.startTime" format="HH:mm"/>"/>
                </div>
				 <div class="form-group">
                    <label>会议简介:</label>
                    <textarea id="description" rows="3"  class="form-control" disabled="disabled"><s:property value="meeting.description"/></textarea>
                </div>
				 <div class="form-group">
                    <label>会议成员:</label>
                    <input type="text" id="member" class="form-control" disabled="disabled" value='<s:iterator value="meetingInvited">#<s:property value="name"/></s:iterator>'/>
                </div>
				
				<fieldset>
				 <legend>会议文件</legend>
				<p>会议内容.PPT</p>
				<p>会议内容.doc</p>
				</fieldset>
				<div class="text-center form-group">
				<div class="form-group">
                    <input type="file" id="upload" class="form-control" value="信息"/>
                </div>
         
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
</html>