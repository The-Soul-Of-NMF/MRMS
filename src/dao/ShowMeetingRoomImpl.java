package dao;

import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import model.TbMeeting;

public class ShowMeetingRoomImpl implements ShowMeetingRoom {

	private HibernateTemplate hibernateTemplate;
	@Override
	public ArrayList<TbMeeting> getMeetingRoom() {
		// TODO Auto-generated method stub
		return (ArrayList<TbMeeting>) hibernateTemplate.find("from TbMeetingRoom as a inner join fetch a.tbMeetingRoomState");
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
