package com.naoko.inventory.service;

import com.naoko.inventory.dao.IToyDAO;
import com.naoko.inventory.entity.Toy;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*******
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.Mockito;
*******/

/*******
public class ToyServiceTest implements IToyService {
	private static IToyService toyDao = Mockito.mock(IToyService.class);
	@Test
	public Toy testGetToyById(int tid) {
		Toy obj = toyDAO.getToyById(tid);
		return obj;
	}	
	@Test
	public List<Toy> testGetAllToys(){
		return toyDAO.getAllToys();
	}
	@Test
	public synchronized boolean testAddToy(Toy toy){
		if (toyDAO.toyExists(toy.getName(), toy.getTid())) {
			return false;
		} else {
			toyDAO.addToy(toy);
			return true;
		}
	}
	@Test
	public void testUpdateToy(Toy toy) {
		toyDAO.updateToy(toy);
	}
	@Test
	public void testDeleteToy(int tid) {
		toyDAO.deleteToy(tid);
	}

}
*******/
