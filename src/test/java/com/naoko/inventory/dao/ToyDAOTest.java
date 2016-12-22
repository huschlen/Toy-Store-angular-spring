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
	public void testAddToy() {
		Toy toy = new Toy();
		toy.setTid(100);
		toy.setName("Toy Added");
		toy.setCategory("Doll");
		toy.setPrice(50);
		toy.setDescription("Super cute");
		toy.setStock(1);
		toyDAO.addToy(toy);
		Toy toyAdded = hibernateTemplate.get(Toy.class, 100);
		assertEquals(toy.getName(), toyAdded.getName());
		assertEquals(toy.getCategory(), toyAdded.getCategory());
	}
}

/*******
public class ToyDAOTest {

	
	@Test
	public Toy testGetToyById() {
		
	} 
	@Test
	public List<Toy> testGetAllToys() {
		
	}	
	@Test
	public boolean testAddToy() {
		
	}
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