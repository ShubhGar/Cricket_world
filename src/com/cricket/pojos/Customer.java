package com.cricket.pojos;


import java.io.Serializable;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="my_customers")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private Team userteam;
	private List<Player> players;
	@OneToOne(cascade = CascadeType.ALL,
			mappedBy = "teamid"/*,fetch=FetchType.EAGER*/)
	public Team getUserteam() {
		return userteam;
	}



	public void setUserteam(Team userteam) {
		this.userteam = userteam;
	}


	@OneToMany(cascade = CascadeType.ALL,
			mappedBy = "teamid"/*,fetch=FetchType.EAGER*/)
	public List<Player> getPlayers() {
		return players;
	}



	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	private int teamid;
	private double depositAmt;
	@NotEmpty
	@Email
	@Length(min=5,max=25)
	private String email;
	private String name;
	@NotEmpty
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[$#@%]).{5,10})")
	private String password;
	

	public Customer() {
		System.out.println("in cust constr");
	}
	


	public Customer(double depositAmt, String email, String name,
			String password) {
		super();
		this.depositAmt = depositAmt;
		this.email = email;
		this.name = name;
		this.password = password;
		
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getTeamid() {
		return this.teamid;
	}

	public void setTeamid(Integer teamid) {
		this.teamid = teamid;
	}


	@Column(name="deposit_amt",columnDefinition="decimal(6,1)")
	public double getDepositAmt() {
		return this.depositAmt;
	}

	public void setDepositAmt(double depositAmt) {
		this.depositAmt = depositAmt;
	}

	@Column(unique=true)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "CustomerPOJO [id=" + teamid + ", depositAmt=" + depositAmt
				+ ", email=" + email + ", name=" + name + ", password="
				+ password + "]";
	}

	public boolean addPlayer(Player player)
	{
		if(getPlayers().add(player))
		{
			System.out.println(getPlayers());
			player.setTeamid(this);
			return true;
		}
		return false;
	}

	public boolean removePlayer(Player player) 
	{
		if(getPlayers().remove(player))
		{
			player.setTeamid(null);
			return true;
		}
		return false;
	}
	public boolean addTeam(Team t)
	{
			userteam=t;
			t.setTeamid(this);
			return true;
	
	}

	public boolean removeTeam(Team t) 
	{
		if(userteam==t)
		{
			userteam=null;
			t.setTeamid(null);
			return true;
		}
		return false;
	}
}