package dao;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import model.TbMeetingRoom;

public class ModifyMeetingRoomImpl implements ModifyMeetingRoom {

	private HibernateTemplate hibernateTemplate;
	@Override
	public void modify(TbMeetingRoom room) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(room);

	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
