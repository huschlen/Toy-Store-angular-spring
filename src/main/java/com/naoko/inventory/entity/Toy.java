package com.naoko.inventory.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity Toy.
 * 
 * @author	Naoko Huschle
 * @since	2016-12-20
 *
 */

@Entity
@Table(name="toy")
public class Toy implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tid")
	private int tid;
	@Column(name="name")
	private String name;
	@Column(name="category")
	private String category;
	@Column(name="price")
	private int price;
	@Column(name="description")
	private String description;	
	@Column(name="stock")
	private int stock;
	
	public int getTid() {
		return tid;
	}
	
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public boolean equals(Object o) {
	    if(o == null) {
	    	return false;
	    }
	    if(!(o instanceof Toy)) {
	    	return false;
	    }
	    Toy other = (Toy) o;
	    return this.tid == other.tid;
	}
	@Override
	public int hashCode(){
	    return (int) tid;
	}

}