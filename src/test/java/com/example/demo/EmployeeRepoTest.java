package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Employee;
import com.example.demo.domain.repos.EmployeeRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepoTest {
	

	@Autowired
	private EmployeeRepo emprepo; 
	
	@Test
	@WithMockUser
	public void inserEmp() throws Exception {
		Employee adder = new Employee("Mike", "Manfred", "01236485"); 
		emprepo.save(adder); 
		assertThat(adder.getEmpId()).isNotNull(); 
	}
	
	@Test
	@WithMockUser(username="admin",roles={"USER","ADMIN"})
	public void deleteEmp() throws Exception {
		Employee adder = new Employee("Mike", "Manfred", "01236485"); 
		emprepo.save(adder); 
		assertThat(adder.getEmpId()).isNotNull(); 
		emprepo.deleteById(adder.getEmpId());
		assertThat(emprepo.getByLastName("Manfred")).isNull();
	}
	
	
	

}
