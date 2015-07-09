package service;

import java.util.List;

import model.TbDepartment;
import model.TbUser;

public interface DeparService {

	TbDepartment saveTbDepartment(TbDepartment depar);
	TbDepartment updateTbDepartment(TbDepartment depar);
	void update_depar_name(String name,int current_id);
	
	List<TbDepartment> showTbDepartment();
	List showTbUser();
	List showTbUserById(int depar_id);
	List showTbUserByNum(int left_num,int right_num);
	List showTbUserByMember(String depar_member);
	
	void delete_depar(int current_id);
	int check_delete(int current_id);
	
	List<TbDepartment> query_depar_by_id(Integer depar_id);
	List<TbDepartment> query_depar_by_num(Integer left_num,Integer right_num);
	List<TbDepartment> query_depar_by_member(String depar_member);
	
	List<TbDepartment> getCurrentDepar(int id);
}
