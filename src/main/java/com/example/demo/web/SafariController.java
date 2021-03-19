package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Employee;
import com.example.demo.domain.Trip;
import com.example.demo.domain.repos.CustomerRepo;
import com.example.demo.domain.repos.EmployeeRepo;
import com.example.demo.domain.repos.TripInstanceRepo;
import com.example.demo.domain.repos.TripRepo;

@Controller
public class SafariController {
	@Autowired
	private CustomerRepo custRepo;
	@Autowired
	private EmployeeRepo empRepo; 
	@Autowired
	private TripRepo tripRepo; 
	@Autowired
	private TripInstanceRepo tripInsRepo; 
	
	@GetMapping(value={"/", "/index"})
	public String firstPage(Model model) {
		model.addAttribute("caltrips", tripInsRepo.findAll());
		return "index"; 
	}
	
	@GetMapping(value="deleteinstance/{id}")
	public String delInst(@PathVariable("id") Long instId, Model model) {
		tripInsRepo.deleteById(instId);
		return "redirect:/index"; 
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
	
	@GetMapping(value="/newsafari")
	public String newTrip(Model model) {
		model.addAttribute("safari", new Trip()); 
		return "newTrip"; 
	}
	
	@PostMapping(value="/newsaf")
	public String makeSafari(Trip trip, Model mode) {
		tripRepo.save(trip); 
		return "redirect:/trip"; 
	}
	@GetMapping(value="editrip/{id}")
	public String editTrip(@PathVariable("id") Long tripId, Model model) {
		model.addAttribute("safari", tripRepo.findById(tripId)); 
		return "editTrip"; 
	}
	@GetMapping(value="deletesaf/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteSafari(@PathVariable("id") Long tripId, Model model) {
		tripRepo.deleteById(tripId);
		return "redirect:/trip";
	}
	
	
	@GetMapping(value="/newemployee")
	public String newemp(Model model) {
		model.addAttribute("emp", new Employee()); 
		return "newemp"; 
	}
	@PostMapping(value={"saveemp","editemp/saveemp"})
	public String addemp(Employee emp, Model model) {
		empRepo.save(emp); 
		return "redirect:/employee"; 
	}
	
	@GetMapping(value="deletemp/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deletEmp(@PathVariable("id") Long empId, Model model) {
    	empRepo.deleteById(empId);
        return "redirect:../employee";
    }
	
	@GetMapping(value="editemp/{id}")
	public String editEmp(@PathVariable("id") Long empId, Model model) {
		model.addAttribute("emp", empRepo.findById(empId).get()); 
		return "editemp"; 
	}
	
	@GetMapping(value="newcust")
	public String newCustomer(Model model) {
		model.addAttribute("cust", new Customer(false)); 
		return "newcustomer"; 
	}
	
	@PostMapping(value="savecust")
	public String saveCust(Customer cust, Model model) {
		custRepo.save(cust); 
		return "redirect:/customer"; 
	}
	
	
	
	
	
	
	
	
	

}
