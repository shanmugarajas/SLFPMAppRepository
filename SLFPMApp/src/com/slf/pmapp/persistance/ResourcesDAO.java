package com.slf.pmapp.persistance;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slf.pmapp.models.Allocation;
import com.slf.pmapp.models.Resource;

/**
 * @author Venky
 *
 */
@Repository
@Transactional
public class ResourcesDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	private static int pageSize = 10;
	
	public Resource getById(int id)
	{
		return (Resource) sessionFactory.getCurrentSession().get(Resource.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Resource> searchResources(String name)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Resource.class);
		criteria.add(Restrictions.ilike("name", name+"%"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Resource> searchResources(String name, int page)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Resource.class);
		criteria.add(Restrictions.ilike("name", name+"%"));
		if (page == 1)
			criteria.setFirstResult(page);
		else
			criteria.setFirstResult(page*pageSize + 1);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Resource> getAllResources()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Resource.class);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Resource> getAllResources(int page)
	{
		Query query = sessionFactory.getCurrentSession().createQuery("from Resource order by id asc");
		System.out.println("Number of Resource records retrieved:" + query.list().size());
		//return criteria.list();
				
		//Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Resource.class);
		if (page == 1)
			query.setFirstResult(page);
		else
			query.setFirstResult(page*pageSize + 1);
		query.setMaxResults(pageSize);
		//criteria.addOrder(Order.asc("resourceid"));
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Resource> getMyResources(String userName)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Resource.class);
		System.out.println("User name:" + userName.toString().trim());
		criteria.add(Restrictions.ilike("email", userName.toString().trim()+"%"));
		return criteria.list();
	}

	@Transactional
	public int save(Resource resource)
	{
		return (Integer) sessionFactory.getCurrentSession().save(resource);
	}
	
	public void update(Resource resource)
	{
		sessionFactory.getCurrentSession().merge(resource);
	}
	
	public void delete(int id)
	{
		Resource c = getById(id);
		sessionFactory.getCurrentSession().delete(c);
	}

}
