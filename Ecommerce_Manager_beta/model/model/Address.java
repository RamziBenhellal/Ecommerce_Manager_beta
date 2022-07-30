 package model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	public Address() {
	}
	
	public Address(String street, String hausNumber, String postalCode, String city, String land, Client client,
			LocalDateTime createdAt) {
		this.street = street;
		this.hausNumber = hausNumber;
		this.postalCode = postalCode;
		this.city = city;
		this.land = land;
		this.client = client;
		this.createdAt = createdAt;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idAddress")
	private Integer id;
	
	@Column(name="street")
	private String street;
	
	@Column(name="hausNumber")
	private String hausNumber;
	
	@Column(name="postalCode")
	private String postalCode;
	
	@Column(name="city")
	private String city;
	
	@Column(name="land")
	private String land;
	
	@OneToOne(mappedBy="address")
	private Client client;
	
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHausNumber() {
		return hausNumber;
	}

	public void setHausNumber(String hausNumber) {
		this.hausNumber = hausNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
	
	@Override
	public String toString() {
		
		return this.street + " " + this.hausNumber + "\n "+ this.postalCode + " "+ this.city + " \n" + this.land;
	}
	
	
	

}
