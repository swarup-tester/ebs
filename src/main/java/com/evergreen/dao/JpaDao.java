package com.evergreen.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.evergreen.utilities.*;

public class JpaDao<T> {
	Session session;
	Transaction tx;
	
	public JpaDao(Session session) {
		super();
		this.session = session;
	}

	public T create(T t) {
		this.session = HibernateHelper.getSessionFactory().openSession();
		this.tx = this.session.beginTransaction();
		this.session.save(t);
		this.session.flush();
		this.session.refresh(t);
		this.tx.commit();
		this.session.close();
		return t;
	}
	
	public List<T> findWithNamedQuery(String queryName){
		this.session = HibernateHelper.getSessionFactory().openSession();
		Query query = this.session.createNamedQuery(queryName);
		return query.getResultList();
	}
	
	public T update(T t) {
		this.session = HibernateHelper.getSessionFactory().openSession();
		this.tx = this.session.beginTransaction();
		this.session.merge(t);
		this.tx.commit();
		this.session.close();
		return t;
	}
	
	public T find(Class<T> type, Object id) {
		T entity = this.session.find(type, id);
		if(entity != null) {
			this.session.refresh(entity);
		}
		return entity;
	}
	
	public void delete(Class<T> type, Object id) {
		this.tx = this.session.beginTransaction();
		Object object = this.session.getReference(type, id);
		this.session.remove(object);
		this.tx.commit();
		this.session.close();
	}
	
	public List<T> findWithNamedQuery(String queryName, String paraName, Object paraValue){
		this.session = HibernateHelper.getSessionFactory().openSession();
		Query query = this.session.createNamedQuery(queryName);
		query.setParameter(paraName, paraValue);
		return query.getResultList();
	}
	
	// Admin Login
	public List<T> findWithNamedQuery(String queryName, Map<String, Object> parameters){
		this.session = HibernateHelper.getSessionFactory().openSession();
		Query query = this.session.createNamedQuery(queryName);
		Set<Entry<String, Object>> setParameters = parameters.entrySet();
		for(Entry<String, Object> entry: setParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

	public long countWithNamedQuery(String queryName) {
		this.session = HibernateHelper.getSessionFactory().openSession();
		Query query = this.session.createNamedQuery(queryName);
		return (long) query.getSingleResult();
	}
}
