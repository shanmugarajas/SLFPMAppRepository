package com.slf.pmapp.persistance;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slf.pmapp.models.Userconnection;


@Repository
@Transactional
public class UserconnectionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Userconnection> getUserConnection(String userId, String providerId)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Userconnection.class);
		criteria.add(Restrictions.ilike("userId", userId.toString().trim()+"%"));
		criteria.add(Restrictions.ilike("providerId", providerId.toString().trim()+"%"));
		return criteria.list();
	}
}
