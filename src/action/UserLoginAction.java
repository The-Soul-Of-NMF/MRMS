package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TbAdmin;
import model.TbUser;

import org.apache.struts2.ServletActionContext;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport{
	private UserService userservice;
	private String name;
	private String password;
	private TbUser user;
	private TbAdmin admin;
	private String limit;
	
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
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
   
	public TbUser getUser() {
		return user;
	}

	public void setUser(TbUser user) {
		this.user = user;
	}
    
	public TbAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(TbAdmin admin) {
		this.admin = admin;
	}

	public String logincheck() throws IOException{
		  HttpServletRequest request=ServletActionContext.getRequest();
	      HttpServletResponse response=ServletActionContext.getResponse();
	      PrintWriter out=response.getWriter();
	      name=request.getParameter("username");
	      password=request.getParameter("userpassword");
	      if(name.equals("")||password.equals("")){
	      out.print("0");
	      }
	      else if(!name.matches("[0-9]+")){
	    	  out.print("1");
	      }
	      else{
	    	  List list=userservice.queryUser(name, password);
	    	  if(list.size()==0){
	           out.print("2");
	           }
	    	  else{
	    		  user=(TbUser)userservice.queryUser(name, password).get(0);
	    		  if(user.getTbAdmins().size()!=0){
	    		  Iterator iterator=user.getTbAdmins().iterator();
	    		  while(iterator.hasNext()){
	    			  admin=(TbAdmin) iterator.next();
	    		  }
	    		  if(admin.getSuperAdmin()==true){
	    			  request.getSession().setAttribute("limit", "3");
		    		  request.getSession().setAttribute("user", user);
	    		  }
	    		  else{
	    			  request.getSession().setAttribute("limit", "2");
		    		  request.getSession().setAttribute("user", user);
	    		  }
	    		  }
	    		  else{
	    			  request.getSession().setAttribute("limit", "1");
		    		  request.getSession().setAttribute("user", user);
	    		  }
	    		 
	    	      out.print("3");
	    	      }
	    	  
	      }
	     
	      out.close();
		  return null;
	}
	public String login() throws IOException{
		 HttpServletRequest request=ServletActionContext.getRequest();
		 limit=(String) request.getSession().getAttribute("limit");
		 user=(TbUser) request.getSession().getAttribute("user");
		return "success";
	}
}
