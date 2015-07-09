package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import model.TbMeeting;
import model.TbUser;
import service.MeetingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MeetingForRoomAction extends ActionSupport {
	private MeetingService meetingService;
	private List<TbMeeting> meetings;
	public String execute (){
//		HttpServletRequest request = ServletActionContext.getRequest();
//		TbUser user = (TbUser)request.getSession().getAttribute("user");
		
		TbUser user = new TbUser();
		user.setId(1001);
		this.meetings = meetingService.serachOwnMeeting(user, TbMeeting.State.WaitingMeetingRoom);
		return "success";
	}
	public MeetingService getMeetingService() {
		return meetingService;
	}
	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
	public List<TbMeeting> getMeetings() {
		return meetings;
	}
	public void setMeetings(List<TbMeeting> meetings) {
		this.meetings = meetings;
	}
	
	
}
