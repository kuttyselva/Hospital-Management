package global.coda.hospital;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.constants.HospitalConstants;
import global.coda.hospital.exceptions.HospitalExceptions;
import global.coda.hospital.login.HospitalLogin;

/*
 * hospital management application
 * base class handling CRUD operations
 */
public class Hospital {
	// Logger class will log the status
	private static final Logger LOGGER = LogManager.getLogger(Hospital.class);
	// ResourceBundle class will use SystemMessages.properties file
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
			Locale.getDefault());

	public static void main(String args[]) throws HospitalExceptions {
		// choice printing
//		HospitalRecord record = new HospitalRecord();
		HospitalLogin login=new HospitalLogin();
		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString((HospitalConstants.HOS0002D)));
		login.HospitalSignin();
//		record.records();

	}

}
