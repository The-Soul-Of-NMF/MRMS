package dao;

import java.util.List;

import model.TbDepartment;
import model.TbUser;

public interface DeparDao {
	
	TbDepartment insert(TbDepartment depar);
	TbDepartment update(TbDepartment depar);
	void update_depar_name(String name,int current_id);
	
	List<TbDepartment> show();
	List show_user();
	List show_user_by_id(int depar_id);
	List show_user_by_num(int left_num,int right_num);
	List show_user_by_member(String depar_member);
	int[] member_in_depar_id(String depar_member);
	
	List<TbDepartment> query_depar_by_id(Integer depar_id);
	List<TbDepartment> query_depar_by_num(Integer left_num,Integer right_num);
	List<TbDepartment> query_depar_by_member(String depar_member);
	
	List<TbDepartment> get_current_depar(int current_id);
	void delete_depar(int current_id);
	int check_delete(int current_id);
}
