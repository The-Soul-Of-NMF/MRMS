package service;

import java.util.Date;
import java.util.List;

import dao.MeetingDao;
import model.TbMeeting;
import model.TbMeetingRoom;
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

	public TbMeetingUser createNewMeetingUser(TbMeetingUser meetingUser) {
		return meetingDao.createNewMeetingUser(meetingUser);
	}
	@Override
	public TbMeeting getTheLastMeeting() {
		return meetingDao.getTheLastMeeting();
	}
	@Override
	public TbUser serachUser(int id) {
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
		return meetingDao.serachAllUser();
	}
	@Override
	public List<TbMeeting> serachWaitMeeting() {
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
	@Override
	public void createNewMeetingUser(TbMeeting tbMeeting, String[] userId) {
		for(String u:userId){
			TbMeetingUser meetingUser=new TbMeetingUser();
			meetingUser.setTbMeeting(tbMeeting);
			meetingUser.setTbUser(meetingDao.serachUser(Integer.parseInt(u)));
			meetingDao.createNewMeetingUser(meetingUser);
		}
	}
	@Override
	public TbMeetingState serachMeetingState(int id) {
		// TODO Auto-generated method stub
		return meetingDao.serachMeetingState(id);
	}
	@Override
	public List<TbUser> searchInvitedUser(TbMeeting meeting) {
		return meetingDao.searchInvitedUser(meeting);
	}
	public List<TbMeeting> serachOwnMeeting(TbUser user, int state) {
		return meetingDao.serachOwnMeeting(user, state);
	}
	@Override
	public List<TbMeeting> serachMatchMeeting(Date meetingDate) {
		return meetingDao.serachMatchMeeting(meetingDate);
	}
	@Override
	public List<TbMeeting> serachMatchMeeting(Date meetingDate,
			int roomId) {
		return meetingDao.serachMatchMeeting(meetingDate, roomId);
	}
	@Override
	public void updateMeeting(TbMeeting meeting) {
		meetingDao.updateMeeting(meeting);
		
	}
	@Override
	public TbMeetingState getMeetingState(int stateId) {
		return meetingDao.getMeetingState(stateId);
	}
	@Override
	public TbMeetingRoom searchMeetingRoom(int roomId) {
		return meetingDao.getMeetingRoom(roomId);
	}
	
}
