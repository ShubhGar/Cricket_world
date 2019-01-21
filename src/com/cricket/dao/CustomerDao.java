package com.cricket.dao;

import java.util.List;

import com.cricket.pojos.Customer;
import com.cricket.pojos.Player;

public interface CustomerDao {
	Customer validateCustomer(String em,String pass);
	Customer registerCustomer(Customer cust);
	public List<String> getAllTeam() ;
	public List<Player> getAllPlayer(String email) ;
}
