package com.example.employeeservice.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	 @GetMapping("/info")
	    public String getInfo(@RequestHeader(value = "X-Request-Gateway", required = false) String header) {
	        return "Employee Info. Gateway Header: " + header;
	    }

}
