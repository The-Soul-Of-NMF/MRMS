package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TbUser;

import org.apache.struts2.ServletActionContext;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserAction extends ActionSupport{
	private UserService userservice;
	private TbUser user;
	
	public TbUser getUser() {
		return user;
	}

	public void setUser(TbUser user) {
		this.user = user;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public String update() throws IOException{
		  HttpServletRequest request=ServletActionContext.getRequest();
	      HttpServletResponse response=ServletActionContext.getResponse();
	      PrintWriter out=response.getWriter();
	      String id=request.getParameter("useraccount");
	      String email=request.getParameter("useremail");
	      String phone=request.getParameter("usertel");
	      String password=request.getParameter("userpassword");
	      String pic=request.getParameter("userpic");
	      System.out.println(pic+"www");
	      userservice.updateUser(Integer.parseInt(id), password, email,Long.parseLong(phone));
	      user=(TbUser) request.getSession().getAttribute("user");
	      user.setPassword(password);
	      user.setEmail(email);
	      user.setPhone(Long.parseLong(phone));
	      request.getSession().setAttribute("user", user);
	      out.close();
	      return "success";
	}
}
