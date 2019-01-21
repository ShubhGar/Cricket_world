package com.cricket.service;

import com.cricket.pojos.*;

public interface CricketService
{
	public Player resisterPlayer(String teamName,String pass,Player p);
	public Team resisterTeam(String email,String pass,Team t);
	public Team removeTeam(String teamName);
	public Player removePlayer(long PlayerId);
	public Team TeamDetail(String teamName);
	public Player playerDetail(long playerId);
	public Team checkTeam(String email);
	
}
