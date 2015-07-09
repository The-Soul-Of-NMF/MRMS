package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import model.TbMeeting;
import model.TbUser;
import service.MeetingService;

public class MeetingInforAction {
	private MeetingService meetingService;
	private List<TbMeeting> meetinglist;
	private String select;
	public String execute() throws IOException{
		HttpServletRequest request=ServletActionContext.getRequest();
		String selected=request.getParameter("select");
		this.select=selected;
		TbUser user=new TbUser();
		user=(TbUser)ActionContext.getContext().getSession().get("user");
		List<TbMeeting> s=meetingService.serachJoinMeeting(user);
		List<TbMeeting> s1=meetingService.serachOwnMeeting(user);
		s.addAll(s1);
		s1.clear();
		s1.addAll(s);
		if(selected!=null)
		{
			s.clear();
			switch(selected){
				case "0":
					s.addAll(s1);
					break;
				case "1":
					for(TbMeeting tm:s1){
						if(tm.getTbMeetingState().getId().toString().equals("1")){
							s.add(tm);
						}
					}
					break;
				case "2":
					for(TbMeeting tm:s1){
						if(tm.getTbMeetingState().getId().toString().equals("2")){
							s.add(tm);
						}
					}
					break;
				case "3":
					for(TbMeeting tm:s1){
						if(tm.getTbMeetingState().getId().toString().equals("3")){
							s.add(tm);
						}
					}
					break;
				case "4":
					for(TbMeeting tm:s1){
						if(tm.getTbMeetingState().getId().toString().equals("4")){
							s.add(tm);
						}
					}
					break;
				case "5":
					for(TbMeeting tm:s1){
						if(tm.getTbMeetingState().getId().toString().equals("5")){
							s.add(tm);
						}
					}
					break;
				case "6":
					for(TbMeeting tm:s1){
						if(tm.getTbMeetingState().getId().toString().equals("6")){
							s.add(tm);
						}
					}
					break;
			}
		}
		setMeetinglist(s);
		return "success";
	}

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public List<TbMeeting> getMeetinglist() {
		return meetinglist;
	}

	public void setMeetinglist(List<TbMeeting> meetinglist) {
		this.meetinglist = meetinglist;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}
}
