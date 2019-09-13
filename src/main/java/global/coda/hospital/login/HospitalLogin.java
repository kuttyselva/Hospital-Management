package global.coda.hospital.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.enums.PatientEnum;
import global.coda.hospital.services.PatientServices;
import global.coda.hospital.services.UserAuthentication;

public class HospitalLogin {

	// Logger class will log the status
	private static final Logger LOGGER = LogManager.getLogger(HospitalLogin.class);
	// resource bundle initialization
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("login", Locale.getDefault());
	int userid = 0;
	int roleid = 0;
	Scanner scanner = null;
	UserAuthentication userauthenticate = new UserAuthentication();

	/*
	 * login using username and password this function returns role id of that
	 * logged user
	 */
	public void HospitalSignin() {
		String username = "";
		String password = "";
		try {
			List<Integer> user = new ArrayList<>();
			scanner = new Scanner(System.in);
			// getting username and password
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.USERNAME));
			username = scanner.next();
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.PASSWORD));
			password = scanner.next();
			user = userauthenticate.userauth(username, password);

			userid = user.get(0);
			roleid = user.get(1);
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.SUCCESS));

			LOGGER.info(username + LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.USERID) + " " + userid);
			userpath(roleid);
		} catch (NullPointerException e) {
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.INVALID));
		}

	}

	public void userpath(int roleid) {
		LoginEnum user = LoginEnum.valueOf(roleid);
		switch (user) {
			case PATIENT: {
				LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.PATIENT));
				LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.PATIENTMENU));
				LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.PATIENTMODIFY));
				LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.PATIENTVIEW));
				int choice=scanner.nextInt();
				PatientEnum patientchoice=PatientEnum.valueOf(choice);
				switch(patientchoice) {
				case MODIFY:{
					
					break;
				}
				case VIEW:{
					break;
				}
				}

				

				break;

			}
			case DOCTOR: {
				LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.DOCTOR));
				LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.DOCTORMENU));

				break;

			}
			case BRANCH: {
				LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.BRANCH));
				LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.BRANCHMENU));

				break;

			}
			case GLOBAL: {
				LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.GLOBAL));
				LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.GLOBALMENU));

				break;

			}
		}
	}

}
