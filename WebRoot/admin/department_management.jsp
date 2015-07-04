<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../lib/system/css/left_menu.css" rel="stylesheet" />
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
					<a class="list-group-item" href="../admin/meeting_apply_check.jsp">
						会议审查<span class="badge">10</span>
					</a>
					<a class="list-group-item active" href="../admin/department_management.jsp">
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
        <div class="col-md-9" style="margin-top: -25px;">
				<div class="page-header">
					<div>
						<h3><strong>部门管理</strong></h3>
					</div>
				</div>

				<!-- 搜索表单开始 -->
				<div>
					<form>
						<div class="form-inline  ">
							
							<div class="form-group" style="margin-left: 3px;">
								<input type="text" placeholder="部门编号" class="form-control" />
							</div>
							
							<div class="form-group" style="margin-left: 4px;">
								<input type="text" placeholder="部门人数" class="form-control" />
							</div>
							<div class="form-group" style="margin-left: 4px;">
								<input type="text" placeholder="成员" class="form-control" />
							</div>
							<div class="form-group" style="margin-left: 4px;">
								<select class="form-control">
									<option value="">不限部门</option>
									<option value="1">技术部</option>
									<option value="2">销售部</option>
									<option value="3">市场部</option>
									<option value="4">行政部</option>
								</select>
							</div>
							<div class="form-group" style="margin-left: 22px;">
								<button type="submit" class="btn btn-info">查询</button>
							</div>
						</div>
					</form>
				</div>
				<!-- 搜索表单结束 -->

				<div>
					<table class="table table-striped table-bordered text-center">
						<caption>
							<h4><strong>查询结果</strong></h4>
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
										<a href="./department_management_add.jsp" class="btn btn-success btn-sm">添加部门</a>
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
							<tr>
								<td>10001</td>
								<td>技术部</td>
								<td>34</td>
								<td>马云等</td>
								<td>
									<a href="./department_management_edit.jsp" class="btn btn-primary btn-sm">编辑</a>
									<a href="#" class="btn btn btn-danger btn-sm col-md-offset-1" onclick="deleteConfirm();">删除</a>
								</td>
							</tr>
							<tr>
								<td>10002</td>
								<td>销售部</td>
								<td>23</td>
								<td>周可儿等</td>
								<td>
									<a href="./department_management_edit.jsp" class="btn btn-primary btn-sm">编辑</a>
									<a href="#" class="btn btn btn-danger btn-sm col-md-offset-1" onclick="deleteConfirm();">删除</a>
								</td>
							</tr>
							<tr>
								<td>10003</td>
								<td>市场部</td>
								<td>3</td>
								<td>洪鑫等</td>
								<td>
									<a href="./department_management_edit.jsp" class="btn btn-primary btn-sm">编辑</a>
									<a href="#" class="btn btn-danger btn-sm col-md-offset-1" onclick="deleteConfirm();">删除</a>
								</td>
							</tr>
							<tr>
								<td>10004</td>
								<td>行政部</td>
								<td>3</td>
								<td>比利海灵顿等</td>
								<td>
									<a href="./department_management_edit.jsp" class="btn btn-primary btn-sm">编辑</a>
									<a href="#" class="btn btn-danger btn-sm col-md-offset-1" onclick="deleteConfirm();">删除</a>
								</td>
							</tr>
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
</html>