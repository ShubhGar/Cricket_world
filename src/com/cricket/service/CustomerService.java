package com.cricket.service;

import java.util.List;
import com.cricket.pojos.*;

public interface CustomerService {
	 List<String> getAllTeam();
	 List<Player> getAllPlayer(String email);
	 Customer validateCustomer(String em,String pass);
	 Customer registerCustomer(Customer cust);
	 
		
}
