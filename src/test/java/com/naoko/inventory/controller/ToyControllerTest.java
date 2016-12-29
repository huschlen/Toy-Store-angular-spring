package com.naoko.inventory.controller;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.springframework.util.Assert.*;
import com.naoko.inventory.config.TestDAOConfig;
import com.naoko.inventory.controller.ToyController;
import com.naoko.inventory.service.IToyService;
import com.naoko.inventory.service.ToyService;
import com.naoko.inventory.controller.ToyController;
import com.naoko.inventory.entity.Toy;
import static org.mockito.Mockito.*;
import org.mockito.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for ToyController.
 * 
 * @author	Dave Odalen
 * @author 	Naoko Huschle
 * @since   2016-12-27
 *
 */

public class ToyControllerTest {
	
	@InjectMocks
    private ToyController toyController;
    @Mock
    private IToyService toyService;    
    @Mock
    private Toy toy1;
    @Mock
    private Toy toy2;
    private UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance().path("localhost:8080/angular-spring-1");

    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
        toyController = new ToyController();
        toyController.setToyService(toyService);
    }
    @Test
    public void testGetToyById() {
        Mockito.when(toyService.getToyById(1)).thenReturn(this.toy1);
		ResponseEntity response = toyController.getToyById(1);
		// check that status code was 200
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        // make sure the response has a body
        Assert.assertTrue(response.hasBody());
        // make sure we have gotten the right toy
        Assert.assertEquals(this.toy1, response.getBody());
        // make sure that toyService method was called with correct parameter
        Mockito.verify(toyService).getToyById(1);
    } 
    @Test
    public void testGetAllToys() {
    	List<Toy> toys = new ArrayList<>();
		toys.add(this.toy1);
		toys.add(this.toy2);
        Mockito.when(toyService.getAllToys()).thenReturn(toys);
		ResponseEntity response = toyController.getAllToys();
		// check that status code was 200
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        // make sure the response has a body
        Assert.assertTrue(response.hasBody());
        // make sure we have gotten the right toys
        Assert.assertEquals(toys, response.getBody());
        // make sure that toyService method was called
        Mockito.verify(toyService).getAllToys();
    }
	@Test
	public void testToyService() {
		ResponseEntity response = toyController.toyService(this.toy1, uriComponentsBuilder);
		// check that status code was HttpStatus.CREATED
		Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
		// make sure that toyService method was called with correct parameter
		Mockito.verify(toyService).addToy(this.toy1);
   }
    @Test
    public void testUpdateToy() {
		this.toy1.setTid(1);
		this.toy1.setName("Barbie Sara");
		this.toy1.setCategory("Doll");
		this.toy1.setPrice(100);
		this.toy1.setDescription("Super cute");
		this.toy1.setStock(2);
		this.toy2.setTid(1);
		this.toy2.setName("Dave Stuffed Animal");
		this.toy2.setCategory("Stuffed Animal");
		this.toy2.setPrice(100);
		this.toy2.setDescription("Super handsome");
		this.toy2.setStock(1);	
		Mockito.when(toyService.addToy(this.toy1)).thenReturn(true);
		ResponseEntity response = toyController.updateToy(this.toy1);
		// check that status code was 200
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        // make sure the response has a body
        Assert.assertTrue(response.hasBody());
        // make sure that toyService method was called
		verify(toyService).updateToy(this.toy1);   	
    }
    @Test
    public void testDeleteToy() {
    	this.toy1.setTid(1);
    	Mockito.when(toyService.addToy(this.toy1)).thenReturn(true);
		ResponseEntity response = toyController.deleteToy(1);
		// check that the toy is deleted
        Assert.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        // make sure that toyService method was called
		verify(toyService).deleteToy(1);  
    }

}