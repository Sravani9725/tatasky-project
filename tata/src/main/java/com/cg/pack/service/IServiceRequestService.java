package com.cg.pack.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.pack.entities.Account;
import com.cg.pack.entities.ServiceRequest;

@Service
public interface IServiceRequestService {
	
	ServiceRequest addRequest(ServiceRequest request);
	
	ServiceRequest updateRequest(ServiceRequest request);
	
	public List<ServiceRequest> displayAllRequests();
	
	public void createServiceRequestForUser(int serviceRequestId ,Account accountId);

    
}

