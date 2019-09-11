package global.coda.hospital.patientdao;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.constants.HospitalConstants;
import global.coda.hospital.patientdao.PersonType.person;

public class DAOFactory {
	// Logger class will log the status
	public static final Logger LOGGER = LogManager.getLogger(DAOFactory.class);
	// ResourceBundle class will use SystemMessages.properties file
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
			Locale.getDefault());

	public static PersonDAOPattern storagePattern(person value) {
		PersonDAOPattern personObject = null;
		switch (value) {
		case PATIENT: {
			// patient type data storage
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString((HospitalConstants.HOS9001I)));
			personObject = new PatientDAO();
			break;
		}
		case DOCTOR: {
			// Doctor type data storage
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString((HospitalConstants.HOS9002I)));
			personObject = new DoctorDAO();
			break;
		}
		default:
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString((HospitalConstants.HOS9002I)));
			personObject = new PatientDAO();
			break;
		}
		return personObject;
	}

}
