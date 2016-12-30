package com.naoko.inventory.service;

import java.util.List;
import com.naoko.inventory.entity.Toy;
import com.naoko.inventory.dao.*;

/**
 * Service between the controller and DAO.
 * Called from ToyController.  Calls ToyDAO.
 * Define interface to create a discoverable bean.
 * 
 * @author	Naoko Huschle
 * @since	2016-12-20
 *
 */

public interface IToyService {
	void setToyDAO (IToyDAO dao);
	List<Toy> getAllToys();
    Toy getToyById(int tid);
    boolean addToy(Toy toy);
    void updateToy(Toy toy);
    void deleteToy(int tid);
}
