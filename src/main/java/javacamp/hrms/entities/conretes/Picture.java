package javacamp.hrms.entities.conretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String pictureName;
	
	@Column(name="picture_url")
	private String pictureUrl;
	
	@Column(name="picture_id")
	private String pictureId;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;

	public Picture() {
		
	}

	public Picture(int id, String pictureName, String pictureUrl, String pictureId, User user) {
		super();
		this.id = id;
		this.pictureName = pictureName;
		this.pictureUrl = pictureUrl;
		this.pictureId = pictureId;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getPictureId() {
		return pictureId;
	}

	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
