package action;

import model.TbUser;
import service.MeetingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	/**
	 * 
	 */
	private MeetingService meetingService;
	private static final long serialVersionUID = 1L;

	public String execute(){
		TbUser user=new TbUser();
		user.setId(1);
		user.setName("hong");
		ActionContext.getContext().getSession().put("user", user);
		//System.out.println(ActionContext.getContext().getSession().get("userid").toString());
		//System.out.println(meetingService.serachWaitMeeting().size());
		return "success";
	}

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
}
