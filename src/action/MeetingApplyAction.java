package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JTree;

import model.TbMeeting;
import model.TbMeetingState;
import model.TbMeetingUser;
import model.TbUser;

import org.apache.struts2.ServletActionContext;

import service.MeetingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class MeetingApplyAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MeetingService meetingService;
	private List<TbUser> allUser;

	public String execute() throws ParseException{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		SimpleDateFormat aim=new SimpleDateFormat("yyyy-MM-dd");
		String name=request.getParameter("name");
		Date date=aim.parse(request.getParameter("date"));
		int time=Integer.parseInt(request.getParameter("time"));
		String introduce=request.getParameter("introduce");
		String[] invited=request.getParameterValues("invited");
		TbMeeting meeting=new TbMeeting();
		int userid=((TbUser)ActionContext.getContext().getSession().get("user")).getId();
		TbUser user=meetingService.serachUser(userid);
		TbMeetingState state=new TbMeetingState();
		state.setId(1);
		meeting.setTitle(name);
		meeting.setDate(date);
		meeting.setDuringTime(time);
		meeting.setDescription(introduce);
		meeting.setTbUser(user);
		meeting.setTbMeetingState(state);
		meeting.setTotalNumber(invited.length);
		meetingService.saveMeeting(meeting);
		TbMeeting lastmeeting=meetingService.getTheLastMeeting();
		meetingService.createNewMeetingUser(lastmeeting,invited);
		setAllUser(meetingService.serachAllUser());
		int allSize=allUser.size();
		for(int i=0;i<allSize;i++){
			if(allUser.get(i).getId()==userid)
			{
				allUser.remove(i);
				i=10000;
			}
		}
		return "success";
	}

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public List<TbUser> getAllUser() {
		return allUser;
	}

	public void setAllUser(List<TbUser> allUser) {
		this.allUser = allUser;
	}
}
