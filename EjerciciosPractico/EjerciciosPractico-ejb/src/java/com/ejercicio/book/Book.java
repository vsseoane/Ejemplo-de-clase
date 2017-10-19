package com.ejercicio.book;

import com.ejercicio.author.Author;

public class Book {
    public Book() {
    
    }
    
    public String id;
    public String name;
    public Author author;
    public int comision;

    public Book(String id, String name, Author author, int comision) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.comision = comision;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", author=" + author + ", comision=" + comision + '}';
    }
}
