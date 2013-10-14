package com.slf.pmapp.persistance;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slf.pmapp.models.Allocation;

/**
 * @author Venky
 *
 */
@Repository
@Transactional
public class AllocationsDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	private static int pageSize = 3;
	
	public Allocation getById(int id)
	{
		return (Allocation) sessionFactory.getCurrentSession().get(Allocation.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Allocation> searchAllocations(String projectmodule)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Allocation.class);
		criteria.add(Restrictions.ilike("projectmodule", projectmodule+"%"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Allocation> searchAllocations(String projectmodule, int page)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Allocation.class);
		criteria.add(Restrictions.ilike("projectmodule", projectmodule+"%"));
		if (page == 1)
			criteria.setFirstResult(page);
		else
			criteria.setFirstResult(page*pageSize + 1);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Allocation> getAllAllocations()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Allocation.class);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Allocation> getAllAllocations(int page)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Allocation.class);
		if (page == 1)
			criteria.setFirstResult(page);
		else
			criteria.setFirstResult(page*pageSize + 1);
		criteria.setMaxResults(pageSize);
		//criteria.addOrder(Order.asc("resourceid"));
		return criteria.list();
	}
	
	public int save(Allocation allocation)
	{
		return (Integer) sessionFactory.getCurrentSession().save(allocation);
	}
	
	public void update(Allocation allocation)
	{
		sessionFactory.getCurrentSession().merge(allocation);
	}
	
	public void delete(int id)
	{
		Allocation c = getById(id);
		sessionFactory.getCurrentSession().delete(c);
	}
	
}
