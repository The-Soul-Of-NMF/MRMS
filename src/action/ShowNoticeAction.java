package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.TbDepartment;
import model.TbNoticeInteraction;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import service.GetNoticeService;
import service.SaveMeetingRoomService;

import com.opensymphony.xwork2.ActionSupport;

import dao.SaveMeetingRoom;

public class ShowNoticeAction extends ActionSupport{
	private GetNoticeService GetNoticeService;
	private ArrayList<TbNoticeInteraction> readed;
	public ArrayList<TbNoticeInteraction> getReaded() {
		return readed;
	}

	public void setReaded(ArrayList<TbNoticeInteraction> readed) {
		this.readed = readed;
	}

	public ArrayList<TbNoticeInteraction> getUnlist() {
		return unlist;
	}

	public void setUnlist(ArrayList<TbNoticeInteraction> unlist) {
		this.unlist = unlist;
	}
	private ArrayList<TbNoticeInteraction> unlist;
	public String execute()
	{
		
		readed = GetNoticeService.getNoticeS(1);
		unlist = new ArrayList<TbNoticeInteraction>();
		for (int i =0;i<readed.size();i++) {
			if(readed.get(i).getTbNotice().getTbNoticeType().getId()==2)
			{
				unlist.add(readed.get(i));
				readed.remove(readed.get(i));
				
			}
		}
		//调试用，使用时请把session中的用户id传入。
		return "suc";
		
	}
	
	public GetNoticeService getGetNoticeService() {
		return GetNoticeService;
	}
	public void setGetNoticeService(GetNoticeService getNoticeService) {
		GetNoticeService = getNoticeService;
	}
	

}
