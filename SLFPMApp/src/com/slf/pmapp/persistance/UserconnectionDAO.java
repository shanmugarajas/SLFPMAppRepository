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
	public List<Userconnection> getUserConnection(String userId, String providerId, String providerUserId)
	{
		System.out.println("UserCon restrict userid: " + userId.toString().trim());
		System.out.println("UserCon restrict providerId: " + providerId.toString().trim());
		System.out.println("UserCon restrict providerUserid: " + providerUserId.toString().trim());
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Userconnection.class);
		criteria.add(Restrictions.eq("userid", userId.toString().trim()));
		//criteria.add(Restrictions.eq("providerid", providerId.toString().trim()));
		//criteria.add(Restrictions.eq("provideruserid", providerUserId.toString().trim()));
		return criteria.list();
	}
}
