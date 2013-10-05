package com.slf.pmapp.persistance;

import java.util.List;

import org.hibernate.Criteria;
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
	public List<Resource> getAllResources()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Resource.class);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Resource> getAllResources(int page)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Resource.class);
		if (page == 1)
			criteria.setFirstResult(page);
		else
			criteria.setFirstResult(page*pageSize + 1);
		criteria.setMaxResults(pageSize);
		//criteria.addOrder(Order.asc("resourceid"));
		return criteria.list();
	}
	
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
