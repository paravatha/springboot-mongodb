package org.springframework.springboot.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * @author Prasad Paravatha
 * Book Domain class
 */
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private Date publishedDate;
    private Integer pages;
    private String language;
    private Publisher publisher;
    
    public Book() {
    }
    
    public Book(String title, String author, Date publishedDate, 
    		Integer pages, String language, Publisher publisher) {
    	this.title = title;
    	this.author = author;
    	this.publishedDate = publishedDate;
    	this.pages = pages;
    	this.language = language;
    	this.publisher = publisher;
    	
    }

    public Book(Publisher publisher) {
    	this.publisher = publisher;
    }
    
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @return the publishedDate
	 */
	public Date getPublishedDate() {
		return publishedDate;
	}
	/**
	 * @return the pages
	 */
	public Integer getPages() {
		return pages;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @return the publisher
	 */
	public Publisher getPublisher() {
		return publisher;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @param publishedDate the publishedDate to set
	 */
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	/**
	 * @param pages the pages to set
	 */
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Book[id=%s, title='%s', author='%s', publisher=%s]",
                id, title, author, publisher.toString());
    }	
}
