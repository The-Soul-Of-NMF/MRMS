package action;

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

public class MeetingRoomDetailAction extends ActionSupport {
	private MeetingService meetingService;
	private int roomId;
	private List<TbMeeting> meetings;
	private Date currentDate;
	private String dateStr;
	private String meetingsJSON;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	public String execute()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		roomId = Integer.valueOf(request.getParameter("room_id"));
		dateStr = request.getParameter("date");
		if (dateStr != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				currentDate = sdf.parse(dateStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			currentDate = new Date();
		}
		
		meetings = meetingService.serachMatchMeeting(currentDate, roomId);
		meetingsJSON = getMeetingsJSON(meetings);
		
		return "success";
	}
	public List<TbMeeting> getMeetings() {
		return meetings;
	}
	public void setMeetings(List<TbMeeting> meetings) {
		this.meetings = meetings;
	}
	public MeetingService getMeetingService() {
		return meetingService;
	}
	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
	
	private String getMeetingsJSON(List<TbMeeting> meetings){
		StringBuilder str = new StringBuilder();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		str.append("[");
		int i =0;
		for(TbMeeting m : meetings){
			if (++i == 1)
				str.append("{");
			else
				str.append(",{");
			
			str.append("\"startTime\": \"" + format.format(m.getStartTime())+"\",");
			str.append("\"duration\": \"" + m.getDuringTime()+"\",");
			str.append("\"message\": \"" + m.getTitle()+"\",");
			str.append("\"url\": \"" + "/MRMS/meeting/meetingDetailAction?meeingId=" + m.getId() +"\"");
			
			str.append("}");
		}
		str.append("]");
		return str.toString();
	}
	public String getMeetingsJSON() {
		return meetingsJSON;
	}
	public void setMeetingsJSON(String meetingsJSON) {
		this.meetingsJSON = meetingsJSON;
	}

}
