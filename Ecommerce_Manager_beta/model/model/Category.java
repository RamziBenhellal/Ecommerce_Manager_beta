package model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	
public Category() {
	// TODO Auto-generated constructor stub
}


	
public Category(String name, LocalDateTime createdAt) {
	this.name = name;
	this.createdAt = createdAt;
}



@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="idCategory")
private Integer id;

@Column(name="categoryName")
private String name;

@OneToMany(mappedBy="category")
private List<Product> products;

@Column(name="created_at")
private LocalDateTime createdAt;

@Column(name="updated_at")
private LocalDateTime updatedAt;

public Integer getId() {
	return id;
}



public void setId(Integer id) {
	this.id = id;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public List<Product> getProducts() {
	return products;
}



public void setProducts(List<Product> products) {
	this.products = products;
}



public LocalDateTime getCreatedAt() {
	return createdAt;
}



public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
}



public LocalDateTime getUpdatedAt() {
	return updatedAt;
}



public void setUpdatedAt(LocalDateTime updatedAt) {
	this.updatedAt = updatedAt;
}



}
