package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Misc extends BaseEntity {
	private int rating;
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Comment> comments = new ArrayList<>(); 

	public Misc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Misc(int rating, List<Comment> comments) {
		super();
		this.rating = rating;
		this.comments = comments;
	
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Misc [rating=" + rating + "]";
	}
	
	
	
	
}
