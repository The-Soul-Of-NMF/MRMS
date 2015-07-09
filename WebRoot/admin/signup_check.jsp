<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="model.TbUser"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="/MRMS/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/MRMS/lib/system/css/left_menu.css" rel="stylesheet" />
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

                    <a class="list-group-item active" href='../user/usercheckAction'>
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
        <div class="col-md-9" style="margin-top: -25px;">
        <div class="page-header">
            <h3><strong>用户申请管理</strong></h3>
        </div>
        <table class="table table-striped table-bordered text-center">
            <caption>
                <h4><strong>所有用户申请</strong></h4>
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
                    <th class="text-center">账号</th>
                    <th class="text-center">姓名</th>
                    <th class="text-center">性别</th>
                    <th class="text-center">所属部门</th>
                    <th class="text-center">操作</th>
                </tr>
            </thead>
            <s:iterator value="tbuserapplication">
            <tbody>
                <tr>
                    <td class="id"><s:property value="id"/></td>
                    <td><s:property value="name"/></td>
                    <td>
                    <s:set name="gd" value="%{gender}"></s:set>
                    <s:if test="#gd==true">男</s:if>
                    <s:else>女</s:else>
                    </td>
                    <td><s:property value=" tbDepartment.name"/></td>
                    <td >
                        <a class="btn btn-primary btn-sm" onclick="Agree(this)">同意</a>
                        <a class="btn btn-danger btn-sm col-md-offset-1" onclick="Disagree(this)">不同意</a>
                    </td>
                </tr>
            </tbody>
             </s:iterator>
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
<script src="js/signup_check.js"></script>
<script>
function Agree(button){
	var id=$(button).parent().siblings(".id").first().text();
	var data={userid:id};
	$.post("usercheckActionOne",data,function(result){
		alert("处理成功！");
		window.location.href = "usercheckAction";
	});
	
}
function Disagree(button){
	var id=$(button).parent().siblings(".id").first().text();
	var data={userid:id};
	$.post("usercheckActionTwo",data,function(result){
		alert("处理成功！");
		window.location.href = "usercheckAction";
	});
	
	
}
</script>
</html>