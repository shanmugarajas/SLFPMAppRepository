package com.slf.pmapp.persistance;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slf.pmapp.models.Allocation;
import com.slf.pmapp.models.Request;
import com.slf.pmapp.models.Resource;

/**
 * @author Venky
 *
 */
@Repository
@Transactional
public class RequestsDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	private static int pageSize = 3;
	
	public Request getById(int id)
	{
		return (Request) sessionFactory.getCurrentSession().get(Request.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Request> searchRequests(String projectmodule)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Request.class);
		criteria.add(Restrictions.ilike("projectmodule", projectmodule+"%"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Request> searchAllocations(String projectmodule, int page)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Request.class);
		criteria.add(Restrictions.ilike("projectmodule", projectmodule+"%"));
		if (page == 1)
			criteria.setFirstResult(page);
		else
			criteria.setFirstResult(page*pageSize + 1);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Request> getAllRequests()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Request.class);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Allocation> getAllRequests(int page)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Request.class);
		if (page == 1)
			criteria.setFirstResult(page);
		else
			criteria.setFirstResult(page*pageSize + 1);
		criteria.setMaxResults(pageSize);
		//criteria.addOrder(Order.asc("resourceid"));
		return criteria.list();
	}
	
	public int save(Request request)
	{
		return (Integer) sessionFactory.getCurrentSession().save(request);
	}
	
	public void update(Request request)
	{
		sessionFactory.getCurrentSession().merge(request);
	}
	
	public void delete(int id)
	{
		Request c = getById(id);
		sessionFactory.getCurrentSession().delete(c);
	}
	
}
