package com.ejercicio.book;

import com.ejercicio.author.Author;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Column(length = 8)
    private String name;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date publicationDate;
  
    @ManyToOne
    private Author author;
    
    @NotNull
    @Column(length = 8)
    private int comision;
    
    public Book() { }

    public Book(Long id, String name, int comision) {
        this.id = id;
        this.name = name;
        this.comision = comision;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

     public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", comision=" + comision + '}';
    }
}
