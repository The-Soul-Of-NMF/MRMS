package action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TbDepartment;
import model.TbUser;

import org.apache.struts2.ServletActionContext;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserManageAction extends ActionSupport{
	private UserService userservice;
	private List tbuser;
	private List dep;
	
	public List getDep() {
		return dep;
	}

	public void setDep(List dep) {
		this.dep = dep;
	}

	public List getTbuser() {
		return tbuser;
	}

	public void setTbuser(List tbuser) {
		this.tbuser = tbuser;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	
	public String manage(){
		
		tbuser=userservice.queryTbUser();
		dep=userservice.queryDepartment();
		return "success";
	}
	public String managecheck() throws IOException{
		  HttpServletRequest request=ServletActionContext.getRequest();
	      HttpServletResponse response=ServletActionContext.getResponse();
	      PrintWriter out=response.getWriter();
	      String id=request.getParameter("userid");
	      String department=request.getParameter("userdepartment");
	      String work=request.getParameter("userwork");
	      userservice.updateTbUser(Integer.parseInt(id),department,work);
		return "success";
	}

}
