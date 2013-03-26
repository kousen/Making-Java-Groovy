package mjg.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/people")
public class PersonResource {
    @Context 
    private UriInfo uriInfo;
    
    private PersonDAO dao = JdbcPersonDAO.getInstance();

    @GET @Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
    public List<Person> findAll() {
        return dao.findAll();
    }

    @GET @Path("lastname/{like}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Person> findByName(@PathParam("like") String like) {
        return dao.findByLastName(like);
    }

    @GET @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findById(@PathParam("id") long id) {
        return Response.ok(dao.findById(id))
            .build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(Person person) {
        dao.create(person);
        UriBuilder builder = UriBuilder.fromUri(uriInfo.getRequestUri()).path("{id}");
        return Response.created(builder.build(person.getId()))
            .entity(person)
            .build();
    }

    @PUT @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Person update(Person person) {
        dao.update(person);
        return person;
    }

    @DELETE @Path("{id}")
    public Response remove(@PathParam("id") long id) {
        dao.delete(id);
        return Response.noContent().build();
    }
}
