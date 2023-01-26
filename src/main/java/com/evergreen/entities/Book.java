package com.evergreen.entities;

import java.util.Base64;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.evergreen.entities.Category;

@Entity
@Table(name = "Book", catalog = "sMcqlb29NL", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
@NamedQueries({ @NamedQuery(name = "Book.findAll", query = "select u from Book u"),
		@NamedQuery(name = "Book.findByTitle", query = "select u from Book u where u.title = :title"),
		@NamedQuery(name = "Book.countAll", query = "select count(*) from Book u"),
		@NamedQuery(name = "Book.findBycategory", query = "select u from Book u JOIN Category c on u.category.categoryId = c.categoryId and c.categoryId = :catId")})

public class Book implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	@ManyToOne
	private Category category;
	private String title;
	private String author;
	private String description;
	private String isbn;
	private byte[] image;
	private String base64Image;
	private float price;
	private Date publishDate;

	public Book() {
	}

	public Book(Category category, String title, String author, String description, String isbn, byte[] image,
			float price, Date publishDate) {
		super();
		this.category = category;
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.image = image;
		this.price = price;
		this.publishDate = publishDate;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	public String getBase64Image() {
		this.base64Image = Base64.getEncoder().encodeToString(this.image);
		return this.base64Image;
	}
	
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

}
