package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ModifyAction extends ActionSupport {

	private String ID;
	public String execute() {
		/*┏┓　　　┏┓
		┏┛┻━━━┛┻┓
		┃　　　　　　　┃ 　
		┃　　　━　　　┃
		┃　┳┛　┗┳　┃
		┃【┃】     【┃】┃
		┃                                   ┃
		┃　　　┃               ┃
		┃　　　┻　　　┃
		┃　　　　　　　┃
		┗━┓　　　┏━┛
		          ┃　　　┃   神兽保佑　
		          ┃　　　┃   代码无BUG！
		          ┃　　　┗━━━━━━┓
		          ┃                                                  ┃
		          ┃                                                  ┃
		          ┃　　          　　               　┣━━┓
		          ┃　　　　　　　               ┏━━┛
		          ┗┓┓┏━━━━┳┓┏┛
		               ┃┃┃                    ┃┃┃
		               ┃┫┫　               ┃┫┫
		               ┗┻┛　               ┗┻┛*/
		HttpServletRequest request=ServletActionContext.getRequest();
		setID(request.getParameter("current_id")); 
		return "moditrans";
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
}
