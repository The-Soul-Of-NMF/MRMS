package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ModifyAction extends ActionSupport {

	private String ID;
	private String door_num;
	private String person_limit;
	public String execute() {
		HttpServletRequest request=ServletActionContext.getRequest();
		setID(request.getParameter("current_id")); 
		door_num = request.getParameter("door_num");
		person_limit = request.getParameter("person_limit");
		return "moditrans";
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getDoor_num() {
		return door_num;
	}
	public void setDoor_num(String door_num) {
		this.door_num = door_num;
	}
	public String getPerson_limit() {
		return person_limit;
	}
	public void setPerson_limit(String person_limit) {
		this.person_limit = person_limit;
	}
}
