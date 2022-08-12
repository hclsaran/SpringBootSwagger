package com.saran.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saran.model.Student;

@RestController
@RequestMapping("/api")
public class SwaggerController {
	
	List<Student> list=new ArrayList<>();
	{
	list.add(new Student("Vijaya","Computer Science","NY"));
	list.add(new Student("Dylan","Mechanical","Santa Clara"));
	list.add(new Student("Carlos","Science","SFO"));
	list.add(new Student("Athul","Civil","NJ"));
	
	}
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		return list;
	}
	
	@GetMapping("/getStudentByName/{name}")
	public Student getStudentByName(@PathVariable("name") String name){
		return list.stream().filter(x->x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
	}
	
	@GetMapping("/getStudentByAddress/{address}")
	public Student getStudentByAddress(@PathVariable("address") String address){
		return  list.stream().filter(x->x.getAddress().equalsIgnoreCase(address)).collect(Collectors.toList()).get(0);
	}
	
	
	
	

}
