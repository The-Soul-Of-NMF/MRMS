<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>用户信息管理</title>
    <link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../lib/system/css/left_menu.css" rel="stylesheet" />
    <link href="css/user_management.css" rel="stylesheet" />
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
                    <a class="list-group-item" href="../admin/department_management.jsp">
                        部门信息管理
                    </a>
                    <a class="list-group-item" href="../admin/meeting_room_management.jsp">
                        会议室信息管理
                    </a>
                    <a class="list-group-item active" href="../admin/user_management.jsp">
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
            <h3><strong>用户信息管理</strong></h3>
        </div>
    	<div class="col-md-12">
        	<table class="table table-striped table-bordered text-center">
            	<caption>
            	    <h4><strong>所有用户信息</strong></h4>
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
                    <th class="text-center">邮箱</th>
                    <th class="text-center">手机号</th>
                    <th class="text-center">部门</th>
                    <th class="text-center">状态</th>
                    <th class="text-center">操作</th>
                </tr>
            </thead>
            <tbody>
            	<tr>
                    <td>12*****</td>
                    <td>Jerry</td>
                    <td>123@sina.com</td>
                    <td>13*******43</td>
                    <td>
                    	<select id="a00" class="form-control" disabled="disabled">
                        	<option>技术部</option>
                        	<option>财务部</option>
                        	<option>人事部</option>
                        	<option>后勤部</option>
                    	</select>
                    </td>
                    <td>
                    	<select id="a01" class="form-control" disabled="disabled">
                        	<option>在职</option>
                        	<option>离职</option>
                    	</select>
                    </td>
                    <td>
                        <a id="modify_0" class="btn btn-danger btn-sm">修改</a>
                    </td>
                </tr>
                <tr>
                    <td>12*****</td>
                    <td>Jerry</td>
                    <td>123@sina.com</td>
                    <td>13*******43</td>
                    <td>
                    	<select id="a10" class="form-control" disabled="disabled">
                        	<option>技术部</option>
                        	<option>财务部</option>
                        	<option>人事部</option>
                        	<option>后勤部</option>
                    	</select>
                    </td>
                    <td>
                    	<select id="a11" class="form-control" disabled="disabled">
                        	<option>在职</option>
                        	<option>离职</option>
                    	</select>
                    </td>
                    <td>
                        <a id="modify_1" class="btn btn-danger btn-sm">修改</a>
                    </td>
                </tr>
                <tr>
                    <td>12*****</td>
                    <td>Jerry</td>
                    <td>123@sina.com</td>
                    <td>13*******43</td>
                    <td>
                    	<select id="a20" class="form-control" disabled="disabled">
                        	<option>技术部</option>
                        	<option>财务部</option>
                        	<option>人事部</option>
                        	<option>后勤部</option>
                    	</select>
                    </td>
                    <td>
                    	<select id="a21" class="form-control" disabled="disabled">
                        	<option>在职</option>
                        	<option>离职</option>
                    	</select>
                    </td>
                    <td>
                        <a id="modify_2" class="btn btn-danger btn-sm">修改</a>
                    </td>
                </tr>
                <tr>
                    <td>12*****</td>
                    <td>Jerry</td>
                    <td>123@sina.com</td>
                    <td>13*******43</td>
                    <td>
                    	<select id="a30" class="form-control" disabled="disabled">
                        	<option>技术部</option>
                        	<option>财务部</option>
                        	<option>人事部</option>
                        	<option>后勤部</option>
                    	</select>
                    </td>
                    <td>
                    	<select id="a31" class="form-control" disabled="disabled">
                        	<option>在职</option>
                        	<option>离职</option>
                    	</select>
                    </td>
                    <td>
                        <a id="modify_3" class="btn btn-danger btn-sm">修改</a>
                    </td>
                </tr>
                <tr>
                    <td>12*****</td>
                    <td>Jerry</td>
                    <td>123@sina.com</td>
                    <td>13*******43</td>
                    <td>
                    	<select id="a40" class="form-control" disabled="disabled">
                        	<option>技术部</option>
                        	<option>财务部</option>
                        	<option>人事部</option>
                        	<option>后勤部</option>
                    	</select>
                    </td>
                   	<td>
                    	<select id="a41" class="form-control" disabled="disabled">
                        	<option>在职</option>
                        	<option>离职</option>
                    	</select>
                    </td>
                    <td>
                        <a id="modify_4"  class="btn btn-danger btn-sm">修改</a>
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
<script>
	$(function(){
		$("#modify_0").click(function(){
			if($(this).text()=="保存"){
				$("#a00").attr("disabled","disabled");
				$("#a01").attr("disabled","disabled");
				$("#modify_0").text("修改");
			}else if($(this).text()=="修改"){
				$("#a00").removeAttr("disabled");
				$("#a01").removeAttr("disabled");
				$("#modify_0").text("保存");
			}
		});
	});
	
	$(function(){
		$("#modify_1").click(function(){
			if($(this).text()=="保存"){
				$("#a10").attr("disabled","disabled");
				$("#a11").attr("disabled","disabled");
				$("#modify_1").text("修改");
			}else if($(this).text()=="修改"){
				$("#a10").removeAttr("disabled");
				$("#a11").removeAttr("disabled");
				$("#modify_1").text("保存");
			}
		});
	});
	
	$(function(){
		$("#modify_2").click(function(){
			if($(this).text()=="保存"){
				$("#a20").attr("disabled","disabled");
				$("#a21").attr("disabled","disabled");
				$("#modify_2").text("修改");
			}else if($(this).text()=="修改"){
				$("#a20").removeAttr("disabled");
				$("#a21").removeAttr("disabled");
				$("#modify_2").text("保存");
			}
		});
	});
	
	$(function(){
		$("#modify_3").click(function(){
			if($(this).text()=="保存"){
				$("#a30").attr("disabled","disabled");
				$("#a31").attr("disabled","disabled");
				$("#modify_3").text("修改");
			}else if($(this).text()=="修改"){
				$("#a30").removeAttr("disabled");
				$("#a31").removeAttr("disabled");
				$("#modify_3").text("保存");
			}
		});
	});
	
	$(function(){
		$("#modify_4").click(function(){
			if($(this).text()=="保存"){
				$("#a40").attr("disabled","disabled");
				$("#a41").attr("disabled","disabled");
				$("#modify_4").text("修改");
			}else if($(this).text()=="修改"){
				$("#a40").removeAttr("disabled");
				$("#a41").removeAttr("disabled");
				$("#modify_4").text("保存");
			}
		});
	});
</script>
</html>