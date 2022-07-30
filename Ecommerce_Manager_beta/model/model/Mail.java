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
@Table(name = "mail")
public class Mail {
	
	public Mail() {
		// TODO Auto-generated constructor stub
	}

	public Mail(Admin sender, Admin recipient, String subject, String mail, LocalDateTime createdAt) {
		this.sender = sender;
		this.recipient = recipient;
		this.subject = subject;
		this.mail = mail;
		this.createdAt = createdAt;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mailId")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="senderId",nullable = true)
	private Admin sender;
	
	@ManyToOne
	@JoinColumn(name="recipientId",nullable = false)
	private Admin recipient;
	
	
	@Column(name="subject")
	String subject;
	
	
	@Column(name="mail")
	String mail;
	
	
	@Column(name="created_at")
	private LocalDateTime createdAt;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Admin getSender() {
		return sender;
	}

	public void setSender(Admin sender) {
		this.sender = sender;
	}

	public Admin getRecipient() {
		return recipient;
	}

	public void setRecipient(Admin recipient) {
		this.recipient = recipient;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
}
