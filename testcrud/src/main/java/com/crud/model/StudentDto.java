package com.crud.model;

import java.util.List;

public class StudentDto {
private long id;
private String name;
private String address;
		    private List<Long> subjectIds;  // List of Subject IDs instead of full Subject objects
			public long getId() {
				return id;
			}
			public void setId(long id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getAddress() {
				return address;
			}
			public void setAddress(String address) {
				this.address = address;
			}
			public List<Long> getSubjectIds() {
				return subjectIds;
			}
			public void setSubjectIds(List<Long> subjectIds) {
				this.subjectIds = subjectIds;
			}

	   
	}
