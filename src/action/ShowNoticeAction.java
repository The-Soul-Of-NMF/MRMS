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
	public String execute()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		System.out.println("111");
		ArrayList<TbNoticeInteraction> list = GetNoticeService.getNoticeS(0);
		
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
