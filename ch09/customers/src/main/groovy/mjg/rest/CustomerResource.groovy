package mjg.rest

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path('/customers')
class CustomerResource {
    @Context 
    private UriInfo uriInfo
    
    CustomerDAO dao = new JdbcCustomerDAO()

    @GET @Produces( [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML] )
    List<Customer> findAll() {
        dao.findAll();
    }

    @GET @Path("search/{query}")
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    List<Customer> findByName(@PathParam("query") String query) {
        dao.findByLastName(query);
    }

    @GET @Path("{id}")
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    Response findById(@PathParam("id") String id) {
        Response.ok(dao.findById(Integer.parseInt(id)))
            .build()
    }

    @POST
    @Consumes([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    Response create(Customer customer) {
        dao.create(customer);
        UriBuilder builder = UriBuilder.fromUri(uriInfo.requestUri).path("{id}")
        Response.created(builder.build(customer.id))
            .entity(customer)
            .build()
    }

    @PUT @Path("{id}")
    @Consumes([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    Customer update(Customer customer) {
        dao.update(customer);
        customer;
    }

    @DELETE @Path("{id}")
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    Response remove(@PathParam("id") int id) {
        dao.delete(id);
        Response.noContent().build()
    }
}
