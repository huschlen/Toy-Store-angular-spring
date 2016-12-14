package com.naoko.inventory.service;

import java.util.List;
import com.naoko.inventory.entity.Toy;

public interface IToyService {
	List<Toy> getAllToys();
    Toy getToyById(int tid);
    boolean addToy(Toy toy);
    void updateToy(Toy toy);
    void deleteToy(int tid);
}
