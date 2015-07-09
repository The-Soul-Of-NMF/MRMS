package action;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.RequestContext;
import org.apache.struts2.ServletActionContext;

import service.MeetingService;
import service.ShowMeetingRoomService;
import model.TbMeeting;

import com.opensymphony.xwork2.ActionSupport;

public class MeetingRoomGetAction extends ActionSupport {
	private MeetingService meetingService;
	private ShowMeetingRoomService s;
	private TbMeeting meeting;
	private Date startDate;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	private Date endDate;
	public String execute()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		int meetingId = Integer.valueOf(request.getParameter("meeting_id"));
		int meetingRoomId = Integer.valueOf(request.getParameter("meeting_room_id"));
		Date meetingTime;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		try {
			meetingTime = sdf.parse(request.getParameter("meeting_start_time"));
			Time time = new Time(meetingTime.getHours(),meetingTime.getMinutes(),meetingTime.getSeconds());
			meeting = meetingService.serachMeeting(meetingId);
			meeting.setStartTime(time);
			meeting.setTbMeetingState(meetingService.getMeetingState(TbMeeting.State.WaitingMeeing));
			
			
			startDate = meeting.getDate();
			startDate.setHours(time.getHours());
			startDate.setMinutes(time.getMinutes());
			
			int total = time.getHours()*60+time.getMinutes();
			total += meeting.getDuringTime();
			
			endDate = meeting.getDate();
			endDate.setHours(total/60);
			endDate.setMinutes(total%60);
			
			meeting.setTbMeetingRoom(meetingService.searchMeetingRoom(meetingRoomId));
			meetingService.updateMeeting(meeting);
			return "success";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "fail";
		
	}

}
