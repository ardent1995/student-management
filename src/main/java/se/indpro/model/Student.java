package se.indpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@Column(name = "rollno")
	private Integer rollNo;
	@Column(name="name")
	private String name;
	@Column(name = "department")
	private String department;
	@Column(name="phone")
	private Long phone;
		
	public Student() {
		super();
	}

	public Student(Integer rollNo, String name, String department, Long phone) {
		this();
		this.rollNo = rollNo;
		this.name = name;
		this.department = department;
		this.phone = phone;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
}
