package service;

import java.util.List;

import model.TbMeeting;
import model.TbMeetingState;
import model.TbMeetingUser;
import model.TbUser;

public interface MeetingService {
	TbMeeting saveMeeting(TbMeeting meeting);
	TbMeeting getTheLastMeeting();
	TbMeeting serachMeeting(int id);
	TbMeetingUser createNewMeetingUser(TbMeetingUser meetingUser);
	TbUser serachUser(int id);
	List<TbMeeting> serachOwnMeeting(TbUser user);
	List<TbMeeting> serachJoinMeeting(TbUser user);
	List<TbMeeting> serachWaitMeeting();
	List<TbUser> serachAllUser();
	void changeMeetingState(TbMeeting meeting,TbMeetingState state);
}
