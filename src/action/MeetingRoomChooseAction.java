package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import model.TbMeeting;
import model.TbMeetingRoom;
import model.TbUser;
import service.MeetingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MeetingRoomChooseAction extends ActionSupport {
	private MeetingService meetingService;
	private TbMeeting meeting;
	private List<TbMeetingRoom> roomList;
	private List<TbMeeting> meetingList;
	private List<TbMeetingRoom> matchedRoomList;
	
	public String execute (){
		HttpServletRequest request = ServletActionContext.getRequest();
		int meetingId = Integer.valueOf(request.getParameter("id"));
		//TbUser user = (TbUser)request.getSession().getAttribute("user");
		
		//if(!validate(user.getId(), meetingId))
			if(!validate(1001, meetingId))
			return "error";
		
		String time = request.getParameter("time");
		int duration = meeting.getDuringTime();
		int totalPeople = meeting.getTotalNumber();
		Date meetingDate = meeting.getDate();
		
		meetingList = meetingService.serachMatchMeeting(meetingDate);
		//roomList = 
		for (TbMeetingRoom room : roomList){
			
		}
		
		//roomList = meetingService.
		
		return "success";
	}
	
	private boolean validate(int userID, int meetingId){
		meeting = meetingService.serachMeeting(meetingId);
		if (meeting.getTbUser().getId() == userID && meeting.getTbMeetingState().getId() == TbMeeting.State.WaitingMeetingRoom)
			return true;
		else
			return false;
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
