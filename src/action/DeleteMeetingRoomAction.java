package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.TbMeeting;

import org.apache.struts2.ServletActionContext;

import service.DeleteMeetingRoomService;
import service.ShowMeetingRoomService;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteMeetingRoomAction extends ActionSupport {
	private ArrayList<TbMeeting> meetings;
	private ShowMeetingRoomService showMeetingRoomService;
	private DeleteMeetingRoomService deleteMeetingRoomService;
	public String execute()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("del_id")); 
		deleteMeetingRoomService.deleteS(id);
		
		setMeetings(getShowMeetingRoomService().getMeetingRoom());
		return "delsucc";
	}
	public DeleteMeetingRoomService getDeleteMeetingRoomService() {
		return deleteMeetingRoomService;
	}
	public void setDeleteMeetingRoomService(DeleteMeetingRoomService deleteMeetingRoomService) {
		this.deleteMeetingRoomService = deleteMeetingRoomService;
	}
	public ArrayList<TbMeeting> getMeetings() {
		return meetings;
	}
	public void setMeetings(ArrayList<TbMeeting> meetings) {
		this.meetings = meetings;
	}
	public ShowMeetingRoomService getShowMeetingRoomService() {
		return showMeetingRoomService;
	}
	public void setShowMeetingRoomService(ShowMeetingRoomService showMeetingRoomService) {
		this.showMeetingRoomService = showMeetingRoomService;
	}
}
