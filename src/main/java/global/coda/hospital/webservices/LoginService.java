package global.coda.hospital.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import global.coda.hospital.databasedao.AuthenticationDao;
/**
 * @author VC
 */
@Path("/service")
public class LoginService {
	/**
	 * @param name of user.
	 * @param password name of user.
	 * @return response back.
	 */
	@GET
	@Path("/print/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello(@QueryParam("name") String name, @QueryParam("password") String password) {
		AuthenticationDao auth = new AuthenticationDao();
		String message;
		if (auth.authUser(name, password) != null) {
			message = "login successful";
			return Response.status(Response.Status.OK).entity(message).build();
		} else {
			message = "login failed";
			return Response.status(Response.Status.UNAUTHORIZED).entity(message).build();
		}
	}
}
