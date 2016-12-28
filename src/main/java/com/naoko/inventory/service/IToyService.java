package com.naoko.inventory.service;

import java.util.List;
import com.naoko.inventory.entity.Toy;
import com.naoko.inventory.dao.*;

public interface IToyService {
	void setToyDAO (IToyDAO dao);
	List<Toy> getAllToys();
    Toy getToyById(int tid);
    boolean addToy(Toy toy);
    void updateToy(Toy toy);
    void deleteToy(int tid);
}
