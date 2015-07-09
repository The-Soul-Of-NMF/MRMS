package service;

import java.util.List;

import dao.DeparDao;
import model.TbDepartment;
import model.TbUser;

public class DeparServiceImpl implements DeparService{

	private DeparDao deparDao;
	
	public DeparDao getDeparDao() {
		return deparDao;
	}

	public void setDeparDao(DeparDao deparDao) {
		this.deparDao = deparDao;
	}

	public TbDepartment saveTbDepartment(TbDepartment depar){
		return deparDao.insert(depar);
	}

	@Override
	public TbDepartment updateTbDepartment(TbDepartment depar) {
		return deparDao.update(depar);
	}

	@Override
	public List<TbDepartment> showTbDepartment() {	
		return deparDao.show();
	}
	
	@Override
	public List showTbUser() {
		return deparDao.show_user();
	}
	
	@Override
	public List showTbUserById(int depar_id) {
		return deparDao.show_user_by_id(depar_id);
	}
	
	@Override
	public List showTbUserByNum(int left_num, int right_num) {
		return deparDao.show_user_by_num(left_num, right_num);
	}
	
	@Override
	public List showTbUserByMember(String depar_member) {
		return deparDao.show_user_by_member(depar_member);
	}
	
	@Override
	public List<TbDepartment> getCurrentDepar(int current_id) {
		return deparDao.get_current_depar(current_id);
	}

	@Override
	public void update_depar_name(String name, int current_id) {
		deparDao.update_depar_name(name, current_id);
		
	}

	@Override
	public void delete_depar(int current_id) {
		deparDao.delete_depar(current_id);
	}

	@Override
	public int check_delete(int current_id) {
		return deparDao.check_delete(current_id);
	}

	@Override
	public List<TbDepartment> query_depar_by_id(Integer depar_id) {
		return deparDao.query_depar_by_id(depar_id);
	}

	@Override
	public List<TbDepartment> query_depar_by_num(Integer left_num,
			Integer right_num) {
		return deparDao.query_depar_by_num(left_num, right_num);
	}

	@Override
	public List<TbDepartment> query_depar_by_member(String depar_member) {
		return deparDao.query_depar_by_member(depar_member);
	}

}