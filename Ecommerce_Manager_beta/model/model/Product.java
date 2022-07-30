package model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
public Product() {
	
}
	
public Product(String name, String mark, String description, Double price, Long quantity, Category category,
		LocalDateTime createdAt) {
	this.name = name;
	this.mark = mark;
	this.description = description;
	this.price = price;
	this.quantity = quantity;
	this.category = category;
	this.createdAt = createdAt;
}

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="idProduct")
private Integer id;

@Column(name="productName")
private String name;

@Column(name="mark")
private String mark;

@Column(name="description")
private String description;

@Column(name="price")
private Double price;

@Column(name="quantity")
private Long quantity;

@ManyToOne
@JoinColumn(name="idCategory",nullable = false)
private Category category;

@OneToMany(mappedBy="product")
private List<Article> articles;

@OneToMany(mappedBy="product")
private List<Image> images;

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

public String getMark() {
	return mark;
}

public void setMark(String mark) {
	this.mark = mark;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public Long getQuantity() {
	return quantity;
}

public void setQuantity(Long quantity) {
	this.quantity = quantity;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}



public List<Article> getArticles() {
	return articles;
}

public void setArticles(List<Article> articles) {
	this.articles = articles;
}

public List<Image> getImages() {
	return images;
}

public void setImages(List<Image> images) {
	this.images = images;
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
