package dao;

import java.util.Date;
import java.util.List;

import model.TbMeeting;
import model.TbMeetingState;
import model.TbMeetingUser;
import model.TbUser;

public interface MeetingDao {
	TbMeeting saveMeeting(TbMeeting meeting);
	TbMeeting serachMeeting(int id);
	TbMeeting getTheLastMeeting();
	TbMeetingUser createNewMeetingUser(TbMeetingUser meetingUser);
	TbUser serachUser(int id);
	List<TbMeeting> serachOwnMeeting(TbUser user);
	List<TbMeeting> serachOwnMeeting(TbUser user, int state);
	List<TbMeeting> serachJoinMeeting(TbUser user);
	List<TbMeeting> serachWaitMeeting();
	List<TbMeeting> serachMatchMeeting(Date meetingDate);
	List<TbUser> serachAllUser();
	List<TbUser> searchInvitedUser(TbMeeting meeting);
	TbMeeting changeMeetingState(TbMeeting meeting,TbMeetingState state);
	TbMeetingState serachMeetingState(int id);
}
