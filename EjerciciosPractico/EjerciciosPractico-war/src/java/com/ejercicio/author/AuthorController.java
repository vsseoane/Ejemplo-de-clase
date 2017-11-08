package com.ejercicio.author;

import com.ejercicio.book.Book;
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
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.EJB;

@Path("author")
public class AuthorController {
    private Gson gson;
    @Context
    private UriInfo context;
    @EJB
    private AuthorBean authorBean;

    /**
     * Creates a new instance of Author
     */
    public AuthorController() {
        gson = new Gson();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthors() {
        final List<Author> authors = authorBean.getAuthors();
        final Gson gson = new Gson();
        final String JSONRepresentation = gson.toJson(authors);
        return Response.status(Response.Status.OK).entity(JSONRepresentation).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthor(@PathParam("id") String id) {
        try {
            Long authorId = Long.parseLong(id);
            Author author = authorBean.findAuthorById(authorId);
            return Response.status(Response.Status.OK).entity(author).build(); 
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El parámetro debe ser un int").build();
        }
    }
    
    /*@PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putAuthor(@PathParam("id") String id) {
        try {
            int authorId = Integer.parseInt(id);
            return Response.status(Response.Status.OK).entity("PutAuthor").build(); 
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El parámetro debe ser un int").build();
        }  
    }*/
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postAuthor(String jsonAuthor) {
        try {
           Gson gson = new Gson();
           Author author = gson.fromJson(jsonAuthor, Author.class);
           Author createdAuthor = authorBean.createAuthor(author);
            return Response.status(Response.Status.OK).entity(createdAuthor).build(); 
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El parámetro debe ser un int").build();
        }     
    }
    
    @POST
    @Path("/{id}/books")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postBook(@PathParam("id") Long id, String json) {
        Gson dateGson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Author author = authorBean.findAuthorById(id);
        Book book = authorBean.addBook(author, dateGson.fromJson(json, Book.class));
        return Response.status(Response.Status.CREATED).entity(book).build();
    }
    
    /*@DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteAuthor(@PathParam("id") String id) {
        try {
            int authorId = Integer.parseInt(id);
            return Response.status(Response.Status.OK).entity("DeleteAuthor").build(); 
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El parámetro debe ser un int").build();
        }    
    }*/
    
    /*@GET
    @Path("{id}/book")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthorBooks(@PathParam("id") String id) {
        try {
            int authorId = Integer.parseInt(id);
            return Response.status(Response.Status.OK).entity("GetAuthorBooks").build(); 
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El parámetro debe ser un int").build();
        }  
    }*/
}
