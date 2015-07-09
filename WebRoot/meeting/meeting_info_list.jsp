<%@page import="org.apache.struts2.ServletActionContext"%>
<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="model.TbUser" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>会议列表</title>
    <link href="/MRMS/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/MRMS/lib/system/css/left_menu.css" rel="stylesheet" />
	 <link href="/MRMS/meeting/css/meeting_info_list.css" rel="stylesheet" />
</head>
<body>
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
                        SilverHugh
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="../user/profile.jsp">修改个人信息</a></li>
                        <li><a href="../index.jsp">注销</a></li>
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
                    <a class="list-group-item" href="../user/profile.jsp">
                        个人信息
                    </a>

                </div>
            </div>


            <div class="panel-body">
                <div class="list-group" style="margin:0">
                    <a class="list-group-item" href="../admin/signup_check.jsp">
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
                    <a class="list-group-item" href="../admin/user_management.jsp">
                        用户信息管理
                    </a>
                </div>
            </div>


            <div class="panel-body">
                <div class="list-group" style="margin:0">
                    <a class="list-group-item" href="../admin/right_change.jsp">
                        权限管理
                    </a>
                </div>
            </div>

        </div>
    </div>
    <!-- 左侧可伸缩菜单栏结束 -->
		  <div class="col-md-9" style="margin-top:-25px">
        <div class="page-header">
            <h3><strong>会议信息列表</strong></h3>
        </div>
        <table class="table table-striped table-bordered">
            <caption>
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
                <%String ss=((TbUser)session.getAttribute("user")).getName();
            		HttpServletRequest request2=ServletActionContext.getRequest();
            	%>
                <div style="float:right;padding:5px">
					<select id="state" name="state" class="form-control" onchange="selectstate()">
					    <option <s:if test="select==0">selected</s:if> value="0" >全部会议</option>
						<option <s:if test="select==1">selected</s:if> value="1">待审核</option>
						<option <s:if test="select==2">selected</s:if> value="2">待申请会议室</option>
						<option <s:if test="select==3">selected</s:if> value="3">等待开始</option>
						<option <s:if test="select==4">selected</s:if> value="4">审核未通过</option>
						<option <s:if test="select==5">selected</s:if> value="5">已举行</option>
						<option <s:if test="select==6">selected</s:if> value="6">会议中</option>
					</select>
                </div>
            </caption>
            <thead>
                <tr>
                    <th>编号</th>
                    <th>会议名称</th>
                    <th>会议发起人</th>
                    <th>会议起止时间</th>
                    <th>会议状态</th>
					<th>是否本人拥有</th>
                </tr>
            </thead>
            <tbody id="meetingtable">
            	<input id="select_info" type="hidden" value="" />
            	<s:iterator value="meetinglist">
					<tr>
            			<td><s:property value="id"/></td>
            			<td><a href="meetingDetailAction?meetingId=<s:property value="id"/>"><s:property value="title"/></a></td>
            			<td><s:property value="tbUser.name"/></td>
            			<td><s:date name="date" format="yyyy/MM/dd"/></td>
            			<td><s:property value="tbMeetingState.name"/></td>
            			<td>
            			<s:set name="usert" value="tbUser.name"></s:set>
            				<%
            				String ss2=request2.getAttribute("usert").toString();
            				if(ss.equals(ss2)){
            				%>
            				<img src="/MRMS/meeting/img/check.png" id="check_size"/>
            				<%}%>
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
<script src="/MRMS/meeting/js/meeting_info_list.js"></script>
</html>