package action;

import java.util.ArrayList;
import java.util.List;

import model.TbUser;
import service.MeetingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MeetingApplyPrepare extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MeetingService meetingService;
	private List<TbUser> allUser;
	public String execute(){
		List<TbUser> all=new ArrayList<TbUser>();
		all.addAll(meetingService.serachAllUser());
		int id=((TbUser)ActionContext.getContext().getSession().get("user")).getId();
		int alllength=all.size();
		for(int i=0;i<alllength;i++){
			if(all.get(i).getId()==id)
			{
				all.remove(i);
			}
		}
		this.setAllUser(all);
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
