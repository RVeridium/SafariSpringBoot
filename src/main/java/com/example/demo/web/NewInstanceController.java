package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Reservation;
import com.example.demo.domain.TripInstance;
import com.example.demo.domain.repos.CustomerRepo;
import com.example.demo.domain.repos.EmployeeRepo;
import com.example.demo.domain.repos.ReservationRepo;
import com.example.demo.domain.repos.TripInstanceRepo;
import com.example.demo.domain.repos.TripRepo;

@Controller
public class NewInstanceController {
	@Autowired
	private TripInstanceRepo tripInsRepo;
	@Autowired
	private CustomerRepo custRepo;
	@Autowired
	private EmployeeRepo empRepo;
	@Autowired
	private ReservationRepo resRepo;
	@Autowired
	private TripRepo tripRepo;

	@PostMapping(value = "/newinst")
	public String createInst(TripInstance instance, Model model) {
		tripInsRepo.save(instance);
		return "redirect:/index";
	}

	@GetMapping(value = "addinstance")
	public String newinst(Model model) {
		model.addAttribute("instance", new TripInstance());
		model.addAttribute("safaris", tripRepo.findAll());
		model.addAttribute("emps", empRepo.findAll());
		return "newinst";
	}

	@GetMapping(value = "editinstance/{id}")
	public String editInst(@PathVariable("id") Long tripInsID, Model model) {
		model.addAttribute("instance", tripInsRepo.findById(tripInsID).get());
		model.addAttribute("safaris", tripRepo.findAll());
		model.addAttribute("emps", empRepo.findAll());
		return "editins";
	}

	@GetMapping(value = "reservate/{id}")
	public String reservations(@PathVariable("id") Long tripInsID, Model model) {
		model.addAttribute("instance", tripInsRepo.findById(tripInsID).get());
		model.addAttribute("resList", tripInsRepo.findById(tripInsID).get().getResList());
		return "reservation";
	}

	@PostMapping(value = "saveres")
	public String saveres(Reservation res, Model model) {
		resRepo.save(res);
		return "redirect:/index";
	}

	@GetMapping(value = "newres")
	public String newRes(Model model) {
		model.addAttribute("reservation", new Reservation());
		model.addAttribute("instances", tripInsRepo.findAll());
		model.addAttribute("custs", custRepo.findAll());
		return "newreservation";
	}

	@GetMapping(value = "deleteres/{id}")
	public String delInst(@PathVariable("id") Long resId, Model model) {
		resRepo.deleteById(resId);
		return "redirect:/index";
	}

	@GetMapping(value = "reservate/editres/{id}")
	public String editRes(@PathVariable("id") Long resId, Model model) {
		model.addAttribute("reservation", resRepo.findById(resId).get());
		model.addAttribute("instances", tripInsRepo.findAll());
		model.addAttribute("custs", custRepo.findAll());
		return "editreservation";
	}

}
