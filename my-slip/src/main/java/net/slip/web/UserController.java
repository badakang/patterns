package net.slip.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	private List<User> users = new ArrayList<>();

	@PostMapping("/create")
	public String create(User user, Model model) {
		// System.out.println(userId +", "+ password +", "+ name);
		System.out.println(user);
		model.addAttribute("userId", user.getUserId());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("name", user.getName());
		model.addAttribute("email", user.getEmail());
		
		users.add(user);
		
		return "redirect:/list";
	}

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("users",  users);
		return "list";
	}

}
