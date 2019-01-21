package com.cricket.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cricket.pojos.*;


@Repository
public class CricketDaoImp implements CricketDao
{
	@Autowired
	private SessionFactory sf;
	@Autowired
	private CustomerDao dao;
	
	@Override
	public Player resisterPlayer(String email,String pass,Player p)
	{
		Customer u = dao.validateCustomer(email, pass);
		if (u != null && u.addPlayer(p))
		{
			return p;
		}
			
		return null;
	}

	
	@Override
	public Team resisterTeam(String email,String pass,Team t)
	{
		Customer u = dao.validateCustomer(email, pass);
		if(u !=null && u.addTeam(t))
			return t;
		return null;
	}
	
	@Override
	public Team removeTeam(String teamName)
	{
		Team t = TeamDetail(teamName);
		if (t != null)
		sf.getCurrentSession().createQuery("delete from Team t where t.teamname=:tm").setParameter("tm", teamName).executeUpdate();
		return t;		
	}
	

	
	@Override
	public Player removePlayer(long playerId)
	{
		Player p= playerDetail(playerId);
		if (p != null)
			sf.getCurrentSession().createQuery("delete from Player p where p.playerid=:pid").setParameter("pid", playerId).executeUpdate();
		return p;
		
	}
	
	@Override
	public Team TeamDetail(String teamName)
	{
		Team t=(Team) sf.getCurrentSession()
				.createQuery("select t from Team t where t.teamname=:nm")
				.setParameter("nm", teamName).uniqueResult();
		System.out.println(" team details  "+t);
				return t;
		
	}
	
	
	@Override
	public Player playerDetail(long playerId)
	{
		Session hs = sf.getCurrentSession();
		Player p = (Player) hs
				.createQuery("select p from Player p "
						+ "where p.playerid = :pid")
				.setParameter("pid", playerId).uniqueResult();
		return p;
		
	}
	@Override
	public Team checkTeam(String email){
		return(Team)sf.getCurrentSession().createQuery("select t from Team t,Customer c where c.email=:em and c.teamid=t.teamid").setParameter("em", email).uniqueResult();
	}
}
