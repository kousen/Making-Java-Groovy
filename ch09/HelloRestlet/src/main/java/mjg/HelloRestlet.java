package mjg;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;

public class HelloRestlet {
	public static void main(String[] args) throws Exception {
		Server server = new Server(Protocol.HTTP, 8182, new Restlet() {
			@Override
			public void handle(Request request, Response response) {
				response.setEntity("Hello, World", MediaType.TEXT_PLAIN);
			}
		});
		
		server.start();
		
		new ClientResource("http://localhost:8182").get().write(System.out);
		
		server.stop();
	}
}
