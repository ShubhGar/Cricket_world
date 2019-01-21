package com.cricket.pojos;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Arrays;

/**
 * The persistent class for the TEAM database table.
 */
@Entity
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Customer teamid;
	private String teamname;
	private String homestate;
	private byte[] teamicon;

	public Team() {}

	public Team(String teamname, String homestate, byte[] teamicon) 
	{
		super();
		this.teamname = teamname;
		this.homestate = homestate;
		this.teamicon = teamicon;
	}


	@Override
	public String toString()
	{
		return "Team [teamname=" + teamname + ", homestate=" + homestate
				+ ", teamicon=" + Arrays.toString(teamicon) + "]";
	}
	
	
	@OneToOne
	@JoinColumn(name="teamid")
	public Customer getTeamid() {
		return teamid;
	}

	public void setTeamid(Customer teamid) {
		this.teamid = teamid;
	}
	
	@Id
	public String getTeamname()
	{
		return this.teamname;
	}

	public void setTeamname(String teamname)
	{
		this.teamname = teamname;
	}


	public String getHomestate()
	{
		return this.homestate;
	}

	public void setHomestate(String homestate)
	{
		this.homestate = homestate;
	}


	@Lob
	public byte[] getTeamicon()
	{
		return this.teamicon;
	}

	public void setTeamicon(byte[] teamicon)
	{
		this.teamicon = teamicon;
	}

	public Team(String teamname) {
		super();
		this.teamname = teamname;
	}


	
}
