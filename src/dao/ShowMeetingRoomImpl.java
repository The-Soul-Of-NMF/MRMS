package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import model.TbMeeting;
import model.TbMeetingRoom;

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
	@Override
	public List<TbMeetingRoom> getMeetingRoom(int minSize) {
		return hibernateTemplate.find("from TbMeetingRoom as r inner join fetch r.tbMeetingRoomState where r.personLimit >= "+ minSize);
	}

}
