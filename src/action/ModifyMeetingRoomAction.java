package action;

import javax.servlet.http.HttpServletRequest;

import model.TbMeetingRoom;
import model.TbMeetingRoomState;

import org.apache.struts2.ServletActionContext;

import service.ModifyMeetingRoomService;

import com.opensymphony.xwork2.ActionSupport;

public class ModifyMeetingRoomAction extends ActionSupport {

	private ModifyMeetingRoomService meetingRoomService;
	public String execute()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		System.out.println(request.getParameter("state"));
		int state = Integer.parseInt(request.getParameter("state"));
		int id = Integer.parseInt(request.getParameter("current_id"));
		int number=Integer.parseInt(request.getParameter("number"));
		int personlimit=Integer.parseInt(request.getParameter("personlimit"));
		meetingRoomService.modifyS(state, number, personlimit, id);
		return "modisucc";
	}
	public ModifyMeetingRoomService getMeetingRoomService() {
		return meetingRoomService;
	}
	public void setMeetingRoomService(ModifyMeetingRoomService meetingRoomService) {
		this.meetingRoomService = meetingRoomService;
	}
}
