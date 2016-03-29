package com.example.ex04;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(schema = "books.public", name = "Book")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = true)
    private Float price;
    @Column(nullable = true)
    private String description;
    @Column(nullable = true)
    private Integer nbofpage;
    @Column(nullable = true)
    private Boolean illustrations;
    
    
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getnbofpage() {
        return nbofpage;
    }

    public void setnbofpage(Integer nbOfPage) {
        this.nbofpage = nbOfPage;
    }

    public Boolean getIllustrations() {
        return illustrations;
    }

    public void setIllustrations(Boolean illustrations) {
        this.illustrations = illustrations;
    }

}
