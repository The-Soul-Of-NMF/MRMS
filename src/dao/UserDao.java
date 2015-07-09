package dao;

import java.util.List;

import model.TbDepartment;
import model.TbUser;
import model.TbUserApplication;

public interface UserDao {
public void addUser(TbUserApplication tbuserapplication);
public List loadTbDepartment(String name);
public List queryUserApplication();
public void deletUserApplication(TbUserApplication tbuserapplication);
public void saveUser(TbUser user);
public TbUserApplication queryUserApplication(int id);
public List queryUser(int id,String password);
public void update(TbUser user);
public TbUser queryUser(int id);
public List queryDepartment();
public List queryUser();
public void updatesave(TbUser user);
int promote(int id);
}
