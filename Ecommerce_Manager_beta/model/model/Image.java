package model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_image")
public class Image {
	
	public Image() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Image(byte[] image, Product product, LocalDateTime createdAt) {
		super();
		this.image = image;
		this.product = product;
		this.createdAt = createdAt;
	}
	
	



	public Image(byte[] image, Product product, Article article, LocalDateTime createdAt) {
		super();
		this.image = image;
		this.product = product;
		this.article = article;
		this.createdAt = createdAt;
	}





	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="imageId")
	private Integer id;
	
	@Column(name="image")
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name="idProduct",nullable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="idArticle",nullable = true)
	private Article article;
	
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
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
