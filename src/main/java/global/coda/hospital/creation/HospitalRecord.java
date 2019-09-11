package global.coda.hospital.creation;

import java.util.*;

import global.coda.hospital.patientdao.DAOFactory;
import global.coda.hospital.patientdao.PersonDAOPattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import global.coda.hospital.persondao.PersonTypeSql;
import global.coda.hospital.persondao.DAOFactorySql;
import global.coda.hospital.persondao.PersonDAOPatternSql;
import global.coda.hospital.enums.*;
import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.constants.HospitalConstants;
import global.coda.hospital.exceptions.HospitalExceptions;
import global.coda.hospital.operations.Operations;

public class HospitalRecord {

	// Logger class will log the status
	public static final Logger LOGGER = LogManager.getLogger(HospitalRecord.class);
	// ResourceBundle class will use SystemMessages.properties file
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
			Locale.getDefault());
	PatientRecord patientrecord = new PatientRecord();
	PersonDAOPatternSql personType = null;
	List<PatientRecord> personList = null;

	public void records() throws HospitalExceptions {
		// object initialization for services
		Operations operation = new Operations();
		Scanner scanner = new Scanner(System.in);
		int key = 0;
		Random random = new Random();
		boolean casevalue = true;
		String persontype = "";
		int choices = 7;
		PatientEnum choice = PatientEnum.valueOf(choices);
		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS9000I));
		persontype = scanner.next();
//		if (persontype.equalsIgnoreCase("2")) {
			personType = DAOFactorySql.storagePattern(PersonTypeSql.person.PATIENT);
//		} else if (persontype.equalsIgnoreCase("1")) {
//			personType = DAOFactory.storagePattern(PersonType.person.DOCTOR);

//		} else {
//			personType = DAOFactory.storagePattern(PersonType.person.PATIENT);
//		}
		personList = personType.patientDataBaseRead();
		while (casevalue) {

			try {
				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1000D));

				choices = Integer.valueOf(scanner.next());
				choice = PatientEnum.valueOf(choices);

				switch (choice) {
				case CREATE: {
					// create record function
					key = random.nextInt(999999);

					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1000I));
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1100I) + key);

					try {
//						personList.add(operation.createRecord(key));
//						 patientdao.patientsingleCSVupdate(operation.create(key));
						// updates patientdatabase
//						patientdao.patientDataBase(personList);
						if(personType.createPatient(operation.createRecord(key))) {
							LOGGER.info("inserted");
						}
						personType.checkUser("shindam");
//						personType.patientDataBase(personList);

					} catch (HospitalExceptions exception) {
						LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1100E));

					}

					break;
				}
				case READ: {
					// read record function
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1001I));
					try {
						if(!operation.readRecord(personList)) {
							LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS2002I));
						}
					} catch (HospitalExceptions exception) {
						LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1100E));
					}
					break;
				}
				case UPDATE: {
					// update record function
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1002I));

					//						personList = operation.updateRecord(personList);
					// updates patientdatabase
//						patientdao.patientDataBase(personList);
					// factory choice
					if(!personType.checkUser("shinda")){
						LOGGER.info("user name not found");
					}
//						personType.patientDataBase(personList);
					break;

				}
				case DELETE: {
					// delete record function
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1003I));
					try {
						personList = operation.deleteRecord(personList);
						// updates patientdatabase
//						patientdao.patientDataBase(personList);
						// factory method
						personType.patientDataBase(personList);

					} catch (HospitalExceptions exception) {
						LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1100E));

					}
					break;

				}
				case DISPLAY_ALL: {
					// delete record function
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1004I));
					if(!operation.displayAllRecord(personList)) {
						LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS2002I));
					}
					break;

				}
				case EXIT: {
					// delete record function
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1005I));
					personList.clear();
					casevalue = false;

					break;
				}
				case DEFAULT: {
					// default inputs
					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1001D));
					break;
				}
				}
			} catch (NullPointerException exception) {
				LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1000E));

			} catch (Exception exception) {
				LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1000E));
				choices = 8;
				choice = PatientEnum.valueOf(choices);

			}

		}
		scanner.close();
	}
}
