<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>
<!--会议室选择页面-->
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../lib/system/css/left_menu.css" rel="stylesheet" />
    <link href="./css/pick.css" rel="stylesheet"/>
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


    <div class="col-md-9 main_content">
        <div class="page-header">
            <h3><strong>会议室选择</strong></h3>
        </div>

        <form id="meeting_list" class="col-md-12">
            <fieldset class="form-horizontal">
                <legend>您可以为以下会议选择会议室</legend>
                <table class="table table-striped table-bordered text-center">
                    <thead>
                    <tr>
                        <th class="text-center">编号</th>
                        <th class="text-center">会议编号</th>
                        <th class="text-center">会议名称</th>
                        <th class="text-center">预期日期</th>
                        <th class="text-center"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr id="meeting_one">
                        <td>1</td>
                        <td>M10001</td>
                        <td>人事部例会</td>
                        <td>2015-06-27</td>
                        <td><a class="btn btn-primary btn-sm" id="meeting_room_choose_btn">选择会议室</a></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>M10023</td>
                        <td>项目研讨会</td>
                        <td>2015-06-28</td>
                        <td><a class="btn btn-primary btn-sm">选择会议室</a></td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </form>










        <form id="meeting_time_choose" class="col-md-12">
            <fieldset class="form-horizontal">
                <legend>选择一个最理想的会议开始时间</legend>
                <div class="form-group">
                    <label for="meeting_num" class="col-md-3 control-label">会议编号：</label>
                    <div class="col-md-8">
                        <input disabled="disabled" type="text" id="meeting_num" value="M10001" placeholder="姓名" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="meeting_name" class="col-md-3 control-label">会议名称：</label>
                    <div class="col-md-8">
                        <input disabled="disabled" id="meeting_name" value="人事部例会" placeholder="姓名" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-md-3 control-label">开始日期：</label>
                    <div class="col-md-8">
                        <input disabled="disabled" type="date" id="name" value="2015-06-27" placeholder="姓名" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="start_time" class="col-md-3 control-label">开始时间：</label>
                    <div class="col-md-8">
                        <input type="time" id="start_time" class="form-control" value="09:30" />
                    </div>
                </div>
            </fieldset>
            <div class="text-center form-group">
                <button type="button" class="btn btn-primary" id="time_choose_ok_btn">确定</button>
                <button type="button" class="btn btn-primary col-md-offset-1 back_to_list_btn">返回</button>
            </div>
        </form>




        <form id="meeting_room_choose_one" class="col-md-12">
            <fieldset class="form-horizontal">
                <legend>以下会议室满足条件</legend>
                    <table class="table table-striped table-bordered text-center">
                        <thead>
                        <tr>
                            <th class="text-center">门牌号</th>
                            <th class="text-center">容纳人数</th>
                            <th class="text-center">选择</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>101</td>
                            <td>10</td>
                            <td><a class="btn btn-primary btn-sm" id="meeting_room_sure_btn">选择</a></td>
                        </tr>
                        <tr>
                            <td>102</td>
                            <td>25</td>
                            <td><a class="btn btn-primary btn-sm">选择</a></td>
                        </tr>
                        <tr>
                            <td>201</td>
                            <td>25</td>
                            <td><a class="btn btn-primary btn-sm">选择</a></td>
                        </tr>
                        <tr>
                            <td>209</td>
                            <td>50</td>
                            <td><a class="btn btn-primary btn-sm">选择</a></td>

                        </tr>
                        </tbody>
                    </table>
            </fieldset>

        </form>

        <form id="meeting_time_success" class="col-md-12">
            <fieldset class="form-horizontal">
                <legend>会议室选择成功</legend>
                <div class="form-group">
                    <label for="meeting_num" class="col-md-3 control-label">会议编号：</label>
                    <div class="col-md-8">
                        <p class="text-primary">M10001</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="meeting_name" class="col-md-3 control-label">会议名称：</label>
                    <div class="col-md-8">
                        <p class="text-primary">人事部例会</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-md-3 control-label">起止时间：</label>
                    <div class="col-md-8">
                        <p class="text-primary">2015-06-27 09:30 ~ 2015-06-27 11:30</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="start_time" class="col-md-3 control-label">会议室：</label>
                    <div class="col-md-8">
                        <p class="text-primary">101</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="start_time" class="col-md-3 control-label">参会人数：</label>
                    <div class="col-md-8">
                        <p class="text-primary">9</p>
                    </div>
                </div>
            </fieldset>
            <div class="text-center form-group">
                <button type="button" class="btn btn-primary col-md-offset-1 back_to_list_btn">返回</button>
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
<script src="js/pick.js"></script>
</html>