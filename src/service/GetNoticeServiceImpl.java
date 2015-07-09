package service;

import java.util.ArrayList;

import dao.GetNotice;
import model.TbNoticeInteraction;

public class GetNoticeServiceImpl implements GetNoticeService {

	private GetNotice GetNotice;
	@Override
	public ArrayList<TbNoticeInteraction> getNoticeS(int id) {
		// TODO Auto-generated method stub
		return GetNotice.getNotice(id);
	}
	public GetNotice getGetNotice() {
		return GetNotice;
	}
	public void setGetNotice(GetNotice getNotice) {
		GetNotice = getNotice;
	}

}
