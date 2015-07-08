package dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import model.TbMeeting;
import model.TbMeetingState;
import model.TbMeetingUser;
import model.TbUser;

public class MeetingDaoImpl implements MeetingDao {
	private HibernateTemplate hibernateTemplate;
	@Override
	public TbMeeting saveMeeting(TbMeeting meeting) {
		hibernateTemplate.save(meeting);
		return meeting;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public TbMeetingUser createNewMeetingUser(TbMeetingUser meetingUser) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(meetingUser);
		return meetingUser;
	}
	@Override
	public TbMeeting getTheLastMeeting() {
		String hql="from TbMeeting where id=(select max(id) from TbMeeting)";
		@SuppressWarnings("rawtypes")
		List meetinglist=null;
		meetinglist=this.hibernateTemplate.find(hql);
		if(meetinglist==null){
			return null;
		}
		return (TbMeeting)meetinglist.get(0);
	}
	@Override
	public TbUser serachUser(int id) {
		@SuppressWarnings("unchecked")
		List<TbUser> User=this.hibernateTemplate.find("from TbUser where id="+id);
		if(User==null)
			return null;
		return (TbUser)User.get(0);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TbMeeting> serachOwnMeeting(TbUser user) {
		String hql="from TbMeeting as s where s.tbUser.id="+user.getId();
		return this.hibernateTemplate.find(hql);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TbMeeting> serachJoinMeeting(TbUser user) {
		String hql="from TbMeeting as s left outer join fetch s.tbMeetingUsers as b "
				+ "where b.tbUser.id="+user.getId();
		return this.hibernateTemplate.find(hql);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TbUser> serachAllUser() {
		String hql="from TbUser as s where s.workingState=0";
		return this.hibernateTemplate.find(hql);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TbMeeting> serachWaitMeeting() {
		String hql="from TbMeeting m inner join fetch m.tbUser where m.tbMeetingState.id=1";
		return this.hibernateTemplate.find(hql);
	}
	@Override
	public void changeMeetingState(TbMeeting meeting, TbMeetingState state) {
		meeting.setTbMeetingState(state);
		hibernateTemplate.update(meeting);
	}
	@Override
	public TbMeeting serachMeeting(int id) {
		String hql="from TbMeeting m where m.id="+id;
		return (TbMeeting)hibernateTemplate.find(hql).get(0);
	}

}
