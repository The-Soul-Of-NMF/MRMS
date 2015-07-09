package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import model.TbUserApplication;
import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserCheckAction extends ActionSupport{
	private UserService userservice;
	private List tbuserapplication;
	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	
	

	public List getTbuserapplication() {
		return tbuserapplication;
	}

	public void setTbuserapplication(List tbuserapplication) {
		this.tbuserapplication = tbuserapplication;
	}

	public String check(){
		tbuserapplication=userservice.queryUserApplication();
		return "success";
	}
	public String checks() throws IOException{
      HttpServletRequest request=ServletActionContext.getRequest();
      HttpServletResponse response=ServletActionContext.getResponse();
      PrintWriter out=response.getWriter();
      int id=Integer.parseInt(request.getParameter("userid"));
      userservice.saveUser(id);
      userservice.deletUserApplication(id);
      out.print("1");
      out.close();
	  return "success";
	}
	public String checktwo() throws IOException{
		  HttpServletRequest request=ServletActionContext.getRequest();
	      HttpServletResponse response=ServletActionContext.getResponse();
	      PrintWriter out=response.getWriter();
	      int id=Integer.parseInt(request.getParameter("userid"));
	      userservice.deletUserApplication(id);
	      out.print("1");
	      out.close();
		  return "success";
	}
}
