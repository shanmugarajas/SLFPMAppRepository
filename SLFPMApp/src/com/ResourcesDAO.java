package com;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	public Resource getById(int id)
	{
		return (Resource) sessionFactory.getCurrentSession().get(Resource.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Resource> searchContacts(String name)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Resource.class);
		criteria.add(Restrictions.ilike("name", name+"%"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Resource> getAllContacts()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Resource.class);
		return criteria.list();
	}
	
	public int save(Resource contact)
	{
		return (Integer) sessionFactory.getCurrentSession().save(contact);
	}
	
	public void update(Resource contact)
	{
		sessionFactory.getCurrentSession().merge(contact);
	}
	
	public void delete(int id)
	{
		Resource c = getById(id);
		sessionFactory.getCurrentSession().delete(c);
	}

}
