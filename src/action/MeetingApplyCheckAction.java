package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import model.TbMeeting;
import model.TbMeetingState;
import service.MeetingService;

import com.opensymphony.xwork2.ActionSupport;

public class MeetingApplyCheckAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MeetingService meetingService;
	private List<TbMeeting> waitMeetings;
	public String execute(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int	id=Integer.parseInt(request.getParameter("setMeetingId"));
		String opreation=request.getParameter("setop").toString();
		if(opreation.equals("0"))
		{
			meetingService.changeMeetingState(meetingService.serachMeeting(id), meetingService.serachMeetingState(2));
		}
		else
		{
			meetingService.changeMeetingState(meetingService.serachMeeting(id), meetingService.serachMeetingState(4));
		}
		setWaitMeetings(meetingService.serachWaitMeeting());
		return "success";
	} 
	
	public MeetingService getMeetingService() {
		return meetingService;
	}
	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public List<TbMeeting> getWaitMeetings() {
		return waitMeetings;
	}

	public void setWaitMeetings(List<TbMeeting> waitMeetings) {
		this.waitMeetings = waitMeetings;
	}
	
	
}
