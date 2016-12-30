package com.naoko.inventory.service;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.naoko.inventory.config.TestDAOConfig;
import com.naoko.inventory.dao.IToyDAO;
import com.naoko.inventory.dao.ToyDAO;
import com.naoko.inventory.service.IToyService;
import com.naoko.inventory.service.ToyService;
import com.naoko.inventory.controller.ToyController;
import com.naoko.inventory.entity.Toy;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert.*;
import org.springframework.http.HttpStatus;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.*;


 /**
 * Unit tests for ToyService
 * 
 * @author	Naoko Huschle
 * @since	2016-12-25
 *
 */

public class ToyServiceTest {
	
    @Mock
    private IToyService toyService;
    @Mock
    private IToyDAO toyDAO;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        toyService = new ToyService();
        toyService.setToyDAO(toyDAO);
    }
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
		Mockito.when(toyDAO.getToyById(1)).thenReturn(toy);
		// check the value
		assertEquals(toy, toyService.getToyById(1));
		// verify interaction
		verify(toyDAO).getToyById(1);
    } 
    @Test
    public void testGetAllToys() {
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
		// expected toys
		Mockito.when(toyDAO.getAllToys()).thenReturn(toys);
		// check if we have gotten them all
		assertEquals(2, toyService.getAllToys().size());
		// make sure that toyDAO method was called
		Mockito.verify(toyDAO).getAllToys();
    }
    @Test
	public void testAddToy(){
		// toy to add
		Toy toy1 = new Toy();
		toy1.setTid(1);
		toy1.setName("Barbie Sara");
		toy1.setCategory("Doll");
		toy1.setPrice(100);
		toy1.setDescription("Super cute");
		toy1.setStock(2);
		// add a toy
		Mockito.when(toyDAO.addToy(toy1)).thenReturn(true);
		assertTrue(toyService.addToy(toy1));
		Mockito.verify(toyDAO, Mockito.times(1)).addToy(toy1);
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
		Mockito.when(toyDAO.addToy(toy1)).thenReturn(true);
		toyService.updateToy(toy1);
		Mockito.when(toyDAO.getToyById(1)).thenReturn(toyUpdated);	
		assertEquals(toyUpdated, toyService.getToyById(1));
		verify(toyDAO).updateToy(toy1);
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
		Mockito.verify(toyDAO, Mockito.times(1)).deleteToy(toy1.getTid());
	}

}