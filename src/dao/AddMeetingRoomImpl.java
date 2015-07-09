package dao;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import model.TbMeetingRoom;

public class AddMeetingRoomImpl implements AddMeetingRoom {

	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public void addMeeting(TbMeetingRoom room) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(room);

	}

}
