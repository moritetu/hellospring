package net.debug_life.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.debug_life.hellospring.model.Users;
import net.debug_life.hellospring.repository.UsersRepository;
import net.debug_life.hellospring.validation.GroupOrder;

@Controller
public class LoginController {

	@Autowired
	UsersRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, 
			@Validated(GroupOrder.class) @ModelAttribute("loginForm") net.debug_life.hellospring.form.LoginForm loginForm, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "index";
		}

		List<Users> userList = repository.findAll();
		for (Users user : userList) {
			if (user.getName().equals(loginForm.getLoginName())) {
				model.addAttribute("loginName", loginForm.getLoginName());
				return "top";
			}
		}
		return "index";
	}
}