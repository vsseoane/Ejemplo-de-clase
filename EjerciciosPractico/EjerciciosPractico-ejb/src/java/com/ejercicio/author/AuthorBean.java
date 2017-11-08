
package com.ejercicio.author;

import com.ejercicio.book.Book;
import com.ejercicio.book.BookBean;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@LocalBean
public class AuthorBean {

   @PersistenceContext
    private EntityManager em;
    
    @EJB
    private BookBean bookBean;

    public List<Author> getAuthors() {
        return em.createQuery("select a from Author a").getResultList();
    }
    
    public Author findAuthorById(Long id) {
        return em.find(Author.class, id);
    }

    public Author createAuthor(Author author) {
        em.persist(author);
        return author;
    }
    
    public Book addBook(Author author, Book book) {
        return bookBean.createBook(author, book);
    }   
}
