package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteSessionAction extends ActionSupport{
private UserService userservice;

public UserService getUserservice() {
	return userservice;
}

public void setUserservice(UserService userservice) {
	this.userservice = userservice;
}

public String close(){
	 HttpServletRequest request=ServletActionContext.getRequest();
	 request.getSession().removeAttribute("limit");
	 request.getSession().removeAttribute("user");
	 request.getSession().removeAttribute("department");
	return "success";
}
}
