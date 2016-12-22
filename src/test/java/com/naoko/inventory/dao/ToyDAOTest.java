package com.naoko.inventory.dao;

import static org.junit.Assert.assertEquals;
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
	/*@Test
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
		hibernateTemplate.save(toy1);
		hibernateTemplate.save(toy2);
		List<Toy> toysRetrieved = toyDAO.getAllToys();
		assertEquals(toysRetrieved.size(), 2);
		for (Toy toy: toysRetrieved) {
			assertEquals();
		}
	}*/
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
}

/*******
public class ToyDAOTest {

	
	
	
	
	@Test
	public void testUpdateToy() {

	}
	@Test
	public void testDeleteToy() {
		
	}
	@Test
	public boolean testToyExists() {
		
	}
}
*******/