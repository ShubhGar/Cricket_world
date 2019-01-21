package com.cricket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import com.cricket.dao.CricketDao;
import com.cricket.pojos.*;


@Service("cric_dao_service")
@Transactional
public class CricketServiceImp implements CricketService
{
	@Autowired
	private CricketDao dao;
	
	@Override
	public Player resisterPlayer(String email,String pass,Player p)
	{
		return dao.resisterPlayer(email,pass, p);
	}
	
	@Override
	public Team resisterTeam(String email,String pass,Team t)
	{
		return dao.resisterTeam(email,pass,t);
	}
	
	@Override
	public Team removeTeam(String teamName)
	{
		return dao.removeTeam(teamName);
	}
	
	@Override
	public Player removePlayer(long PlayerId)
	{
		return dao.removePlayer(PlayerId);
	}
	
	@Override
	public Team TeamDetail(String teamName)
	{
		return dao.TeamDetail(teamName);
	}
		
	@Override
	public Player playerDetail(long playerId)
	{
		return dao.playerDetail(playerId);
	}
	
	@Override
	public Team checkTeam(String email){
		return dao.checkTeam(email);
	}

}
