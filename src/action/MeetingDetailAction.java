package action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.MeetingService;
import model.TbMeeting;
import model.TbUser;

import com.opensymphony.xwork2.ActionSupport;

public class MeetingDetailAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TbMeeting meeting;
	private MeetingService meetingService;
	private List<TbUser> meetingInvited;
	private Date finishTIme;
	public String execute(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int id=Integer.parseInt(request.getParameter("meetingId"));
		this.setMeeting(meetingService.serachMeeting(id));
		this.setMeetingInvited(meetingService.searchInvitedUser(meeting));
		
		return "success";
	}
	public TbMeeting getMeeting() {
		return meeting;
	}
	public void setMeeting(TbMeeting meeting) {
		this.meeting = meeting;
	}
	public MeetingService getMeetingService() {
		return meetingService;
	}
	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
	public List<TbUser> getMeetingInvited() {
		return meetingInvited;
	}
	public void setMeetingInvited(List<TbUser> meetingInvited) {
		this.meetingInvited = meetingInvited;
	}
	public Date getFinishTIme() {
		return finishTIme;
	}
	public void setFinishTIme(Date finishTIme) {
		this.finishTIme = finishTIme;
	}
}
