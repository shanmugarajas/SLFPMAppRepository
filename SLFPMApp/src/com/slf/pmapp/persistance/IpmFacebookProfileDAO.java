package com.slf.pmapp.persistance;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.slf.pmapp.models.IpmFacebookProfile;


@Repository
@Transactional
public class IpmFacebookProfileDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public IpmFacebookProfile getById(String id)
	{
		return (IpmFacebookProfile) sessionFactory.getCurrentSession().get(IpmFacebookProfile.class, id);
	}
	
	public IpmFacebookProfile getProfileID(String loginname)
	{
		System.out.println("Loginname is: " + loginname);
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(IpmFacebookProfile.class);
		criteria.add(Restrictions.ilike("loginname", loginname.toString().trim()+"%"));
		return (IpmFacebookProfile) criteria.list().get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<IpmFacebookProfile> getAllIpmFacebookProfiles()
	{
		
		//Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Allocation.class);
		Query query = sessionFactory.getCurrentSession().createQuery("from IpmFacebookProfile order by id asc");
		//return criteria.list();
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<IpmFacebookProfile> getMyIpmFacebookProfile(String id)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(IpmFacebookProfile.class);
		criteria.add(Restrictions.ilike("id", id.toString().trim()+"%"));
		return criteria.list();
	}
	
	public int save(IpmFacebookProfile ipmFacebookProfile)
	{
		return (Integer) sessionFactory.getCurrentSession().save(ipmFacebookProfile);
	}
	
	public void update(IpmFacebookProfile ipmFacebookProfile)
	{
		sessionFactory.getCurrentSession().merge(ipmFacebookProfile);
	}
	
	public void delete(String id)
	{
		IpmFacebookProfile c = getById(id);
		sessionFactory.getCurrentSession().delete(c);
	}

}
