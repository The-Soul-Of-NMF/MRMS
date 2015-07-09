package service;

import java.util.List;

import model.TbUser;
import model.TbUserApplication;

public interface UserService {
public void saveUser(String name,String password,String gender,String department,String email,long tel);
public List queryUserApplication();
public void saveUser(int id);
public void deletUserApplication(int id);
public List queryUser(String name,String password);
public void updateUser(int id,String password,String email,long phone);
public List queryDepartment();
public List queryTbUser();
public void updateTbUser(int id,String department,String work);
int promote(int id);
}
