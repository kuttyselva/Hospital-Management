package global.coda.hospital.services;

import java.util.List;

import global.coda.hospital.databasedao.AuthenticationDao;
/**
 * @author VC
 */
public class UserAuthentication {
/**
 * Authenticate user by sending data to DAO.
 * @param username of user.
 * @param password of user.
 * @return list of role id.
 */
	public List<Integer> userauth(String username, String password) {
		/*
		 * connects dao layer to get role id of user
		 */
		AuthenticationDao auth = new AuthenticationDao();
		return auth.authUser(username, password);
	}
}
