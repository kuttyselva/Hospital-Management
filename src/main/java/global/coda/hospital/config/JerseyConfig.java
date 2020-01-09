package global.coda.hospital.config;

import org.glassfish.jersey.server.ResourceConfig;

import global.coda.hospital.webservices.LoginService;

/**
 * @author VC
 *
 */
public class JerseyConfig extends ResourceConfig {
	/**
	 * constructor.
	 */
	public JerseyConfig() {
		register(LoginService.class);
	}
}