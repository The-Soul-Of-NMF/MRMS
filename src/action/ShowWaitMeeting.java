package action;

import java.util.List;

import service.MeetingService;
import model.TbMeeting;

import com.opensymphony.xwork2.ActionSupport;

public class ShowWaitMeeting extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TbMeeting> waitMeetings;
	private MeetingService meetingService;
	public String execute(){
		setWaitMeetings(meetingService.serachWaitMeeting());
		return "success";
	}
	public List<TbMeeting> getWaitMeetings() {
		return waitMeetings;
	}
	public void setWaitMeetings(List<TbMeeting> waitMeetings) {
		this.waitMeetings = waitMeetings;
	}
	public MeetingService getMeetingService() {
		return meetingService;
	}
	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
}
