package com.example.demo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.NewSafariUser;
import com.example.demo.domain.SafariUser;
import com.example.demo.domain.repos.SafUserRepo;

@Controller
public class NewUserController {

	@Autowired
	private SafUserRepo useRepo;

	@GetMapping(value = "adduser")
	public String addUser(Model model) {
		model.addAttribute("newUser", new NewSafariUser());
		return "newUser";
	}

	@PostMapping(value = "saveNewUser")
	public String savingNew(@Valid @ModelAttribute("newUser") NewSafariUser newUser, BindingResult bindRes) {
		if (!bindRes.hasErrors()) {
			if (newUser.getPassword().equals(newUser.getPasswordCheck())) { // check password match
				String pwd = newUser.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPwd = bc.encode(pwd);

				SafariUser user = new SafariUser();
				user.setPwHashed(hashPwd);
				user.setUsername(newUser.getUsername());
				user.setRole("USER");
				if (useRepo.findByUsername(newUser.getUsername()) == null) { // Check if user exists
					useRepo.save(user);
				} else {
					bindRes.rejectValue("username", "err.username", "This user already exists");
					return "newUser";
				}
			} else {

				bindRes.rejectValue("passwordCheck", "err.passCheck", "Passwords do not match");
				return "newUser";
			}
		} else {
			return "newUser";
		}
		return "redirect:/login";
	}

}
