package com.ps.email;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.helper.Helper;
import com.ps.model.Employee;
import com.ps.repo.EmployeeRepository;


@Service
public class ExcelService {
	
	@Autowired
	private EmployeeRepository repo;
	
	public ByteArrayInputStream getActualData() throws IOException {
		List<Employee> all = repo.findAll();
		ByteArrayInputStream byteArrayInputStream = Helper.dataToExcel(all);
		
		return byteArrayInputStream;
	}

}
