package uy.com.library;

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

@Path("author")
public class AuthorResource {

    @Context
    private UriInfo context;

    public AuthorResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthors() {
        return Response.status(Response.Status.OK).entity("GetAuthors").build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthor(@PathParam("id") String id) {
        try {
            int authorId = Integer.parseInt(id);
            return Response.status(Response.Status.OK).entity("GetAuthor").build(); 
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El parámetro debe ser un int").build();
        }
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putAuthor(@PathParam("id") String id) {
        try {
            int authorId = Integer.parseInt(id);
            return Response.status(Response.Status.OK).entity("PutAuthor").build(); 
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El parámetro debe ser un int").build();
        }  
    }
    
    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postAuthor(@PathParam("id") String id) {
        try {
            int authorId = Integer.parseInt(id);
            return Response.status(Response.Status.OK).entity("PostAuthor").build(); 
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El parámetro debe ser un int").build();
        }     
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteAuthor(@PathParam("id") String id) {
        try {
            int authorId = Integer.parseInt(id);
            return Response.status(Response.Status.OK).entity("DeleteAuthor").build(); 
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El parámetro debe ser un int").build();
        }    
    }
    
    @GET
    @Path("{id}/book")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthorBooks(@PathParam("id") String id) {
        try {
            int authorId = Integer.parseInt(id);
            return Response.status(Response.Status.OK).entity("GetAuthorBooks").build(); 
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El parámetro debe ser un int").build();
        }  
    }
}
