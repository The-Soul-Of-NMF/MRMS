package dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;

import model.TbAdmin;
import model.TbDepartment;
import model.TbUser;
import model.TbUserApplication;
import dao.UserDao;

public class UserDaoImpl implements UserDao {
	private HibernateTemplate hibernateTemplate;
	private static SessionFactory sf;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public void addUser(TbUserApplication tbuserapplication) {
		hibernateTemplate.save(tbuserapplication);
	}
	public SessionFactory getSessionFactory() {
		return sf;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sf;
	}
	public List loadTbDepartment(String name) {	
		return (List)hibernateTemplate.find("from TbDepartment u where u.name=?",name);
	}

	public List queryUserApplication() {
		return (List)hibernateTemplate.find("from TbUserApplication");
	}
    
	public TbUserApplication queryUserApplication(int id){
		return hibernateTemplate.get(TbUserApplication.class,id);
	}
	public void deletUserApplication(TbUserApplication tbuserapplication) {
		hibernateTemplate.delete(tbuserapplication);
	}
	public void saveUser(TbUser user) {
		hibernateTemplate.save(user);
	}
	public List queryUser(int id,String password) {
		return (List)hibernateTemplate.find("from TbUser where id=? and password=? and working_state=?",id,password,true);
	}

	@Override
	public void update(TbUser user) {
		hibernateTemplate.update(user);
		
	}

	@Override
	public TbUser queryUser(int id) {
		
		return hibernateTemplate.get(TbUser.class, id);
	}

	@Override
	public List queryDepartment() {
		return (List)hibernateTemplate.find("from TbDepartment");
	}

	@Override
	public List queryUser() {
		return (List)hibernateTemplate.find("from TbUser");
	}

	@Override
	public void updatesave(TbUser user) {
		hibernateTemplate.update(user);
		
	}
	public int promote(int id){
		int can_promote;
		
		if((hibernateTemplate.find("from TbUser where id = "+id)).size()==0){
			can_promote=-1;
		}else{
			if((hibernateTemplate.find("from TbAdmin as m where m.tbUser.id = "+id).size()==0)){
				List<TbUser> ad_list=hibernateTemplate.find("from TbUser where id = "+id);
				int depar_id=ad_list.get(0).getTbDepartment().getId();
				System.out.println(depar_id);
				//admin中创建一条记录
				TbAdmin admin=new TbAdmin();
				TbUser tbUser=(TbUser) hibernateTemplate.find("from TbUser where id = "+id).get(0);
				admin.setId(id);
				admin.setSuperAdmin(true);
				admin.setTbUser(tbUser);
				hibernateTemplate.save(admin);
				can_promote=1;
			}else{
				sf=new Configuration().configure().buildSessionFactory();
				Session session=sf.openSession();
				session.beginTransaction();
				Query query=session.createQuery("update TbAdmin m set superAdmin = true where m.tbUser.id = "+id);
				query.executeUpdate();
				session.getTransaction().commit();
				session.close();
				can_promote=1;
			}
		}
		
		return can_promote;
	}

}
