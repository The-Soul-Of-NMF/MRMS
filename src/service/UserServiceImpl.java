package service;
import java.util.List;

import model.TbDepartment;
import model.TbUser;
import model.TbUserApplication;
import dao.UserDao;

public class UserServiceImpl implements UserService{
	private UserDao userdao;
	private TbUserApplication tbuserapplication;
	
	public TbUserApplication getTbuserapplication() {
		return tbuserapplication;
	}

	public void setTbuserapplication(TbUserApplication tbuserapplication) {
		this.tbuserapplication = tbuserapplication;
	}

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	public void saveUser(String name,String password,String gender,String department,String email,long tel){
		tbuserapplication=new TbUserApplication();
		tbuserapplication.setName(name);
		tbuserapplication.setPassword(password);
		if(gender.equals("ÄÐ")){
			tbuserapplication.setGender(true);
		}
		else{
			tbuserapplication.setGender(false);
		}
		tbuserapplication.setEmail(email);
		tbuserapplication.setPhone(tel);
		tbuserapplication.setTbDepartment((TbDepartment)userdao.loadTbDepartment(department).get(0));
		userdao.addUser(tbuserapplication);
	}
	public List queryUserApplication(){
		return (List)userdao.queryUserApplication();
	}
	public void saveUser(int id) {
		TbUserApplication userapplication=new TbUserApplication();
		TbUser user=new TbUser();
		userapplication=userdao.queryUserApplication(id);
		user.setId(userapplication.getId());
		user.setName(userapplication.getName());
		user.setPassword(userapplication.getPassword());
		user.setGender(userapplication.getGender());
		user.setTbDepartment(userapplication.getTbDepartment());
		user.setPhone(userapplication.getPhone());
		user.setEmail(userapplication.getEmail());
		user.setWorkingState(true);
		user.setIconName("gongfu.jpg");
		userdao.saveUser(user);
	}

	public void deletUserApplication(int id) {
		TbUserApplication userapplication=new TbUserApplication();
		userapplication=userdao.queryUserApplication(id);
		userdao.deletUserApplication(userapplication);
	}

	@Override
	public List queryUser(String name,String password) {
		int id=Integer.parseInt(name);
		return (List)userdao.queryUser(id,password);
	}

	@Override
	public void updateUser(int id,String password,String email,long phone) {
		TbUser user=new TbUser();
		user=userdao.queryUser(id);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		userdao.update(user);
	}

	@Override
	public List queryDepartment() {
		return userdao.queryDepartment();
	}

	@Override
	public List queryTbUser() {
		return userdao.queryUser();
	}

	@Override
	public void updateTbUser(int id,String department,String work) {
		TbUser user=new TbUser();
		user=userdao.queryUser(id);
		user.setTbDepartment((TbDepartment)userdao.loadTbDepartment(department).get(0));
		if(work.equals("ÔÚÖ°")){
			user.setWorkingState(true);
		}
		else{
			user.setWorkingState(false);
		}
		userdao.updatesave(user);
		
	}
	public int promote(int id) {
		return userdao.promote(id);
	}
	
}
