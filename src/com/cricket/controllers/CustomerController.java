package com.cricket.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cricket.pojos.Customer;
import com.cricket.pojos.Player;
import com.cricket.pojos.Team;
import com.cricket.service.CricketService;
import com.cricket.service.CustomerService;
//import javax.mail.internet.InternetAddress;

@Controller
// mandatory
@RequestMapping("/cust")
// optional
public class CustomerController {
	@Autowired
	@Qualifier("cust_dao_service")
	private CustomerService service;
	@Autowired
	@Qualifier("cric_dao_service")
	private CricketService cricservice;
	@Autowired
	private MailSender sender;
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession hs)
	{
		hs.removeAttribute("cust");
		return "redirect:/index.jsp";
	}

	@RequestMapping(value = "/teamlist")
	public String listTeam(Model map) {
		System.out.println("list teams");
		map.addAttribute("team_list", service.getAllTeam());
		return "teamlist";
	}
	@RequestMapping(value = "/playerlist")
	public String listPlayer(Model map,HttpSession hs) {
		System.out.println("list players");
		Customer cust=(Customer)hs.getAttribute("cust");
		if(cust==null)
		{
			map.addAttribute("message", "please login first");
			return "login";
		}
		map.addAttribute("player_list", service.getAllPlayer(cust.getEmail()));
		return "playerlist";
	}

	@RequestMapping(value = "/validate")
	public String showLoginForm(Customer cust) {
		System.out.println("in show login form " + cust);
		return "login";
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String processLoginForm(@Valid Customer cust123,
			BindingResult result, Model map,HttpSession hs) {
		System.out.println("in process login form");
		System.out.println("cust details " + cust123);
		// check for P.L validation errs
		if (result.hasFieldErrors("email") || result.hasFieldErrors("password")) {
			System.out.println("p.l errs : in validate");
			return "login";
		}
		System.out.println("no p.l errs");
		// invoke service layer method
		Customer validCust = service.validateCustomer(cust123.getEmail(),
				cust123.getPassword());
		if (validCust == null) {
			map.addAttribute("mesg", "Login Invalid , Pls retry");
			return "login";
		}
		hs.setAttribute("cust", validCust);
		map.addAttribute("valid_cust", validCust);
		map.addAttribute("status", "Login Successful");
		return "valid";
	}

	// controller method to display reg form
	@RequestMapping(value = "/register")
	public String showRegForm(Customer cust) {
		System.out.println("in show reg form " + cust);
		// map.addAttribute(new Customer());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegForm(Customer cust123, Model map, HttpSession hs) {
		System.out.println("in process reg form");
		System.out.println("cust details " + cust123);
		// invoke service layer method
		
		SimpleMailMessage mesg=new SimpleMailMessage();
		mesg.setFrom("91garg.shubham@gmail.com");
		mesg.setTo(cust123.getEmail());
		mesg.setText("you are succesfully registered");
		sender.send(mesg);
		Customer validCust = service.registerCustomer(cust123);
		if (validCust.getTeamid() == null) {
			map.addAttribute("mesg", "Reg Invalid , Pls retry");
			return "register";
		}
		hs.setAttribute("valid_cust", validCust);
		hs.setAttribute("status", "Reg Successful");
		return "redirect:/cust/validate";
	}
	

	
	@RequestMapping(value = "/teamregister")
	public String showteamRegForm(Team team) {
		System.out.println("in show reg form " + team);
		// map.addAttribute(new Customer());
		return "teamregister";
	}

	@RequestMapping(value = "/teamregister", method = RequestMethod.POST)
	public String processRegForm(Team team, Model map, HttpSession hs) {
		System.out.println("in process reg form");
		System.out.println("cust details " + team);
		// invoke service layer method
		Customer cust=(Customer)hs.getAttribute("cust");
		if(cust==null)
		{
			map.addAttribute("message", "please login first");
			return "login";
		}
		hs.setAttribute("status", "Team is already register,first remove for change");
		Team cteam=cricservice.checkTeam(cust.getEmail());
		if(cteam==null){
		Team validteam = cricservice.resisterTeam(cust.getEmail(), cust.getPassword(), team);
		hs.setAttribute("valid_cust", validteam);
		hs.setAttribute("status", "Team is registered");
		}
		return "valid";
	}
	@RequestMapping(value = "/playerregister")
	public String showPlayerRegForm(Player player) {
		System.out.println("in show reg form " + player);
		// map.addAttribute(new Customer());
		return "playerregister";
	}

	@RequestMapping(value = "/playerregister", method = RequestMethod.POST)
	public String processRegForm(Player player, Model map, HttpSession hs) {
		System.out.println("in process reg form");
		System.out.println("cust details " + player);
		// invoke service layer method
		Customer cust=(Customer)hs.getAttribute("cust");
		if(cust==null)
		{
			map.addAttribute("message", "please login first");
			return "login";
		}
		List<Player> lplayer=service.getAllPlayer(cust.getEmail());
		hs.setAttribute("status", "U have already register 15 player,remove player for change");
		if(lplayer.size()<=15)
		{
		Player validplayer = cricservice.resisterPlayer(cust.getEmail(), cust.getPassword(), player);
		hs.setAttribute("valid_cust", validplayer);
		hs.setAttribute("status", "Player is register Successful");
		}
		return "valid";
	}
	@RequestMapping(value="/removeplayer")
	public String removePlayer(Player p)
	{
		
		return "removeplayer";
	}
	
	
	@RequestMapping(value="/removeplayer", method=RequestMethod.POST)
	public String removePlayer(Player p,Model map)
	{
		cricservice.removePlayer(p.getPlayerid());
		map.addAttribute("valid_cust", null);
		map.addAttribute("status","player is removed");
		return "valid";
	}
	@RequestMapping(value="/removeteam")
	public String removeTeam(Team t)
	{
		
		return "removeteam";
	}
	
	
	@RequestMapping(value="/removeteam", method=RequestMethod.POST)
	public String removeTeam(Team t,Model map)
	{
		cricservice.removeTeam(t.getTeamname());
		map.addAttribute("valid_cust", null);
		map.addAttribute("status","Team is removed,Please change the name");
		return "valid";
	}
	
	@RequestMapping(value="/tournamentScheduling")
	public String tournament(Model map)
	{
		List<String> teamlst=service.getAllTeam();
		int n=teamlst.size();
		String[] teamarray;
		if(n%2==0)
			teamarray=teamlst.toArray(new String[n] );
		else
		{
			map.addAttribute("wildcard", "wild card entry of team");
			teamarray=teamlst.toArray(new String[n+1] );
		}
		map.addAttribute("teamarr", teamarray);
		return "tournamentScheduling";
	}
}
