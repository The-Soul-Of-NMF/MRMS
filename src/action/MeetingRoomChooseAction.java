package action;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import model.TbMeeting;
import model.TbMeetingRoom;
import model.TbUser;
import service.MeetingService;
import service.ShowMeetingRoomService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MeetingRoomChooseAction extends ActionSupport {
	private MeetingService meetingService;
	private ShowMeetingRoomService showMeetingRoomService;
	private TbMeeting meeting;
	private List<TbMeetingRoom> roomList;
	private List<TbMeetingRoom> matchedRoomList = new ArrayList<TbMeetingRoom>();
	private Date meetingTime;
	public Date getMeetingTime() {
		return meetingTime;
	}

	public void setMeetingTime(Date meetingTime) {
		this.meetingTime = meetingTime;
	}

	private Date meetingDate;
	public static int startTime = 8*60;
	public static int endTime = 23*60;
	
	public String execute (){
		HttpServletRequest request = ServletActionContext.getRequest();
		int meetingId = Integer.valueOf(request.getParameter("id"));
		TbUser user = (TbUser)request.getSession().getAttribute("user");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		try {
			meetingTime = sdf.parse(request.getParameter("time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!validate(user.getId(), meetingId))
			return "error";
		
		
		int totalPeople = meeting.getTotalNumber();
		meetingDate = meeting.getDate();
		
		roomList = showMeetingRoomService.getMeetingRoom(totalPeople);
		int meetingStartTime = meetingTime.getHours()*60 + meetingTime.getMinutes();
		int meetingEndTime = meetingStartTime + meeting.getDuringTime();
		for (TbMeetingRoom room : roomList){
			boolean match = false;
			List<TbMeeting> ms = meetingService.serachMatchMeeting(meetingDate, room.getId());
			int intervalStart = startTime;
			int intervalEnd = endTime;
			for (TbMeeting m : ms){
				int mStartTime = m.getStartTime().getHours()*60 + m.getStartTime().getMinutes();
				int mEndTime = mStartTime + m.getDuringTime();
				if (mStartTime != intervalStart){
					intervalEnd = mStartTime;
					if (meetingStartTime >= intervalStart && meetingEndTime <= intervalEnd){
						matchedRoomList.add(room);
						match = true;
						break;
					}
				}
				intervalStart = mEndTime;
				
			}
			if(!match){
				intervalEnd = endTime;
				if (meetingStartTime >= intervalStart && meetingEndTime <= intervalEnd){
					matchedRoomList.add(room);
					match = true;
				}
			}
		}
		
		if (matchedRoomList.size() != 0)
			return "success";
		else{
			for(TbMeetingRoom r : roomList){
				List<TbMeeting> meetings = meetingService.serachMatchMeeting(meeting.getDate(), r.getId());
				r.setReservedWord(getMeetingsJSON(meetings));
			}
			return "fail";
		}
	}
	
	public List<TbMeetingRoom> getMatchedRoomList() {
		return matchedRoomList;
	}

	public void setMatchedRoomList(List<TbMeetingRoom> matchedRoomList) {
		this.matchedRoomList = matchedRoomList;
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

	public ShowMeetingRoomService getShowMeetingRoomService() {
		return showMeetingRoomService;
	}

	public List<TbMeetingRoom> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<TbMeetingRoom> roomList) {
		this.roomList = roomList;
	}

	public void setShowMeetingRoomService(ShowMeetingRoomService showMeetingRoomService) {
		this.showMeetingRoomService = showMeetingRoomService;
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
			str.append("\"duration\": \"" + m.getDuringTime()+"\"");
			
			str.append("}");
		}
		str.append("]");
		return str.toString();
	}
	
	
}
