package com.slf.pmapp.persistance;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slf.pmapp.models.Track;

/**
 * @author Venky
 *
 */
@Repository
@Transactional
public class TracksDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public Track getById(int id)
	{
		return (Track) sessionFactory.getCurrentSession().get(Track.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Track> searchTracks(String name)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Track.class);
		criteria.add(Restrictions.ilike("name", name+"%"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Track> getAllTracks()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Track.class);
		return criteria.list();
	}
	
	public int save(Track track)
	{
		return (Integer) sessionFactory.getCurrentSession().save(track);
	}
	
	public void update(Track track)
	{
		sessionFactory.getCurrentSession().merge(track);
	}
	
	public void delete(int id)
	{
		Track c = getById(id);
		sessionFactory.getCurrentSession().delete(c);
	}

}

