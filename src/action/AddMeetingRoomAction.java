package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.TbMeeting;
import model.TbMeetingRoom;
import model.TbMeetingRoomState;

import org.apache.struts2.ServletActionContext;

import service.AddMeetingRoomService;
import service.AddMeetingRoomServiceImpl;
import service.ShowMeetingRoomService;

import com.opensymphony.xwork2.ActionSupport;

import dao.AddMeetingRoom;

public class AddMeetingRoomAction extends ActionSupport {
	private ArrayList<TbMeeting> meetings;
	private ShowMeetingRoomService showMeetingRoomService;
	private AddMeetingRoomService addMeetingRoomService;
	public String execute()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String test = request.getParameter("number");
		int number=Integer.parseInt(request.getParameter("number"));
		int personlimit=Integer.parseInt(request.getParameter("personlimit"));
		TbMeetingRoomState defaul = new TbMeetingRoomState();
		defaul.setId(1);
		TbMeetingRoom room = new TbMeetingRoom(defaul, number, personlimit);
		addMeetingRoomService.addMeetingRoomS(room);
		
		setMeetings(getShowMeetingRoomService().getMeetingRoom());
		return "addsuc";
	}
	public AddMeetingRoomService getAddMeetingRoomService() {
		return addMeetingRoomService;
	}
	public void setAddMeetingRoomService(AddMeetingRoomService addMeetingRoomService) {
		this.addMeetingRoomService = addMeetingRoomService;
	}
	public ShowMeetingRoomService getShowMeetingRoomService() {
		return showMeetingRoomService;
	}
	public void setShowMeetingRoomService(ShowMeetingRoomService showMeetingRoomService) {
		this.showMeetingRoomService = showMeetingRoomService;
	}
	public ArrayList<TbMeeting> getMeetings() {
		return meetings;
	}
	public void setMeetings(ArrayList<TbMeeting> meetings) {
		this.meetings = meetings;
	}

}
