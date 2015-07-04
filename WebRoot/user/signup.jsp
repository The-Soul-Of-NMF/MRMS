<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>
<!--用户注册页面-->
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../lib/system/css/left_menu.css" rel="stylesheet" />
    <link href="./css/signup.css" rel="stylesheet" />
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
                <li><a href="../index.jsp">登录</a></li>
                <li class="active"><a href="./signup.jsp">注册</a></li>
            </ul>

        </div>
    </div>
</nav>
<!-- 顶部导航栏结束 -->
<div class="container wrap_content">
    <div id="register_box">
        <p id="register_title">注册</p>
        <div id="form_register">
            <form name="register_form" method="post" id="register_form">
                <table>
                    <tbody>
                    <tr>
                        <td><label id="label_name" for="name">姓名</label></td>
                        <td><input class="input_text" id="name" name="name"  placeholder="输入你的用户名" type="text" /></td>
                    </tr>
                    <tr>
                        <td><label id="label_password" for="password">密码</label></td>
                        <td><input class="input_text" id="password" name="password" placeholder="输入密码" type="password" /></td>
                    </tr>
                    <tr>
                        <td><label id="label_ensure_password" for="ensure_password">确认密码</label></td>
                        <td><input class="input_text" id="ensure_password" name="ensure_password" placeholder="再次输入密码" type="password" /></td>
                    </tr>

                    <tr>
                        <td><label id="label_gender" for="gender">性别</label></td>
                        <td>
                            <select id="gender" name="gender">
                                <option>男</option>
                                <option>女</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label id="label_department" for="department">所在部门</label></td>
                        <td>
                            <select id="department" name="department">
                                <option></option>
                                <option>人事部</option>
                                <option>财务部</option>
                                <option>技术部</option>
                                <option>后勤部</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label id="label_email" for="email">邮箱</label></td>
                        <td><input class="input_text" id="email" name="email" placeholder="输入邮箱地址" type="text" /></td>
                    </tr>
                    <tr>
                        <td><label id="label_tel" for="tel">手机</label></td>
                        <td><input class="input_text" id="tel" name="tel" placeholder="输入手机号" type="text" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><p id="button_submit">注 册</p></td>
                    </tr>
                    <tr align="right">
                        <td colspan="2">
                            <p id="login_redirect">已有账号？
                                <span id="login_link" onclick="document.location.href='../index.jsp'">点我登录</span>
                            </p>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
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