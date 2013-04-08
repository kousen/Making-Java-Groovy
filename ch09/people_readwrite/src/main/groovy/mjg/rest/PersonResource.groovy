package mjg.rest

import java.util.List

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.Context
import javax.ws.rs.core.Link
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

@Path('/people')
class PersonResource {
    @Context 
    private UriInfo uriInfo
    
    PersonDAO dao = JdbcPersonDAO.instance

    @GET @Produces( [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML] )
    Response findAll() {
        def people = dao.findAll();
        Response.ok(people).link(uriInfo.requestUri, 'self').build()
    }

    @GET @Path("lastname/{like}")
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    List<Person> findByName(@PathParam("like") String like) {
        dao.findByLastName(like);
    }

    @GET @Path("{id}")
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    Response findById(@PathParam("id") long id) {
        Person p = dao.findById(id)
        getLinks(id).each { link ->
            p."${link.rel}" = link   // structural links
        }
        Response.ok(p)
            .links(getLinks(id))     // transitional links
            .build()
    }
    
    private Link[] getLinks(long id) {
        long minId = dao.minId
        long maxId = dao.maxId
        UriBuilder builder = UriBuilder.fromUri(uriInfo.requestUri)
        Link self = Link.fromUri(builder.build()).rel('self').build()
        String uri = builder.build().toString() - "/$id"
        switch (id) {
        case minId:
            Link next = Link.fromUri("${uri}/${id + 1}").rel('next').build()
            return [self, next]
            break
        case maxId:
            Link prev = Link.fromUri("${uri}/${id - 1}").rel('prev').build()
            return [prev, self]
            break
        default:
            Link next = Link.fromUri("${uri}/${id + 1}").rel('next').build()
            Link prev = Link.fromUri("${uri}/${id - 1}").rel('prev').build()
            return [prev, self, next]
        }
    }

    @POST
    @Consumes([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    Response create(Person person) {
        dao.create(person);
        UriBuilder builder = UriBuilder.fromUri(uriInfo.requestUri).path("{id}")
        Response.created(builder.build(person.id))
            .entity(person)
            .build()
    }

    @PUT @Path("{id}")
    @Consumes([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    Person update(Person person) {
        dao.update(person);
        person;
    }

    @DELETE @Path("{id}")
    Response remove(@PathParam("id") long id) {
        dao.delete(id);
        Response.noContent().build()
    }
}
