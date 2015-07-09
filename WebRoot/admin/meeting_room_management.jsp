<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
					<a class="list-group-item" href='../user/shownoticeAction'>
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
					<a class="list-group-item active" href="showMeetingRoomAction">
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
						<h3><strong>会议室管理</strong></h3>
					</div>
				</div>


				<div>
					<table class="table table-striped table-bordered text-center">
						<caption>
							<h4><strong>会议室信息</strong></h4>
							<ul class="pagination pagination-sm col-md-12">
								<li class="pull-right">

									<div>
										<a href="/MRMS/admin/meeting_room_management_add.jsp" class="btn btn-success btn-sm">添加会议室</a>
									</div>
								</li>
							</ul>

						</caption>

						<thead>
							<tr>
								<th class="text-center">id</th>
								<th class="text-center">门牌号</th>
								<th class="text-center">容纳人数</th>
								<th class="text-center">状态</th>
								<th class="text-center">具体信息</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>

						<tbody>
						<s:iterator value="meetings">
							<tr>
								<td class="id"><s:property value="id"/></td>
								<td class="door_num"><s:property value="doorNumber"/></td>
								<td class="person_limit"><s:property value="personLimit"/></td>
								<td><s:property value="tbMeetingRoomState.name"/></td>
								<td>
									<a href="/MRMS/meetingRoom/meetingRoomDetailAction?room_id=<s:property value="id"/>" class="btn btn-link">点击查看具体信息</a>
								</td>
								<td >
								<a  class="btn btn-primary btn-sm" onclick="get_current_id(this)">编辑</a>
									<a  class="btn btn btn-danger btn-sm col-md-offset-1" onclick="deletemeeting(this)">删除</a>
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
function get_current_id(t)
{
	var current_id=$(t).parent().siblings(".id").first().text();
	var door_num=$(t).parent().siblings(".door_num").first().text();
	var person_limit=$(t).parent().siblings(".person_limit").first().text();
	window.location.href="./ModifyAction?current_id="+current_id+"&door_num="+door_num+"&person_limit="+person_limit;
}
function deletemeeting(t)
{
    alert("确定删除？");
    var del_id=$(t).parent().siblings(".id").first().text();
	window.location.href="./DeleteMeetingRoomAction?del_id="+del_id;
}
</script>
</html>