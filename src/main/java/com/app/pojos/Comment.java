package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "comment_tbl")
public class Comment extends BaseEntity {
	private String author;//this or user? or vendor?
	private String comment;
	private LocalDate commentDate;
	@ManyToOne
	@JoinColumn(name = "misc_id")
	private Misc misc;
	public Comment(String author, String comment, LocalDate commentDate, Misc misc) {
		super();
		this.author = author;
		this.comment = comment;
		this.commentDate = commentDate;
		this.misc = misc;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDate getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(LocalDate commentDate) {
		this.commentDate = commentDate;
	}
	public Misc getMisc() {
		return misc;
	}
	public void setMisc(Misc misc) {
		this.misc = misc;
	}
	@Override
	public String toString() {
		return "Comment [author=" + author + ", comment=" + comment + ", commentDate=" + commentDate + "]";
	}

}
