package com.naoko.inventory.service;

import com.naoko.inventory.dao.IToyDAO;
import com.naoko.inventory.entity.Toy;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class ToyServiceTest {

	@Mock
	private static IToyService toyService;
	@Mock
    private IToyDAO toyDAO;;
	
	@Test
	public void testGetToyById() {
		Toy toy = new Toy();
		toy.setTid(1);
		toy.setName("Barbie Sara");
		toy.setCategory("Doll");
		toy.setPrice(100);
		toy.setDescription("Super cute");
		toy.setStock(2);
		// expected toy
		Mockito.when(toyService.getToyById(1)).thenReturn(toy);
		// check value
		assertEquals(toy, toyService.getToyById(1));
		// verify interaction
		verify(toyService).getToyById(1);
		
	}
	@Test
	public void testGetAllToys(){
		List<Toy> toys = new ArrayList<>();
		Toy toy1 = new Toy();
		toy1.setTid(1);
		toy1.setName("Barbie Sara");
		toy1.setCategory("Doll");
		toy1.setPrice(100);
		toy1.setDescription("Super cute");
		toy1.setStock(2);
		Toy toy2 = new Toy();
		toy2.setTid(2);
		toy2.setName("Barbie Dave");
		toy2.setCategory("Doll");
		toy2.setPrice(100);
		toy2.setDescription("Super handsome");
		toy2.setStock(1);
		toys.add(toy1);
		toys.add(toy2);

		Mockito.when(toyService.getAllToys()).thenReturn(toys);
		assertEquals(2, toyService.getAllToys().size());

	}
	@Test
	public void testAddToy(){
		// toy to create
        Toy toy1 = new Toy();
		toy1.setTid(1);
		toy1.setName("Barbie Sara");
		toy1.setCategory("Doll");
		toy1.setPrice(100);
		toy1.setDescription("Super cute");
		toy1.setStock(2);
                         
        toyService.addToy(toy1);
        Mockito.verify(toyService, Mockito.times(1)).addToy(toy1);
    }
	@Test
	public void testUpdateToy() {
		Toy toy1 = new Toy();
		toy1.setTid(1);
		toy1.setName("Barbie Sara");
		toy1.setCategory("Doll");
		toy1.setPrice(100);
		toy1.setDescription("Super cute");
		toy1.setStock(2);
		Toy toyUpdated = new Toy();
		toyUpdated.setTid(1);
		toyUpdated.setName("Dave Stuffed Animal");
		toyUpdated.setCategory("Stuffed Animal");
		toyUpdated.setPrice(100);
		toyUpdated.setDescription("Super handsome");
		toyUpdated.setStock(1);
		
		Mockito.when(toyService.addToy(toy1)).thenReturn(true);
		toyService.updateToy(toy1);
		Mockito.when(toyService.getToyById(1)).thenReturn(toyUpdated);
		
		assertEquals(toyUpdated, toyService.getToyById(1));
		verify(toyService).updateToy(toy1);
	}
	@Test
	public void testDeleteToy() {
		// toy to delete
        Toy toy1 = new Toy();
		toy1.setTid(1);
		toy1.setName("Barbie Sara");
		toy1.setCategory("Doll");
		toy1.setPrice(100);
		toy1.setDescription("Super cute");
		toy1.setStock(2);
                         
        toyService.deleteToy(toy1.getTid());
        Mockito.verify(toyService, Mockito.times(1)).deleteToy(toy1.getTid());
	}

}

