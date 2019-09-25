package global.coda.hospital.services;

import java.util.List;

import global.coda.hospital.databasedao.AuthenticationDao;

public class UserAuthentication {
	
	public List<Integer> userauth(String username,String password) {
		/*
		 * connects dao layer to get role id of user
		 */
		AuthenticationDao auth=new AuthenticationDao();
		return auth.authUser(username, password);
	}
}
