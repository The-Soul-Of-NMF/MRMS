<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>

<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="model.TbUser"%>

<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../lib/system/css/left_menu.css" rel="stylesheet" />
    <link href="css/department_management.css" rel="stylesheet" />
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
					<a class="list-group-item" href="../meeting/meeting_apply.jsp">
						会议申请
					</a>
					<a class="list-group-item" href="../meeting/meeting_room_pick.jsp">
						会议室选择
					</a>
					<a class="list-group-item" href="../user/notice.jsp">
						通知<span class="badge">20</span>
					</a>
					<a class="list-group-item" href="../meeting/meeting_info_list.jsp">
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
					<a class="list-group-item" href="../admin/meeting_apply_check.jsp">
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
        <div class="col-md-9" style="margin-top: 15px;">
				
				<!-- 搜索表单开始 -->
				<ul class="nav nav-tabs">
            		<li class="active"><a href="#tab1" data-toggle="tab">部门编号</a></li>
            		<li><a href="#tab2" data-toggle="tab">部门人数</a></li>
            		<li><a href="#tab3" data-toggle="tab">部门成员</a></li>
        		</ul>
        		<div class="tab-content">
            		<div class="tab-pane active" id="tab1">
			    		<div class="page-header">
							<h3><strong>输入部门编号</strong></h3>
						</div>
						<form action="../department/deparManaAction_query_by_id">
							<div class="form-inline  ">
								<div class="form-group" style="margin-left: 3px;">
									<input type="text" name="depar_id" placeholder="部门编号" class="form-control" />
								</div>
							</div>
							<div class="form-group" style="margin-left: 22px;">
								<button type="submit" class="btn btn-info">查询</button>
							</div>
						</form>
					</div>
					<div class="tab-pane" id="tab2">
			    		<div class="page-header">
							<h3><strong>输入部门人数范围</strong></h3>
						</div>
						<form action="../department/deparManaAction_query_by_num">
							<div class="form-inline  ">
								<div class="form-group" style="margin-left: 4px;">
									<input type="text" name="left_num" placeholder="人数" class="form-control" />至
									<input type="text" name="right_num" placeholder="人数" class="form-control" />
								</div>
							</div>
							<div class="form-group" style="margin-left: 22px;">
								<button type="submit" class="btn btn-info">查询</button>
							</div>
						</form>
					</div>
					<div class="tab-pane" id="tab3">
			    		<div class="page-header">
							<h3><strong>输入部门成员姓名</strong></h3>
						</div>
						<form action="../department/deparManaAction_query_by_member">
							<div class="form-inline  ">
								<div class="form-group" style="margin-left: 4px;">
									<input type="text" name="depar_member" placeholder="成员" class="form-control" />
								</div>
							</div>
							<div class="form-group" style="margin-left: 22px;">
								<button type="submit" class="btn btn-info">查询</button>
							</div>
						</form>
					</div>
				</div>
				<!-- 搜索表单结束 -->

				<div>
					<table class="table table-striped table-bordered text-center">
						<caption>
							<h4><strong>部门信息</strong></h4>
							<ul class="pagination pagination-sm col-md-12">
								<li title="第一页"><a href="#">&laquo;</a>
								</li>
								<li title="上一页"><a href="#">&lsaquo;</a>
								</li>
								<li title="当前页" class="active"><a href="#">1</a>
								</li>
								<li title="下一页"><a href="#">&rsaquo;</a>
								</li>
								<li title="最末页"><a href="#">&raquo;</a>
								</li>
								<li>
									<a href="">共<strong>1</strong>条记录，<strong>1</strong>页</a>
								</li>
								<li class="pull-right">

									<div>
										<a href="../admin/department_management_add.jsp" class="btn btn-success btn-sm">添加部门</a>
									</div>
								</li>
							</ul>

						</caption>
						<thead>
							<tr>
								<th class="text-center">编号</th>
								<th class="text-center">部门</th>
								<th class="text-center">成员人数</th>
								<th class="text-center">成员列表</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
					
						
							<s:iterator value="all_depar">
								<tr>
									<td class="depar_id"><s:property value="id"/></td>
									<td><s:property value="name"/></td>
									<td><s:property value="totalNumber"/></td>
									<td>
										<s:iterator value="tbUsers">
         									<s:property value="name" />,
										</s:iterator>
									</td>
									<td>
										<a class="btn btn-primary btn-sm" onclick= "get_current_id(this)" >编辑</a>
										<a class="btn btn btn-danger btn-sm col-md-offset-1" onclick="deleteConfirm(this)" >删除</a>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>

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
<script src="../lib/scripts/jquery-1.11.0.min.js"></script>
<script src="../lib/bootstrap/js/bootstrap.min.js"></script>
<script src="../lib/scripts/bootbox.min.js"></script>
<script>
	function get_current_id(t){
		var current_id=$(t).parent().siblings(".depar_id").first().text();
		window.location.href="../department/deparManaAction_current_id?current_id="+current_id
	}
	function deleteConfirm(t){
		var current_id=$(t).parent().siblings(".depar_id").first().text();
		if(confirm("确定删除么?")){
			var data={current_id:current_id}
			$.post("../department/deparManaAction_check_delete",data,function(result){
				if(result=="-1"){
					alert("当前部门中还有员工，不能被删除!")
				}else if(result=="1"){
					window.location.href="../department/deparManaAction_delete?"+
							"current_id="+current_id
				}
			})
			
		}
	}
</script>
</html>