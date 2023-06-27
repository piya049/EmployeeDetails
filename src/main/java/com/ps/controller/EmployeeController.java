package com.ps.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ps.email.ExcelService;
import com.ps.model.Employee;
import com.ps.repo.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	@Autowired
	public ExcelService excelService;
	
//	@RequestMapping
//	public ResponseEntity<InputStreamResource> getallEmployees() throws IOException{
//		String fileName="employees.xlsx";
//		
//		ByteArrayInputStream actualData = excelService.getActualData();
//		InputStreamResource file = new InputStreamResource(actualData);
//		
//		ResponseEntity<InputStreamResource> body = ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+fileName)
//				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
//				.body(file);
//		return body;
//	}
	
	@GetMapping("/employees")
	public ResponseEntity<InputStreamResource> getallEmployees() throws IOException {
		String fileName = "employees.xlsx";

		ByteArrayInputStream actualData = excelService.getActualData();
		InputStreamResource file = new InputStreamResource(actualData);

		ResponseEntity<InputStreamResource> body = ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);
		return body;
	}

	@PostMapping("/saveEmp")
	public String addEmployee(@RequestBody Employee emp) {
		employeeRepository.save(emp);
		return "New Employee Added Successfully...";
	}
}
