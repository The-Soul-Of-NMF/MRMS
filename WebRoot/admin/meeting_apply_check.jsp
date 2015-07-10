<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="model.TbUser"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!--会议室选择页面-->
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="/MRMS/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/MRMS/lib/system/css/left_menu.css" rel="stylesheet" />
    <link href="/MRMS/meeting/css/pick.css" rel="stylesheet"/>
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
        <div class="col-md-9" style="margin-top: -25px;">
        <div class="page-header">
            <h3><strong>会议审查</strong></h3>
        </div>
        <table class="table table-striped table-bordered text-center">
            <caption>
                <h4><strong>所有会议申请</strong></h4>
                <ul class="pagination pagination-sm" style="float:left;">
                    <li title="第一页"><a href="#">&laquo;</a></li>
                    <li title="上一页"><a href="#">&lsaquo;</a></li>
                    <li title="当前页" class="active"><a href="#">3</a></li>
                    <li title="下一页"><a href="#">&rsaquo;</a></li>
                    <li title="最末页"><a href="#">&raquo;</a></li>
                    <li>
                        <a href="">共<strong>98</strong>条记录，<strong>10</strong>页</a>
                    </li>
                </ul>
            </caption>
            <thead>
                <tr>
                    <th class="text-center">会议编号</th>
                    <th class="text-center">主题</th>
                    <th class="text-center">发起者</th>
                    <th class="text-center">参与人数</th>
                    <th class="text-center">申请会议日期</th>
                    <th class="text-center">操作</th>
                </tr>
            </thead>
            <tbody id="wait">
            	<s:iterator value="waitMeetings">
            	<tr>
            		
            		<td><s:property value="id"/></td>
            		<td><a href="meetingDetailAction?meetingId=<s:property value="id"/>"><s:property value="title"/></a></td>
            		<td><s:property value="tbUser.name"/></td>
            		<td><s:property value="totalNumber"/></td>
            		<td><s:date name="date" format="yyyy/MM/dd"/></td>
            		<td>
                        <a href='meetingApplyCheckAction!execute?setMeetingId=<s:property value="id"/>&&setop=0' class="btn btn-primary btn-sm" onclick="return Agree()">同意</a>
                        <a href='meetingApplyCheckAction!execute?setMeetingId=<s:property value="id"/>&&setop=1' class="btn btn-danger btn-sm col-md-offset-1" onclick="return Disagree();">不同意</a>
                    </td>
            	</tr>
            	</s:iterator>
            </tbody>
        </table>
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
<script src="/MRMS/admin/js/meeting_apply_check.js"></script>
</html>