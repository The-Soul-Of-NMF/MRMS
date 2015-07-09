package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import model.TbDepartment;
import model.TbUser;
import service.DeparService;

public class deparManaAction extends ActionSupport{
	
	private DeparService deparService;
	private TbDepartment depar=new TbDepartment();
	private List<TbDepartment> all_depar;
	private List user;
	public List getUser() {
		return user;
	}
	public void setUser(List user) {
		this.user = user;
	}

	private List<TbUser> depar_employee;
	private List<TbDepartment> current_depar;
	public List<TbDepartment> getCurrent_depar() {
		return current_depar;
	}
	public void setCurrent_depar(List<TbDepartment> current_depar) {
		this.current_depar = current_depar;
	}

	public List<TbUser> getDepar_employee() {
		return depar_employee;
	}
	public void setDepar_employee(List<TbUser> depar_employee) {
		this.depar_employee = depar_employee;
	}
	public List<TbDepartment> getAll_depar() {
		return all_depar;
	}
	public void setAll_depar(List<TbDepartment> all_depar) {
		this.all_depar = all_depar;
	}
	public DeparService getDeparService() {
		return deparService;
	}
	public void setDeparService(DeparService deparService) {
		this.deparService = deparService;
	}
	public TbDepartment getDepar() {
		return depar;
	}
	public void setDepar(TbDepartment depar) {
		this.depar = depar;
	}
	//修改部门名称
	public String modify_depar_name(){
		HttpServletRequest rq=ServletActionContext.getRequest();
		String name=rq.getParameter("name");
		int current_id=Integer.parseInt(rq.getParameter("current_id"));
		deparService.update_depar_name(name, current_id);
		all_depar=deparService.showTbDepartment();
		
		return "success";
	}
	//添加新部门
	public String add_depar(){
		HttpServletRequest rq=ServletActionContext.getRequest();
		String name=rq.getParameter("name");
		depar.setName(name);
		depar.setTotalNumber(10);
		depar.setState(true);
		deparService.saveTbDepartment(depar);
		all_depar=deparService.showTbDepartment();
		
		return "success";
	}
	
	public String show_depar(){
		all_depar=deparService.showTbDepartment();
		user=deparService.showTbUser();
		
		return "success";
	}
	
	public String get_current_depar(){
		HttpServletRequest rq=ServletActionContext.getRequest();
		int current_id=Integer.parseInt(rq.getParameter("current_id"));
		current_depar=deparService.getCurrentDepar(current_id);
		
		return "success";
	}
	
	public String delete_depar(){
		HttpServletRequest rq=ServletActionContext.getRequest();
		int current_id=Integer.parseInt(rq.getParameter("current_id"));
		deparService.delete_depar(current_id);
		all_depar=deparService.showTbDepartment();
		
		return "success";
	}
	
	public String check_delete() throws IOException{
		HttpServletRequest rq=ServletActionContext.getRequest();
		int current_id=Integer.parseInt(rq.getParameter("current_id"));
		int can_delete=deparService.check_delete(current_id);
		
		HttpServletResponse response=ServletActionContext.getResponse();
		PrintWriter out=response.getWriter();
		if(can_delete==1){
			out.print("1");
		}else{
			out.print("-1");
		}
		
		return null;
	}
	
	public String query_depar_by_id(){
		HttpServletRequest rq=ServletActionContext.getRequest();
		Integer depar_id=Integer.parseInt(rq.getParameter("depar_id"));
		
		all_depar=deparService.query_depar_by_id(depar_id);
		user=deparService.showTbUserById(depar_id);
			
		return "success";
	}
	
	public String query_depar_by_num(){
		HttpServletRequest rq=ServletActionContext.getRequest();
		Integer left_num=Integer.parseInt(rq.getParameter("left_num"));
		Integer right_num=Integer.parseInt(rq.getParameter("right_num"));
		
		all_depar=deparService.query_depar_by_num(left_num, right_num);
		user=deparService.showTbUserByNum(left_num, right_num);
		
		return "success";
	}
	
	public String query_depar_by_member(){
		HttpServletRequest rq=ServletActionContext.getRequest();
		String depar_member=rq.getParameter("depar_member");
		
		all_depar=deparService.query_depar_by_member(depar_member);
		user=deparService.showTbUserByMember(depar_member);
		
		return "success";
	}
}
