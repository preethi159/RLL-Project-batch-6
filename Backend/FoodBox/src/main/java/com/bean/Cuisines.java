package com.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Cuisines {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private String name;
	

    @OneToMany
    @JoinColumn(name="fid")
	List<Food> listOfFood;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Food> getListOfFood() {
		return listOfFood;
	}

	public void setListOfFood(List<Food> listOfFood) {
		this.listOfFood = listOfFood;
	}

	@Override
	public String toString() {
		return "Cuisines [id=" + id + ", name=" + name + ", listOfFood=" + listOfFood + "]";
	}

	

	

	

}
