package com.cg.pack.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pack.entities.Account;
import com.cg.pack.entities.ServiceRequest;
import com.cg.pack.service.ServiceRequestServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/serviceRequest")
public class ServiceRequestController {
	
	Logger logger = LoggerFactory.getLogger(ServiceRequestController.class);
	
	@Autowired
	private ServiceRequestServiceImpl serviceRequest;


	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all ServiceRequests")
	public List<ServiceRequest> displayAllRequests() {
		logger.info("Fetching all ServiceRequests");
        return serviceRequest.displayAllRequests();
    }

    public void createRequest(int serviceRequestId, Account accountid) {
        serviceRequest.createServiceRequestForUser(serviceRequestId,accountid );
    }
	
	@PostMapping("/save")
	@ApiOperation("Add a ServiceRequest")
	public ResponseEntity<ServiceRequest> save(@Valid @RequestBody ServiceRequest request) {
		logger.info("Adding a Service Request : " + request);
		ServiceRequest sr = serviceRequest.addRequest(request);
		return new ResponseEntity<>(sr, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	@ApiOperation("Update ServiceRequest")
	public void update(@Valid @RequestBody ServiceRequest request) {
		logger.info("Updating a Service Request!!");
		serviceRequest.updateRequest(request);
	}

}

