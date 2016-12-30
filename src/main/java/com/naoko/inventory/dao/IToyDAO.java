package com.naoko.inventory.dao;

import java.util.List;
import com.naoko.inventory.entity.Toy;

/**
 * Database communication.  Called from ToyService.  Define interface to create a discoverable bean.
 * 
 * @author	Naoko Huschle
 * @since	2016-12-20
 *
 */

public interface IToyDAO {
    List<Toy> getAllToys();
    Toy getToyById(int tid);
    boolean addToy(Toy toy);
    void updateToy(Toy toy);
    void deleteToy(int pid);
    boolean toyExists(String name, int tid);
}
