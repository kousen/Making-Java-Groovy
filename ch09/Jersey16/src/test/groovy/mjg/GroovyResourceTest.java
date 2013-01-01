package mjg;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;

public class GroovyResourceTest extends JerseyTest {

	public GroovyResourceTest() {
		super("mjg");
	}

	@Test
	public void testShow() {
		WebResource webResource = resource();
		String responseMsg = webResource.path("helloworld").get(String.class);
		assertEquals("Hello, World!", responseMsg);
	}

}

