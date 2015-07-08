package service;

import dao.SaveMeetingRoom;
import model.TbDepartment;

public class SaveMeetingRoomServiceImpl implements SaveMeetingRoomService {

	private SaveMeetingRoom saveDepartment;
	public SaveMeetingRoom getSaveDepartment() {
		return saveDepartment;
	}
	public void setSaveDepartment(SaveMeetingRoom saveDepartment) {
		this.saveDepartment = saveDepartment;
	}
	@Override
	public void Save(TbDepartment department) {
		// TODO Auto-generated method stub
		saveDepartment.save(department);

	}

}
