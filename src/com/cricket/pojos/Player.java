package com.cricket.pojos;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.*;


/**
 * The persistent class for the PLAYER database table.
 */
@Entity
@NamedQuery(name="Player.findAll", query="SELECT p FROM Player p")
public class Player implements Serializable
{
	private static final long serialVersionUID = 1L;
	private long playerid;
	private String playeraddr;
	private byte[] playerimage;
	private String playername;
	private String playstyle;
	private Customer teamid;

	public Player() {}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getPlayerid()
	{
		return this.playerid;
	}

	public void setPlayerid(long playerid)
	{
		this.playerid = playerid;
	}

	@Column(length=30)
	public String getPlayeraddr()
	{
		return this.playeraddr;
	}

	public void setPlayeraddr(String playeraddr)
	{
		this.playeraddr = playeraddr;
	}


	@Lob
	public byte[] getPlayerimage()
	{
		return this.playerimage;
	}

	public void setPlayerimage(byte[] playerimage)
	{
		this.playerimage = playerimage;
	}

	@Column(length=30)
	public String getPlayername()
	{
		return this.playername;
	}

	public void setPlayername(String playername)
	{
		this.playername = playername;
	}

	@Column(length=30)
	public String getPlaystyle()
	{
		return this.playstyle;
	}

	public void setPlaystyle(String playstyle)
	{
		this.playstyle = playstyle;
	}

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="teamid")
	public Customer getTeamid() 
	{
		return this.teamid;
	}
	
	
	public void setTeamid(Customer teamid)
	{
		this.teamid = teamid;
	}


	@Override
	public String toString() 
	{
		return "Player [playerid=" + playerid + ", playeraddr=" + playeraddr
				+ ", playerimage=" + Arrays.toString(playerimage)
				+ ", playername=" + playername + ", playstyle=" + playstyle
				+ ", teamid=" + teamid + "]";
	}


	public Player( String playername,
			String playstyle,String playeraddr, byte[] playerimage)
	{
		super();
		this.playeraddr = playeraddr;
		this.playerimage = playerimage;
		this.playername = playername;
		this.playstyle = playstyle;
	}

	public Player(long playerid) {
		super();
		this.playerid = playerid;
	}

	
	
	
}


