package com.cg.pack.service;

import java.util.List;
import java.util.Optional;

import com.cg.pack.entities.Pack;
import com.cg.pack.exception.InvalidInputFormatException;
import com.cg.pack.exception.PackNotFoundException;

public interface IPackservice {

	Pack addPack(Pack pack);

	//Pack updatePack(Pack pack);
	
	Pack findPackById(Long packId) throws PackNotFoundException,InvalidInputFormatException;
	
	Pack findBypackName(String packName) throws PackNotFoundException,InvalidInputFormatException;
	
	//List<Pack> findByAmountGreaterThan(Double amount) throws PackNotFoundException;
	
	List<Pack> findByOrderBypackCostAsc() throws PackNotFoundException;
	
	List<Pack> findPacksInAscendingOrderByDaysValidity()throws PackNotFoundException,InvalidInputFormatException;
	
	List<Pack> popularPacks()throws PackNotFoundException,InvalidInputFormatException;
	
	void deleteByPackId(Long packId) throws PackNotFoundException;
	
	
	
	
	
	
	
}
