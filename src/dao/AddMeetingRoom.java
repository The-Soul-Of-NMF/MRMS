package dao;

import model.TbMeetingRoom;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate3.HibernateTemplate;

public interface AddMeetingRoom {
	
	public void addMeeting(TbMeetingRoom room);

}
