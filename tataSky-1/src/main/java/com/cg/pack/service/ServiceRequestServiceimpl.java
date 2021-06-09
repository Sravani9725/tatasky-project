
package com.cg.pack.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.pack.entities.Account;
import com.cg.pack.entities.ServiceRequest;
import com.cg.pack.repository.IServiceRequestRepository;


@Service
public class ServiceRequestServiceimpl implements IServiceRequestService {
	
	 private List<ServiceRequest> requests;
	    private ServiceRequest selectedRequest = null;
	
	Logger logger = LoggerFactory.getLogger(ServiceRequestServiceimpl.class);
	
	@Autowired
	private IServiceRequestRepository repository;
	
	
	
	@Override
	
	public ServiceRequest addRequest(ServiceRequest request) {
		logger.info("inside addRequest method of ServiceRequestServiceImpl");
		return repository.save(request);
	}

	@Override
	public ServiceRequest updateRequest(ServiceRequest request) {
		return repository.save(request);
	}
	
	@Override
	public List<ServiceRequest> displayAllRequests() {
        return requests;
    }
	
	@Override
	
	public void createServiceRequestForUser(int serviceRequestId , Account accountId) {
		ServiceRequest request = new ServiceRequest();
		requests.add(request);
		
	}

 }
