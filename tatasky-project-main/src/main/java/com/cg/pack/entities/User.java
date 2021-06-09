package com.cg.pack.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="user_tbl")
public class User {
	@Id
	private long userId;
	
	private String userName;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	
	
}
