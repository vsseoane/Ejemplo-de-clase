/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejercicio.book;

import com.ejercicio.book.Book;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import java.util.List;
import javax.ejb.EJB;

@Path("book")
public class BookController {
   

    @Context
    private UriInfo context;
    
    @EJB
    private BookBean bookBean;

    public BookController() {
    }

   @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks() {
        final List<Book> books = bookBean.getBooks();
        final Gson gson = new Gson();
        final String JSONRepresentation = gson.toJson(books);
        return Response.status(Response.Status.OK).entity(JSONRepresentation).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBook(@PathParam("id") String id) {
        try {
            int bookId = Integer.parseInt(id);
            return Response.status(Response.Status.OK).entity("GetBook").build(); 
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El parámetro debe ser un int").build();
        }
    }
}
