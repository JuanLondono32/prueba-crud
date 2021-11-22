package co.edu.uis;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
    private @Id @GeneratedValue Long id;
    private String title;
	private String author;
    private String lang;
	private String genre;
	private int pages;
    
    
    public Book() {
    	
    }

	public Book(String title, String author, String lang, String genre, int pages) {
		this.title = title;
		this.author = author;
		this.lang = lang;
		this.genre = genre;
		this.pages = pages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

    @Override
    public boolean equals(Object o) {
    	if (this==o) return true;
    	
    	if(!(o instanceof Book)) return false;
    	
    	Book u = (Book) o;
    	
    	return (comparar(u));
    }
    
    private boolean comparar (Book u) {
    	if(u.id==this.id && u.title==this.title && u.lang== this.lang && u.genre==this.genre && u.pages==this.pages) {
    		return true;
    	}
    	return false;
    }
}
