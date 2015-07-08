package service;

import dao.GetStateById;
import dao.ModifyMeetingRoom;
import model.TbMeetingRoom;

public class ModifyMeetingRoomServiceImpl implements ModifyMeetingRoomService {

	private ModifyMeetingRoom ModifyMeetingRoom;
	private GetStateById temp;
	@Override
	public void modifyS(int state,int number,int personlimit,int id) {
		// TODO Auto-generated method stub
		
		
		TbMeetingRoom room = new TbMeetingRoom(temp.GetState(state), number, personlimit);
		room.setId(id);
		ModifyMeetingRoom.modify(room);

	}
	public ModifyMeetingRoom getModifyMeetingRoom() {
		return ModifyMeetingRoom;
	}
	public void setModifyMeetingRoom(ModifyMeetingRoom modifyMeetingRoom) {
		ModifyMeetingRoom = modifyMeetingRoom;
	}
	public GetStateById getTemp() {
		return temp;
	}
	public void setTemp(GetStateById temp) {
		this.temp = temp;
	}

}
