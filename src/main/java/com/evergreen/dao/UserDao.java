package com.evergreen.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import com.evergreen.entities.Tbl_UserDetail;

public class UserDao extends JpaDao<Tbl_UserDetail> implements GenericDao<Tbl_UserDetail> {
	protected Session session;
	public UserDao(Session session) {
		super(session);
		this.session = session;
	}

	public Tbl_UserDetail create(Tbl_UserDetail users) {
		return super.create(users);
	}
	
	@Override
	public Tbl_UserDetail update(Tbl_UserDetail users) {
		return super.update(users);
	}

	@Override
	public Tbl_UserDetail get(Object userid) {
		return super.find(Tbl_UserDetail.class, userid);
	}

	@Override
	public void delete(Object userid) {
		super.delete(Tbl_UserDetail.class, userid);		
	}

	@Override
	public List<Tbl_UserDetail> listAll() {
		return super.findWithNamedQuery("Tbl_UserDetail.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Tbl_UserDetail.countAll");
	}

	@Override
	public Tbl_UserDetail findByEmail(String email) {
		List<Tbl_UserDetail> listUsers = super.findWithNamedQuery("Tbl_UserDetail.findByEmail","email", email);
		if(listUsers != null && listUsers.size() > 0) {
			return listUsers.get(0);
		}
		return null;
	}
	
	public boolean checkLogin(String email, String password) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("email", email);
		parameters.put("password", password);
		List<Tbl_UserDetail> listUser = super.findWithNamedQuery("Tbl_UserDetail.checkLogin", parameters);
		if(listUser.size() == 1) {
			return true;
		}
		return false;
	}
}
