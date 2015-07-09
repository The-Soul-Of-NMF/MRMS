package action;

import java.util.List;

import model.TbUser;
import service.MeetingService;

import com.opensymphony.xwork2.ActionSupport;

public class MeetingApplyPrepare extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MeetingService meetingService;
	private List<TbUser> allUser;
	public String execute(){
		setAllUser(meetingService.serachAllUser());
		return "success";
	}
	public MeetingService getMeetingService() {
		return meetingService;
	}
	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
	public List<TbUser> getAllUser() {
		return allUser;
	}
	public void setAllUser(List<TbUser> allUser) {
		this.allUser = allUser;
	} 
}
