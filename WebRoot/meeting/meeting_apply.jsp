﻿<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    	<link href="../lib/system/css/left_menu.css" rel="stylesheet" />
    	<link href="css/meeting_apply.css" rel="stylesheet" />
		<title>会议预约</title>
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
                        <a class="list-group-item active" href="../meeting/meeting_apply.jsp">
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
        <div id="content_panel" class="col-md-9">
			<div class="page-header">
				<h3><strong>会议申请</strong></h3>
			</div>
			<form class="col-md-8">
            <fieldset id="content_fieldset">
                <legend>填写申请信息</legend>
                <div class="form-group">
                    <label for="name">会议名称</label>
                    <input type="text" id="name" placeholder="会议名称" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="birthday">预期会议日期</label>
                    <input type="date" id="birthday" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="homeland">会议时长</label>
                    <input type="text" id="name" placeholder="必填，时间单位:分钟" class="form-control" />
                </div>
                <div class="form-group">
                    <label>会议简介</label>
                    <input type="text" id="name" placeholder="必填，不少于50字" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="gender">参会人员</label>
                    <div>
                        <label class="radio-inline">
                            <input id="female" name="gender" type="checkbox" value="0" />山涛
                        </label>
                        <label class="radio-inline">
                            <input id="male" name="gender" type="checkbox" value="1" checked="checked" />李志伟
                        </label>
                        <label class="radio-inline">
                            <input id="female" name="gender" type="checkbox" value="2" />洪鑫
                        </label>
                        <label class="radio-inline">
                            <input id="female" name="gender" type="checkbox" value="3" />邓旺华
                        </label>
                        <label class="radio-inline">
                            <input id="female" name="gender" type="checkbox" value="4" />吕成
                        </label>
                    </div>
                </div>
            </fieldset>
            <div id="button_panel" class="text-center form-group">
                <button type="button" class="btn btn-primary">申请</button>
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
</html>
