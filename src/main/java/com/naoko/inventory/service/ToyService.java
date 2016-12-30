package com.naoko.inventory.service;

import com.naoko.inventory.dao.IToyDAO;
import com.naoko.inventory.entity.Toy;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service between the controller and DAO.
 * Called from ToyController.  Calls ToyDAO.
 * 
 * @author	Naoko Huschle
 * @since	2016-12-20
 *
 */

@Service
public class ToyService implements IToyService {
	@Autowired
	private IToyDAO toyDAO;
	@Override
	public void setToyDAO(IToyDAO dao) {
		this.toyDAO = dao;
	}
	@Override
	public Toy getToyById(int tid) {
		Toy obj = toyDAO.getToyById(tid);
		return obj;
	}	
	@Override
	public List<Toy> getAllToys(){
		return toyDAO.getAllToys();
	}
	@Override
	public synchronized boolean addToy(Toy toy){
		if (toyDAO.toyExists(toy.getName(), toy.getTid())) {
			return false;
		} else {
			toyDAO.addToy(toy);
			return true;
		}
	}
	@Override
	public void updateToy(Toy toy) {
		toyDAO.updateToy(toy);
	}
	@Override
	public void deleteToy(int tid) {
		toyDAO.deleteToy(tid);
	}

}
