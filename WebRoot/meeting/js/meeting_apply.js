function checkinfor(){
	var name=document.getElementById("name").value;
	var date=document.getElementById("date").value;
	var time=document.getElementById("time").value;
	var introduce=document.getElementById("introduce").value;
	var invited=document.getElementsByName("invited");
	var a=invited.length;
	for(var i=0;i<a;i++){
		if(invited[i].checked==1)
		{
			a=-1;
		}
	}
	if(!(name&&date&&time&&introduce))
	{
		alert("请输入完整信息!");
	}
	else if(a!=-1)
	{
		alert("请选择参会人员！");
	}
	else if(confirm("确认申请？"))
	{
		document.meetinginfor.submit();
	}
}