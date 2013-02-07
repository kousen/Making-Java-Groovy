package mjg.rest

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path('/customers')
class CustomerResource {
	CustomerDAO dao = new JdbcCustomerDAO()
	
	@GET @Produces( [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML] )
	List<Customer> findAll() {
		return dao.findAll();
	}

	@GET @Path("search/{query}")
	@Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
	List<Customer> findByName(@PathParam("query") String query) {
		return dao.findByLastName(query);
	}

	@GET @Path("{id}")
	@Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
	Customer findById(@PathParam("id") String id) {
		return dao.findById(Integer.parseInt(id));
	}

	@POST
	@Consumes([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
	@Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
	Customer create(Customer customer) {
		return dao.create(customer);
	}

	@PUT @Path("{id}")
	@Consumes([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
	@Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
	Customer update(Customer customer) {
		dao.update(customer);
		return customer;
	}
	
	@DELETE @Path("{id}")
	@Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
	public void remove(@PathParam("id") int id) {
		dao.delete(id);
	}

}
