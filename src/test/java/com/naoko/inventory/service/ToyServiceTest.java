package com.naoko.inventory.service;

import com.naoko.inventory.dao.IToyDAO;
import com.naoko.inventory.entity.Toy;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Optional;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import org.junit.ClassRule;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class ToyServiceTest {
	
	private static IToyService toyService = Mockito.mock(IToyService.class);
	/*@Test
	public void testGetToyById(int tid) {
		Toy toy = new Toy();
		toy.setId(1);
		Mockito.when(toyService.getToyById(1)).thenReturn(Optional.of(toy));
		
		Response response = RULE
				.getJerseyTest()
				.target("/angular-spring-1/toy-store/toys")
				.path("1")
				.request(MediaType.APPLICATION_JSON)
				.get();
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
		Toy returnedToy = response.readEntity(Toy.class);
		assertEquals(toy, returnedToy);
	}*/
	//@Test
	public void testGetAllToys(){
		toyService.getAllToys();
	}
	//@Test
	public void testAddToy(Toy toy){
		toyService.addToy(toy);
	}
	//@Test
	public void testUpdateToy(Toy toy) {
		toyService.updateToy(toy);
	}
	//@Test
	public void testDeleteToy(int tid) {
		toyService.deleteToy(tid);
	}

}

