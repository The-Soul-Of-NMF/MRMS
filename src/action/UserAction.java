package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import model.TbDepartment;
import model.TbUserApplication;
import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
private String name;
private String password;
private String gender;
private String department;
private String email;
private long tel;
private UserService userservice;
private List tbdepartment;

public List getTbdepartment() {
	return tbdepartment;
}
public void setTbdepartment(List tbdepartment) {
	this.tbdepartment = tbdepartment;
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
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getTel() {
	return tel;
}
public void setTel(long tel) {
	this.tel = tel;
}

public UserService getUserservice() {
	return userservice;
}
public void setUserservice(UserService userservice) {
	this.userservice = userservice;
}
public String reg(){
	 HttpServletRequest request=ServletActionContext.getRequest();
	 tbdepartment=userservice.queryDepartment();
	 request.getSession().setAttribute("department",  tbdepartment);
	return "success";
}
public String register(){
	  userservice.saveUser(name, password, gender, department, email, tel);
	return "success";
}
public String registercheck() throws IOException{
	  HttpServletRequest request=ServletActionContext.getRequest();
      HttpServletResponse response=ServletActionContext.getResponse();
      PrintWriter out=response.getWriter();
      String name=request.getParameter("username");
      String password=request.getParameter("userpassword");
      String ensurepassword=request.getParameter("userensurepassword");
      String gender=request.getParameter("usergender");
      String email=request.getParameter("useremail");
      String tel=request.getParameter("usertel");
      String department=request.getParameter("userdepartment");
	 if(name.equals("")||password.equals("")||ensurepassword.equals("")||gender.equals("")||department.equals("")||email.equals("")||tel.equals("")){
		out.print("1");
	}
	else if(!password.equals(ensurepassword))
    {
		out.print("2");
    }
	else{
		out.print("3");
	}
	 out.close();
	 return null;
}
public String promote() throws IOException{
	HttpServletRequest rq=ServletActionContext.getRequest();
	int id=Integer.parseInt(rq.getParameter("id"));
	
	HttpServletResponse res=ServletActionContext.getResponse();
	PrintWriter out=res.getWriter();
	
	if(userservice.promote(id)==-1){
		out.print("-1");
	}else{
		out.print("1");
	}
	
	return null;
}
}
