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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.boot.test.SpringApplicationConfiguration;(deprecated)
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;(Use WebMvcTest for testing controller)
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.sun.jersey.api.client.ClientResponse;

@RunWith(MockitoJUnitRunner.class)
public class ToyServiceTest {

	private Toy toy = new Toy();
	private static IToyService toyService;
	@Mock
    private IToyDAO toyDAO;
	
	@Before
	public void setup() {
		this.toyService; = Mockito.mock(IToyService.class);
	}

    @Test
	 public void testResponsesOnFind() {
	 //simulate Person ID = 1 in the DB
	 when(dao.findByPrimaryKey(1)).thenReturn(new Person(1,"John","Doe",null));
	 
	 //test response when ID exists
	 Response found = service.find(1);
	 assertEquals(200, found.getStatus());
	 
	 //test response when ID does not exist in DB
	 Response notFound = service.find(999);
	 assertEquals(404, notFound.getStatus());
	 }
	
	@Test
	public void testGetToyById() {
		this.toy.setId(1);
		this.toy.setName("Motoko");
		this.toy.setCategory("Doll");
		this.toy.setPrice(100);
		this.toy.setDescription("Super cute");
		this.toy.setStock(2);
		// expected toy
		when(toyService.getToyById(1)).thenReturn(Optional.of(toy));
		// check value
		assertEquals(toy, toyService.getToyById(1));
		// verify interaction
		verify.toyService.getToyById(1));
		
	}
	//@Test
	/*public void testGetAllToys(){
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
	}*/

}

