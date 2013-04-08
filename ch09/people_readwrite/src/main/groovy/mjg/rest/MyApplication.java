package mjg.rest;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {
    public MyApplication() {
        super(PersonResource.class, PersonProvider.class, JacksonFeature.class);
    }
}
