package com.vking.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vking.test.data.Part;

@Repository
public class PartRepositoryImp implements PartRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	public void save(Part part) {
		getSession().save(part);
	}

	@Override
	public Part findByName(String name) {
		Part part = (Part) getSession().createCriteria(Part.class)
				.add(Restrictions.eq("name", name)).list().get(0);
		return part;
	}

	@Transactional
	public void genericNewPart(Part part) {
		getSession().save(part);
	}

}
