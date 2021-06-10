package com.cg.pack.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sr_table")
public class ServiceRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Long serviceRequestId;
	@Column
	@NotNull
	 private LocalDate requestedDate;
	
	// private Account account;
	 @Column
	 @NotNull
	 private String message;
	 
	 
	 
	}
