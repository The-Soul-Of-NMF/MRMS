package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ModifyAction extends ActionSupport {

	private String ID;
	public String execute() {
		/*��������������
		�����ߩ��������ߩ�
		������������������ ��
		������������������
		�����ש������ס���
		��������     ��������
		��                                   ��
		����������               ��
		���������ߡ�������
		������������������
		������������������
		          ����������   ���ޱ��ӡ�
		          ����������   ������BUG��
		          ������������������������
		          ��                                                  ��
		          ��                                                  ��
		          ������          ����               ���ǩ�����
		          ����������������               ��������
		          �����������������ש�����
		               ������                    ������
		               ���ϩϡ�               ���ϩ�
		               ���ߩ���               ���ߩ�*/
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
