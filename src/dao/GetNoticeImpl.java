package dao;

import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import model.TbNoticeInteraction;

public class GetNoticeImpl implements GetNotice {

	private HibernateTemplate hibernateTemplate;
	@Override
	public ArrayList<TbNoticeInteraction> getNotice(int id) {
		// TODO Auto-generated method stub
		
		ArrayList<TbNoticeInteraction> list= new ArrayList<TbNoticeInteraction>();
		list = (ArrayList<TbNoticeInteraction>) hibernateTemplate.find("from TbNoticeInteraction as a inner join fetch a.tbUserByToUserId where a.tbUserByToUserId.id=1 ");
		return list;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
