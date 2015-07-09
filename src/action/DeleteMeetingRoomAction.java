package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.DeleteMeetingRoomService;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteMeetingRoomAction extends ActionSupport {

	private DeleteMeetingRoomService deleteMeetingRoomService;
	public String execute()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("del_id")); 
		deleteMeetingRoomService.deleteS(id);
		return "delsucc";
	}
	public DeleteMeetingRoomService getDeleteMeetingRoomService() {
		return deleteMeetingRoomService;
	}
	public void setDeleteMeetingRoomService(DeleteMeetingRoomService deleteMeetingRoomService) {
		this.deleteMeetingRoomService = deleteMeetingRoomService;
	}
}
