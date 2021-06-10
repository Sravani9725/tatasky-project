package com.cg.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.pack.entities.ServiceRequest;

public interface IServiceRequestRepository extends JpaRepository<ServiceRequest, Long>{

}
