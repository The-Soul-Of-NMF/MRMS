<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>
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
                    <a class="list-group-item active" href="../meeting/meeting_room_pick.jsp">
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


    <div class="col-md-9 main_content">
        <div class="page-header">
            <h3><strong>会议室选择</strong></h3>
        </div>

        <form id="meeting_time_choose" class="col-md-12" action="/MRMS/meeting/meetingRoomChooseAction" method="post">
            <fieldset class="form-horizontal">
                <legend>选择一个最理想的会议开始时间</legend>
                <div class="form-group">
                    <label for="meeting_num" class="col-md-3 control-label">会议编号：</label>
                    <div class="col-md-8">
                        <input disabled="disabled" type="text" id="meeting_num" value='<s:property value="meeting.id"/>'"  class="form-control" />
                        <input name="id" type="hidden" id="meeting_num" value="<s:property value='meeting.id'/>"  class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="meeting_name" class="col-md-3 control-label">会议名称：</label>
                    <div class="col-md-8">
                        <input disabled="disabled" id="meeting_name" value='<s:property value="meeting.title"/>'" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-md-3 control-label">开始日期：</label>
                    <div class="col-md-8">
                        <input disabled="disabled" type="date" id="start_date" value="<s:date name='meeting.date' format='yyyy-MM-dd' />" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-md-3 control-label">会议时长：</label>
                    <div class="col-md-8">
                        <input disabled="disabled" type="text" id="duration" value='<s:property value="meeting.duringTime"/>min'" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="start_time" class="col-md-3 control-label">开始时间：</label>
                    <div class="col-md-8">
                        <input name="time" type="time" id="start_time" class="form-control" value="08:00"/>
                    </div>
                </div>
            </fieldset>
            <div class="text-center form-group">
                <a class="btn btn-primary" id="time_choose_ok_btn">确定</a>
                <a href="/MRMS/meeting/meetingForRoomAction" class="btn btn-primary col-md-offset-1 back_to_list_btn">返回</a>
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
<script src="/MRMS/meeting/js/pick.js"></script>
<script>
	$(function(){
		$("#time_choose_ok_btn").click(function(){
			$("#meeting_time_choose")[0].submit();
		})
	});

</script>
</html>