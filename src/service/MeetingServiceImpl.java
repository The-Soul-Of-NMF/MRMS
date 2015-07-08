package service;

import java.util.List;

import dao.MeetingDao;
import model.TbMeeting;
import model.TbMeetingState;
import model.TbMeetingUser;
import model.TbUser;

public class MeetingServiceImpl implements MeetingService {
	private MeetingDao meetingDao;
	@Override
	public TbMeeting saveMeeting(TbMeeting meeting) {
		
		return meetingDao.saveMeeting(meeting);
	}
	public MeetingDao getMeetingDao() {
		return meetingDao;
	}
	public void setMeetingDao(MeetingDao meetingDao) {
		this.meetingDao = meetingDao;
	}
	@Override
	public TbMeetingUser createNewMeetingUser(TbMeetingUser meetingUser) {
		// TODO Auto-generated method stub
		return meetingDao.createNewMeetingUser(meetingUser);
	}
	@Override
	public TbMeeting getTheLastMeeting() {
		// TODO Auto-generated method stub
		return meetingDao.getTheLastMeeting();
	}
	@Override
	public TbUser serachUser(int id) {
		// TODO Auto-generated method stub
		return meetingDao.serachUser(id);
	}
	@Override
	public List<TbMeeting> serachOwnMeeting(TbUser user) {
		return meetingDao.serachOwnMeeting(user);
	}
	@Override
	public List<TbMeeting> serachJoinMeeting(TbUser user) {
		return meetingDao.serachJoinMeeting(user);
	}
	@Override
	public List<TbUser> serachAllUser() {
		// TODO Auto-generated method stub
		return meetingDao.serachAllUser();
	}
	@Override
	public List<TbMeeting> serachWaitMeeting() {
		// TODO Auto-generated method stub
		return meetingDao.serachWaitMeeting();
	}
	@Override
	public void changeMeetingState(TbMeeting meeting, TbMeetingState state) {
		meetingDao.changeMeetingState(meeting, state);
		
	}
	@Override
	public TbMeeting serachMeeting(int id) {
		return meetingDao.serachMeeting(id);
	}
	
}
