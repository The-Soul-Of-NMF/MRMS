package dao;

import java.util.ArrayList;

import model.TbMeetingRoom;
import model.TbMeetingRoomState;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class DeleteMeetingRoomImpl implements DeleteMeetingRoom {

	private HibernateTemplate hibernateTemplate;
	@Override
	public void deleteRoom(int id) {
		// TODO Auto-generated method stub
		TbMeetingRoom room = new TbMeetingRoom();
		room = (TbMeetingRoom)hibernateTemplate.find("from TbMeetingRoom where id="+id).get(0);
		TbMeetingRoomState tem = (TbMeetingRoomState) hibernateTemplate.find("from TbMeetingRoomState where id=3").get(0);
		room.setTbMeetingRoomState(tem);
		hibernateTemplate.update(room);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
