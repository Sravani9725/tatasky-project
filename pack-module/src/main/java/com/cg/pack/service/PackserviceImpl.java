package com.cg.pack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pack.entities.Pack;
import com.cg.pack.exception.InvalidInputFormatException;
import com.cg.pack.exception.PackNotFoundException;
import com.cg.pack.repository.PackRepository;

@Service
public class PackserviceImpl implements IPackservice {

	Logger logger = LoggerFactory.getLogger(PackserviceImpl.class);
	public List<Pack> packList;

	@Autowired
	public PackRepository repository;

	@Override
	public Pack addPack(Pack pack) {
		logger.info(pack.getPackName());

	    packList = new ArrayList<Pack>();
		packList.add(pack);
		return repository.save(pack);

	}

	/*
	 * /@Override public Pack updatePack(Pack pack) {
	 * 
	 * logger.info("Update pack"); // 1.present 2. what to update 3.change pack name
	 * (getter)
	 * 
	 * Pack entity = repository.findBypackName(pack.getPackName());
	 * 
	 * 
	 * 
	 * if(entity.isPresent()) { entity.setPackCost(0);
	 * pack.setPackCost(pack.getPackCost());
	 * pack.setPackDescription(pack.getPackDescription());
	 * pack.setPackName(pack.getPackName());
	 * pack.setPackValidity(pack.getPackValidity());
	 * 
	 * return repository.save(pack);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * return repository.save(pack); }
	 */
	@Override
	public Pack findPackById(Long PackId) throws PackNotFoundException {

		logger.info("FindPackById");

		Optional<Pack> pack = repository.findById(PackId);

		if (pack.isPresent()) {
			return pack.get();
		} else {
			throw new PackNotFoundException();
		}
	}

	@Override
	public Pack findBypackName(String packName) throws PackNotFoundException {

		logger.info("Find Pack By Name");

		return repository.findBypackName(packName);

	}

	/*@Override
	public List<Pack> findByAmountGreaterThan(Double amount) throws PackNotFoundException {

		logger.info("Find Packs Greater Than The Amount");

		List<Pack> pack = repository.findByAmountGreaterThan(amount);
		return pack;

	}*/

	@Override
	public List<Pack> findByOrderBypackCostAsc() {

		logger.info("Find Packs In Ascending Order By Cost");
		List<Pack> packs = repository.findAll();
		Collections.sort(packs);
		return packs;
		
		
		
	}

	@Override
	public List<Pack> findPacksInAscendingOrderByDaysValidity() {

		logger.info("Find Packs In Ascending Order By Validity");

		List<Pack> pack = repository.findPacksInAscendingOrderByDaysValidity();
		return pack;
	}

	@Override
	public List<Pack> popularPacks() {

		logger.info("Popular Packs");

		return repository.findRechargesCountInDescendingOrder();
	}

	@Override
	public void deleteByPackId(Long packId) throws PackNotFoundException {

		logger.info("Delete Pack");

		Optional<Pack> pack = repository.findById(packId);

		if (pack.isPresent()) {
			repository.deleteById(packId);
		} else {
			throw new PackNotFoundException();
		}
	}

}
