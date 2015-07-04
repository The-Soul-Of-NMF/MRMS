<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>
<!--用户登录页面-->
<!DOCTYPE html>
<html>
    <head lang="en">
        <meta charset="UTF-8">
        <title></title>
        <link href="./lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link href="./lib/system/css/left_menu.css" rel="stylesheet" />
        <link href="./user/css/login.css" rel="stylesheet" />
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
                        <li class="active"><a href="./index.jsp">登录</a></li>
                        <li><a href="./user/signup.jsp">注册</a></li>
                    </ul>

                </div>
            </div>
        </nav>
        <div class="container wrap_content">
            <div id="login_box">
                <p id="login_title">登录<p>
                <div id="form_login">
                    <form name="login_form" method="post" id="login_form">
                        <table>
                            <tr>
                                <label id="label_name" for="name"></label>
                                <input class="input_text" id="name" name="name"  placeholder="输入你的用户名" type="text" />
                            </tr>
                            <tr>
                                <label id="label_password" for="password"></label>
                                <input class="input_text" id="password" name="password" placeholder="输入密码" type="password" />
                            </tr>
                            <tr>
                                <div id="login_safe">

                                </div>
                            </tr>
                            <tr>
                                <p id="button_submit" onclick="location.href='./user/welcome.jsp'">登 录</p>
                            </tr>
                            <tr align="right">
                                <p id="register_redirect">没有帐号？新成员？
                                    <span id="register_link" onclick="document.location.href='./user/signup.jsp'">点我注册</span>
                                </p>
                            </tr>
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
    <script src="./lib/scripts/jquery-1.11.0.min.js"></script>
    <script src="./lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="./lib/scripts/bootbox.min.js"></script>
</html>