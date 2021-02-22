package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Employee;
import com.example.demo.domain.repos.CustomerRepo;
import com.example.demo.domain.repos.EmployeeRepo;
import com.example.demo.domain.repos.ReservationRepo;
import com.example.demo.domain.repos.TripInstanceRepo;
import com.example.demo.domain.repos.TripRepo;

@Controller
public class SafariController {
	@Autowired
	private CustomerRepo custRepo;
	@Autowired
	private EmployeeRepo empRepo; 
	@Autowired
	private ReservationRepo resRepo; 
	@Autowired
	private TripRepo tripRepo; 
	@Autowired
	private TripInstanceRepo tripInsRepo; 
	
	@GetMapping(value={"/", "/index"})
	public String firstPage(Model model) {
		model.addAttribute("caltrips", tripInsRepo.findAll());
		return "index"; 
	}
	
	@GetMapping(value="/customer")
	public String customerPage(Model model) {
		model.addAttribute("customers", custRepo.findAll()); 
		return "customerList"; 
	}
	
	@GetMapping(value="/employee")
	public String employeePage(Model model) {
		model.addAttribute("employees", empRepo.findAll()); 
		return "employeeList"; 
	}
	
	@GetMapping(value="/trip")
	public String tripList(Model model) {
		model.addAttribute("trips", tripRepo.findAll()); 
		return "tripList"; 
	}
	
	@GetMapping(value="/newemployee")
	public String newemp(Model model) {
		model.addAttribute("emp", new Employee()); 
		return "newemp"; 
	}
	@PostMapping(value="saveemp")
	public String addemp(Employee emp, Model model) {
		empRepo.save(emp); 
		return "redirect:employeeList"; 
	}
	
	@GetMapping(value="deletemp/{id}")
	public String deletEmp(@PathVariable("id") Long empId, Model model) {
    	empRepo.deleteById(empId);
        return "redirect:../employeeList";
    }
	
	@GetMapping(value="editemp/{id}")
	public String editEmp(@PathVariable("id") Long empId, Model model) {
		model.addAttribute("emp", empRepo.findById(empId).get()); 
		return "editemp"; 
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
