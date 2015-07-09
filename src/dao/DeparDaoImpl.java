package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import model.TbDepartment;
import model.TbUser;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class DeparDaoImpl implements DeparDao{

	private HibernateTemplate hibernateTemplate;
	private static SessionFactory sf=null;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public TbDepartment insert(TbDepartment depar){
		hibernateTemplate.save(depar);
		return depar;
	}

	public TbDepartment update(TbDepartment depar) {
		return depar;
	}

	public void update_depar_name(String name,int current_id){
		sf=new Configuration().configure().buildSessionFactory();
		Session session=null;
		session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("update TbDepartment set name='"+name+"' where id="+current_id);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public List<TbDepartment> show() {
		List<TbDepartment> depar_list=hibernateTemplate.find("from TbDepartment order by id");
		
		return depar_list;
	}
	
	public List<TbUser> show_user() {
		List user_list=new ArrayList<>();
		
		List<TbDepartment> query_id=hibernateTemplate.find("from TbDepartment");
		for(int i=0;i<query_id.size();i++){
			int depar_id=query_id.get(i).getId();
			
			List<TbUser> query_user=hibernateTemplate.find("select name from TbUser as u where u.tbDepartment.id "
				+ "= "+depar_id);
			
			user_list.add(query_user);
		}
		
		return user_list;
	}

	@Override
	public List show_user_by_id(int depar_id) {
		List user_list=new ArrayList<>();
		List<TbUser> query_user=hibernateTemplate.find("from TbUser where tbDepartment.id "
				+ "= "+depar_id);
		String user_name="";
		
		for(int i=0;i<query_user.size();i++){
			user_name+=query_user.get(i).getName();
		}
		user_list.add(user_name);
		
		System.out.println(user_list.size());
		System.out.println(user_list.get(0));
		
		return user_list;
	}
	
	@Override
	public List show_user_by_num(int left_num, int right_num) {
		List user_list=new ArrayList<>();
		
		List<TbDepartment> query_id=hibernateTemplate.find("from TbDepartment where totalNumber between "
				+left_num+" and "+right_num+"");
		for(int i=0;i<query_id.size();i++){
			int depar_id=query_id.get(i).getId();
			
			List<TbUser> query_user=hibernateTemplate.find("select name from TbUser as u where u.tbDepartment.id "
				+ "= "+depar_id);
			
			user_list.add(query_user);
		}
		
		return user_list;
	}
	
	@Override
	public int[] member_in_depar_id(String depar_member) {
		int[] id=null;
		int hasMember=0;
		
		List<TbDepartment> query_id=hibernateTemplate.find("from TbDepartment");
		for(int i=0;i<query_id.size();i++){
			int depar_id=query_id.get(i).getId();
			
			List<TbUser> query_user=hibernateTemplate.find("select name from TbUser as u where u.tbDepartment.id "
				+ "= "+depar_id);
			for(int k=0;k<query_user.size();k++){
				if(query_user.get(k).getName().equals(depar_member)){
					hasMember++;
				}
			}
			if(hasMember!=0){
				id[id.length]=depar_id;
			}
		}
		
		return id;
	}
	
	@Override
	public List show_user_by_member(String depar_member) {
		List user_list=new ArrayList<>();
		int hasMember=0;
		
		List<TbDepartment> query_id=hibernateTemplate.find("from TbDepartment");
		for(int i=0;i<query_id.size();i++){
			int depar_id=query_id.get(i).getId();
			
			List<TbUser> query_user=hibernateTemplate.find("select name from TbUser as u where u.tbDepartment.id "
				+ "= "+depar_id);
			for(int k=0;k<query_user.size();k++){
				if(query_user.get(k).getName().equals(depar_member)){
					hasMember++;
				}
			}
			if(hasMember!=0){
				user_list.add(query_user);
			}
		}
		
		return user_list;
	}
	
	@Override
	public List<TbDepartment> get_current_depar(int current_id) {
		List<TbDepartment> current_depar= hibernateTemplate.find("from TbDepartment where id ='"+current_id+"'");
		
		return current_depar;
	}

	@Override
	public void delete_depar(int current_id) {
			sf=new Configuration().configure().buildSessionFactory();
			Session session=null;
			session=sf.openSession();
			session.beginTransaction();
			Query query=session.createQuery("delete TbDepartment where id = '"+current_id+"'");
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
	}
	
	public int check_delete(int current_id){
		int can_delete;
		
		if(hibernateTemplate.find("from TbUser where department_id = '"+current_id+"'").size()==0){
			can_delete=1;
		}else{
			can_delete=-1;
		}
		
		return can_delete;
	}

	@Override
	public List<TbDepartment> query_depar_by_id(Integer depar_id) {
		@SuppressWarnings("unchecked")
		List<TbDepartment> query_list=hibernateTemplate.find("from TbDepartment where id = "+depar_id);
		return query_list;
	}

	@Override
	public List<TbDepartment> query_depar_by_num(Integer left_num,Integer right_num) {
		@SuppressWarnings("unchecked")
		List<TbDepartment> query_list=hibernateTemplate.find("from TbDepartment where totalNumber between "
				+left_num+" and "+right_num);
		return query_list;
	}

	@Override
	public List<TbDepartment> query_depar_by_member(String depar_member) {
		@SuppressWarnings("unchecked")
		List<TbDepartment> query_list=null;

		int[] id=this.member_in_depar_id(depar_member);
		for(int i=0;i<id.length;i++){
			List<TbDepartment> query_id=hibernateTemplate.find("from TbDepartment where id = "+id[i]);
			TbDepartment tbDepartment=(TbDepartment)query_id.get(i);
			
			query_list.add(tbDepartment);
		}
		
		return query_list;
	}

}