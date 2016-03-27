package com.example.ex02;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ManagedBean(name = "studentBean", eager = true)
@RequestScoped
@Component
public class StudentBean {
	
	private String name;
	private Integer id;
	
	@Autowired
	public StudentService userService;

	public String fetchStudent() {
		name = userService.getStudent(id);
		return "output";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
