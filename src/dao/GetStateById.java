package dao;

import model.TbMeetingRoomState;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class GetStateById {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public TbMeetingRoomState GetState(int id)
	{
		TbMeetingRoomState state = new TbMeetingRoomState();
		state = (TbMeetingRoomState) hibernateTemplate.find("from TbMeetingRoomState where id="+id).get(0);
		return state;
		
	}

}
