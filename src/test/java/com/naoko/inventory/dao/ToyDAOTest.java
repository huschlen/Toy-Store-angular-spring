package com.naoko.inventory.dao;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.annotation.*;
import com.naoko.inventory.config.TestDAOConfig;
import com.naoko.inventory.dao.IToyDAO;
import com.naoko.inventory.entity.Toy;

/**
 * Integration tests for ToyDAO.
 * 
 * @author	Dave Odalen
 * @author	Naoko Huschle
 * @since	2016-12-20
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDAOConfig.class)
@Rollback
@Transactional
public class ToyDAOTest {
	
	@Autowired
	private IToyDAO toyDAO;
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	@Test
	public void testGetToyById() {
		Toy toy = new Toy();
		toy.setTid(1000);
		toy.setName("Toy");
		toy.setCategory("Doll");
		toy.setPrice(50);
		toy.setDescription("Super cute");
		toy.setStock(1);
		hibernateTemplate.save(toy);
		Toy toyRetrieved = toyDAO.getToyById(1000);
		assertEquals(toy, toyRetrieved);
		assertEquals(toy.getName(), toyRetrieved.getName());
		assertEquals(toy.getCategory(), toyRetrieved.getCategory());	
	}
	@Test
	public void testGetAllToys() {
		List<Toy> toys = new ArrayList<>();
		Toy toy1 = new Toy();
		toy1.setTid(1001);
		toy1.setName("Toy1");
		toy1.setCategory("Game");
		toy1.setPrice(20);
		toy1.setDescription("Super fun");
		toy1.setStock(5);
		Toy toy2 = new Toy();
		toy2.setTid(1002);
		toy2.setName("Toy2");
		toy2.setCategory("Game");
		toy2.setPrice(50);
		toy2.setDescription("Super fun");
		toy2.setStock(3);
		toys.add(toy1);
		toys.add(toy2);
		hibernateTemplate.save(toy1);
		hibernateTemplate.save(toy2);
		List<Toy> toysRetrieved = toyDAO.getAllToys();
		for(Toy toy : toys){
			boolean foundToy = false;
			for(Toy returnedToy : toysRetrieved){
				if(toy.equals(returnedToy)){
					foundToy = true;
					continue;
				}
			}
			assertTrue(foundToy);
		}
	}
	@Test
	public void testAddToy() {
		Toy toy = new Toy();
		toy.setTid(1000);
		toy.setName("Toy1");
		toy.setCategory("Doll");
		toy.setPrice(50);
		toy.setDescription("Super cute");
		toy.setStock(1);
		toyDAO.addToy(toy);
		Toy toyAdded = hibernateTemplate.get(Toy.class, 1000);
		assertEquals(toy.getName(), toyAdded.getName());
		assertEquals(toy.getCategory(), toyAdded.getCategory());
	}
	@Test
	public void testUpdateToy() {
		Toy toy = new Toy();
		toy.setTid(1001);
		toy.setName("Toy1");
		toy.setCategory("Game");
		toy.setPrice(20);
		toy.setDescription("Super fun");
		toy.setStock(5);
		hibernateTemplate.save(toy);
		Toy existingToy = hibernateTemplate.get(Toy.class, 1001);
		existingToy.setName("Toy2");
		existingToy.setCategory("Game");
		existingToy.setPrice(50);
		existingToy.setDescription("Super fun");
		existingToy.setStock(3);
		toyDAO.updateToy(existingToy);
		Toy updatedToy = hibernateTemplate.get(Toy.class, 1001);
		assertEquals("Toy2", updatedToy.getName());
	}
	@Test
	public void testDeleteToy() {
		Toy toy = new Toy();
		toy.setTid(1001);
		toy.setName("Toy1");
		toy.setCategory("Game");
		toy.setPrice(20);
		toy.setDescription("Super fun");
		toy.setStock(5);
		hibernateTemplate.save(toy);
		toyDAO.deleteToy(1001);
		Toy deletedToy = hibernateTemplate.get(Toy.class, 1001);
		assertNull(deletedToy);
	}
	@Test
	public void testToyExists() {
		Toy toy = new Toy();
		toy.setTid(1001);
		toy.setName("Toy1");
		toy.setCategory("Game");
		toy.setPrice(20);
		toy.setDescription("Super fun");
		toy.setStock(5);
		hibernateTemplate.save(toy);
		boolean toyExists = toyDAO.toyExists(toy.getName(), toy.getTid());
		assertTrue(toyExists);
	}

}