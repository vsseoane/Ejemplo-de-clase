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
        final Book book = bookBean.GetBook();
        final Gson gson = new Gson();
        final String JSONRepresentation = gson.toJson(book);
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
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putBook(@PathParam("id") String id) {
        try {
            int bookId = Integer.parseInt(id);
            return Response.status(Response.Status.OK).entity("PutBook").build(); 
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El parámetro debe ser un int").build();
        }  
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postBook(String json) {
        try {
            Gson gson = new Gson();
            Book book = gson.fromJson(json, Book.class);
            bookBean.createBook(book);
            return Response.status(Response.Status.OK).entity(book).build(); 
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El libro no pudo ser creado").build();
        }     
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteBook(@PathParam("id") String id) {
        try {
            int bookId = Integer.parseInt(id);
            return Response.status(Response.Status.OK).entity("DeleteBook").build(); 
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El parámetro debe ser un int").build();
        }    
    }
}
