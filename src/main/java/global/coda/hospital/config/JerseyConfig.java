package global.coda.hospital.config;

import org.glassfish.jersey.server.ResourceConfig;
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(HelloService.class); 
    }
}