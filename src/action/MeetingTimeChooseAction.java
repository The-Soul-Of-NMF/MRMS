package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import model.TbMeeting;
import model.TbUser;
import service.MeetingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MeetingTimeChooseAction extends ActionSupport {
	private MeetingService meetingService;
	private TbMeeting meeting;
	public String execute (){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id"));
		meeting = meetingService.serachMeeting(id);
		return "success";
	}
	public MeetingService getMeetingService() {
		return meetingService;
	}
	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
	public TbMeeting getMeeting() {
		return meeting;
	}
	public void setMeeting(TbMeeting meeting) {
		this.meeting = meeting;
	}

	
	
}
