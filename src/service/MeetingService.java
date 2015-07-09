package service;

import java.util.Date;
import java.util.List;

import model.TbMeeting;
import model.TbMeetingState;
import model.TbMeetingUser;
import model.TbUser;

public interface MeetingService {
	TbMeeting saveMeeting(TbMeeting meeting);
	TbMeeting getTheLastMeeting();
	TbMeeting serachMeeting(int id);
	void createNewMeetingUser(TbMeeting tbMeeting,String[] userId);
	TbUser serachUser(int id);
	List<TbMeeting> serachOwnMeeting(TbUser user);
	List<TbMeeting> serachOwnMeeting(TbUser user, int state);
	List<TbMeeting> serachJoinMeeting(TbUser user);
	List<TbMeeting> serachWaitMeeting();
	List<TbMeeting> serachMatchMeeting(Date meetingDate);
	List<TbUser> serachAllUser();
	List<TbUser> searchInvitedUser(TbMeeting meeting);
	void changeMeetingState(TbMeeting meeting,TbMeetingState state);
	TbMeetingState serachMeetingState(int id);
}
