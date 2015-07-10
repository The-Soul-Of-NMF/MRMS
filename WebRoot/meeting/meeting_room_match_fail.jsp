<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ page contentType="text/html;charset=utf-8"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="model.TbUser"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!--会议室选择页面-->
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="/MRMS/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/MRMS/lib/system/css/left_menu.css" rel="stylesheet" />
        <link href="/MRMS/lib/timeline/jquery.timeline_h.css" rel="stylesheet" />
    <link href="/MRMS/meeting/css/pick.css" rel="stylesheet"/>

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
                        <li><a href='./userinformationAction'>修改个人信息</a></li>
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
                 <a class="list-group-item" href='../meeting/meetingApplyPrepare'>
                        会议申请
                    </a>
                    <a class="list-group-item" href="/MRMS/meeting/meetingForRoomAction">
                        会议室选择
                    </a>
                    <a class="list-group-item" href="../user/shownoticeAction">
                        通知<span class="badge">20</span>
                    </a>
                    <a class="list-group-item" href='../meeting/meetingInforAction'>
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
                    <a class="list-group-item"  href='../user/usercheckAction'>
                        用户注册审查<span class="badge">20</span>
                    </a>
                    <a class="list-group-item" href='../meeting/showWaitMeetingAction'>
                        会议审查<span class="badge">10</span>
                    </a>
                    <a class="list-group-item" href="../department/deparManaAction_show">
                        部门信息管理
                    </a>
                    <a class="list-group-item" href="/MRMS/meetingRoom/showMeetingRoomAction">
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


    <div class="col-md-9 main_content">
        <div class="page-header">
            <h3><strong>会议室选择</strong></h3>
        </div>
        <h4><strong>会议时长：<s:property value="meeting.duringTime"/>min&nbsp 会议总人数：<s:property value="meeting.totalNumber"/>人</strong></h4>
        
	<s:iterator value="roomList">
	<div class="room">
		<p>Room ID: <span class="r_id"><s:property value="id"/></span></p>
		<p>门牌号: <s:property value="doorNumber"/></p>
		<p>人数上限: <s:property value="personLimit"/></p>
		<div class="room_selection">
			<input type="hidden" value="<s:property value='reservedWord' />" />
		</div>	
		<a class="confirm_btn btn btn-primary">确认</a>
	</div>

	</s:iterator>

	<form id="get_room_form" action="/MRMS/meeting/meetingRoomGetAction" method="post">
		<input name="meeting_id" type="hidden" value="<s:property value='meeting.id' />" />
		<input id="meeting_room_id" name="meeting_room_id" type="hidden" value="" />
		<input id="meeting_start_time" name="meeting_start_time" type="hidden"  value="" />
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
<script src="/MRMS/lib/timeline/jquery.timeline_h.js"></script>

<script type="text/javascript">
	$(function(){
		$(".room_selection").each(function(){
			var t = $(this);
			t.timeline_h({
				callback: function(){
					var j = t.find("input").first().val();
					var obj = JSON.parse(j);
					for (var x in obj){
						t.meeting(obj[x]);
					}
				}
			})
		});
		
		$(".confirm_btn").click(function(){
			var b = $(this);
			var time = $(this).get_time();
			$("#meeting_start_time").val(time.startTime);
			$("#meeting_room_id").val(b.parent().find(".r_id").first().text());
			bootbox.confirm("确定选择该会议室在"+ $("#meeting_start_time").val()+"召开会议？",
            	function (choice) {
                	if (choice) {
                    	$("#get_room_form")[0].submit();
                }
            });	
		});
	})
</script>
</html>