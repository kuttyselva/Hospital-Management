package global.coda.hospital.persondao;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.constants.HospitalConstants;
import global.coda.hospital.persondao.DAOFactorySql;
import global.coda.hospital.persondao.PatientSqlDAO;
import global.coda.hospital.persondao.PersonDAOPatternSql;
import global.coda.hospital.persondao.PersonTypeSql.person;

public class DAOFactorySql {
	// Logger class will log the status
		public static final Logger LOGGER = LogManager.getLogger(DAOFactorySql.class);
		// ResourceBundle class will use SystemMessages.properties file
		public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
				Locale.getDefault());

		public static PersonDAOPatternSql storagePattern(person value) {
			PersonDAOPatternSql personObject = null;
			switch (value) {
			case PATIENT: {
				// patient type data storage
				LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString((HospitalConstants.HOS9001I)));
				personObject = new PatientSqlDAO();
				break;
			}
//			case DOCTOR: {
//				// Doctor type data storage
//				LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString((HospitalConstants.HOS9002I)));
//				personObject = new DoctorDAO();
//				break;
//			}
			default:
				LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString((HospitalConstants.HOS9002I)));
				personObject = new PatientSqlDAO();
				break;
			}
			return personObject;
		}
}
