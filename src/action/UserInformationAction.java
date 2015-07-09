package action;

import javax.servlet.http.HttpServletRequest;

import model.TbUser;

import org.apache.struts2.ServletActionContext;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserInformationAction extends ActionSupport{
	private UserService userservice;
	private String limit;
	private TbUser user;
	public TbUser getUser() {
		return user;
	}
	public void setUser(TbUser user) {
		this.user = user;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public UserService getUserservice() {
		return userservice;
	}
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	public String show(){
		HttpServletRequest request=ServletActionContext.getRequest();
		 limit=(String) request.getSession().getAttribute("limit");
		 user=(TbUser)request.getSession().getAttribute("user");
		return "success";
	}

}
