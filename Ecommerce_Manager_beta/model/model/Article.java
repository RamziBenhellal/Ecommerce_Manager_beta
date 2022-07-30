package model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Article {
	public Article() {
		
	}

	
	public Article(Double price, Long quantity, Product product, Size size, Color color,
			LocalDateTime createdAt) {
		this.price = price;
		this.quantity = quantity;
		this.product = product;
		this.size = size;
		this.color = color;
		this.createdAt = createdAt;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idArticle")
	private Integer id;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="quantity")
	private Long quantity;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="idSize")
	private Size size;
	
	@ManyToOne
	@JoinColumn(name="idColor")
	private Color color;
	
	@OneToMany(mappedBy="article")
	private List<Image> images;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "order_article", 
        joinColumns = { @JoinColumn(name = "idArticle") }, 
        inverseJoinColumns = { @JoinColumn(name = "idOrder") }
    )
    List<Order> orders ;
	
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



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public Size getSize() {
		return size;
	}



	public void setSize(Size size) {
		this.size = size;
	}



	public Color getColor() {
		return color;
	}



	public void setColor(Color color) {
		this.color = color;
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
