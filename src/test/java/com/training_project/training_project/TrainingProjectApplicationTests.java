package com.training_project.training_project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training_project.training_project.controller.EmployeeController;
import com.training_project.training_project.model.Employee;
import com.training_project.training_project.service.DepartmentRepository;
import com.training_project.training_project.service.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(EmployeeController.class)
class TrainingProjectApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	EmployeeRepository empRepo;

	@MockBean
	DepartmentRepository deptRepo;

	@Test
	public void getAllEmployeesTest() throws Exception {
		List<Employee> employeeList = empRepo.findAll();
		//converting employeeList to Json String
		String expectedEmployeeList = objectMapper.writeValueAsString(employeeList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		String actualEmployeeList = mvcResult.getResponse().getContentAsString();

		System.out.println("Expected : "+expectedEmployeeList);
		System.out.println("Actual : "+actualEmployeeList);

		Assertions.assertEquals(expectedEmployeeList, actualEmployeeList);

	}


}
