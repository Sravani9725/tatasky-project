package com.cg.pack.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.pack.entities.Pack;

@Repository
public interface PackRepository extends JpaRepository<Pack,Long>{

    
	//public List<Pack> findByAmountGreaterThan(Double amount);
	
	/*
	 * @Query("select p from Pack p order by pack_cost ASC") public List<Pack>
	 * findByOrderBypackCostAsc(Double packCost);
	 */
    
    @Query("SELECT p FROM Pack p ORDER BY pack_validity ASC")
	public List<Pack> findPacksInAscendingOrderByDaysValidity();
    
    @Query("SELECT p FROM Pack p ORDER BY pack_cost DESC")
	public List<Pack> findRechargesCountInDescendingOrder();

    
	public Pack findBypackName(String packName);

	
	
	
	
	

	
}