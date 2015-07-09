package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import model.TbDepartment;
import model.TbNoticeInteraction;
import model.TbUser;

public class SaveMeetingRoomImpl implements SaveMeetingRoom{

	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public void save(TbDepartment department) {
		// TODO Auto-generated method stub
		//List<TbNoticeInteraction> list= new ArrayList<TbNoticeInteraction>();
		TbNoticeInteraction interaction  = new TbNoticeInteraction();
		TbUser tbUser = new TbUser();
		tbUser = (TbUser) hibernateTemplate.find("from TbUser where id=1").get(0);
		interaction.setTbUserByToUserId(tbUser);
		List<TbNoticeInteraction> listlist = hibernateTemplate.findByExample(interaction);
		System.out.println("1111");
	}

}
