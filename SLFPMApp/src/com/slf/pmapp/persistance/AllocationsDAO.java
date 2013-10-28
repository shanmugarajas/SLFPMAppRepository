package com.slf.pmapp.persistance;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
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
import com.slf.pmapp.models.Resource;

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
	
	private static int pageSize = 10;
	
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
		
		//Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Allocation.class);
		Query query = sessionFactory.getCurrentSession().createQuery("from Allocation order by id asc");
		System.out.println("Number of Allocation records retrieved:" + query.list().size());
		//return criteria.list();
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Allocation> getMyAllocations(String userName)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Allocation.class);
		DetachedCriteria subquery = DetachedCriteria.forClass(Resource.class);
		subquery.add(Restrictions.ilike("email", userName.toString().trim()+"%"));
		subquery.setProjection(Projections.property("id"));
		criteria.add(
		            Restrictions.or(
		                    Restrictions.isNull("resourceid"),
		                    Subqueries.propertyIn("resourceid", subquery)
		                    )
		            );
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
