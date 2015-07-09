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
        <div id="PersonalInformationDiv" class="col-md-9">
		   <div class="page-header">
            <h3><strong>个人信息详情</strong></h3>
        </div>
        <form class="col-md-9">
            <fieldset class="form-horizontal">
                <legend>填写个人信息</legend>
                <div class="form-group">
                	<label for="head">用户头像：</label><br/>
                    <img style="-webkit-border-radius: 5px;margin-bottom: 10px;" src="./img/gongfu.jpg" width="120px" height="150px"/><br/> 
                    <input type="file" alt="文件损坏" accept="image/jpeg,image/gif" id="pic"/>
                </div>
                <div class="form-group">
                    <label for="name">姓名：</label>
                    <input type="text" id="name" value="李志伟" class="form-control" disabled="disabled"/>
                </div>
                <div class="form-group">
                    <label for="account">账号：</label>
                    <input type="text" id="account" value="10022" class="form-control" disabled="disabled"/>
                </div>
                <div class="form-group">
                    <label for="gender">性别：</label>
                    <div>
                        <label class="radio-inline">
                            <input id="male" name="gender" type="radio" value="1" checked="checked" disabled="disabled"/>男
                        </label>
                        <label class="radio-inline">
                            <input id="female" name="gender" type="radio" value="0" disabled="disabled"/>女
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="department">部门：</label>
                    <select id="department" class="form-control" disabled="disabled">
                        <option>销售部</option>
                        <option>网络部</option>
                        <option>企划部</option>
                        <option>生产部</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="password">密码：</label>
                    <input type="password" id="password" value="zhiwei1994" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="email">邮箱：</label>
                    <input type="text" id="email" value="23457891@126.com" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="tel">电话：</label>
                    <input type="text" id="tel" value="13838389797" class="form-control" />
                </div>
            </fieldset>
            <div class="text-center form-group">
                <button type="button" class="btn btn-primary" onclick="sure()">确定</button>
                <button type="button" class="btn btn-default" onclick="cancel()">取消</button>
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
<script src="js/profile.js"></script>
</html>