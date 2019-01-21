package com.cricket.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cricket.pojos.Customer;
import com.cricket.pojos.Player;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Customer validateCustomer(String em, String pass) {
		return (Customer) sf
				.getCurrentSession()
				.createQuery(
						"select c from Customer c where c.email = :em and c.password = :pa")
				.setParameter("em", em).setParameter("pa", pass).uniqueResult();
	}

	@Override
	public Customer registerCustomer(Customer cust) {
		
		 sf.getCurrentSession().persist(cust);
		 return cust;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllTeam() {
		return (List<String>) sf.getCurrentSession().createQuery("select t.teamname from Team t").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getAllPlayer(String email) {
		int tid = (Integer)sf.getCurrentSession().createQuery("select c.teamid from Customer c where c.email = :em").setParameter("em",email).uniqueResult();
		System.out.println(tid);
		List<Player>p=(List<Player>) sf.getCurrentSession().createQuery("select p from Player p,Customer c where c.teamid = :tid and p.teamid=c.teamid ").setParameter("tid",tid).list();
		System.out.println(p);
		return p;
	}

}
