package com.bharath.spring.springcoreadvanced.stereotyp.annotations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("inst")
@Scope("prototype")
public class Instructor {
	//create an object of type integer
//	@Value("#{new Integer(88) }")
	//to access static variable
//@Value("#{T(java.lang.Math).abs(-99)}")
	@Value("#{T(java.lang.Integer).MIN_VALUE}")
	private int id;// this assignment will not take effect
	//@Value("#{'niki'.toUpperCase()}")
	@Value("#{new java.lang.String('niki mallick')}")
	private String name;
	@Value("#{topics}")
	private List<String> topics;
	@Value("#{2+4>8?true:false}")
	private boolean active;
	@Autowired
	private Profile profile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", topics=" + topics + ", active=" + active + ", profile="
				+ profile + "]";
	}

	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}

}
