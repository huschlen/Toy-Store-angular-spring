package com.naoko.inventory.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.naoko.inventory.entity.Toy;

/**
 * Database communication.  Called from ToyService.
 * 
 * @author	Naoko Huschle
 * @since	2016-12-20
 *
 */

@Transactional
@Repository
public class ToyDAO implements IToyDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public Toy getToyById(int tid) {
		return hibernateTemplate.get(Toy.class, tid);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Toy> getAllToys() {
		String hql = "FROM Toy as t ORDER BY t.tid";
		return (List<Toy>) hibernateTemplate.find(hql);
	}	
	@Override
	public boolean addToy(Toy toy) {
		hibernateTemplate.save(toy);
		return false;
	}
	@Override
	public void updateToy(Toy toy) {
		Toy t = getToyById(toy.getTid());
		t.setName(toy.getName());
		t.setCategory(toy.getCategory());
		t.setPrice(toy.getPrice());
		t.setDescription(toy.getDescription());
		t.setStock(toy.getStock());
		t.setTid(toy.getTid());
		hibernateTemplate.update(t);
	}
	@Override
	public void deleteToy(int tid) {
		hibernateTemplate.delete(getToyById(tid));
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean toyExists(String name, int tid) {
		String hql = "FROM Toy as t WHERE t.name = ? and t.tid = ?";
		List<Toy> toys = (List<Toy>) hibernateTemplate.find(hql, name, tid);
		return toys.size() > 0 ? true : false;
	}
}