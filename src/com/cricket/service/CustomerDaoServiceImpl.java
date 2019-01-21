package com.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cricket.dao.CustomerDao;

import com.cricket.pojos.*;

@Service("cust_dao_service")
@Transactional
public class CustomerDaoServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao dao;

	@Override
	public List<String> getAllTeam() {
		// TODO Auto-generated method stub
		return dao.getAllTeam();
	}


	@Override
	public List<Player> getAllPlayer(String email) {
		// TODO Auto-generated method stub
		return dao.getAllPlayer(email);
	}
	@Transactional(readOnly = true)
	@Override
	public Customer validateCustomer(String em, String pass) {

		return dao.validateCustomer(em, pass);
	}

	@Override
	public Customer registerCustomer(Customer cust) {
		
		return dao.registerCustomer(cust);
	}

}
