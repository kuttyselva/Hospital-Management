package global.coda.hospital.creation;

import java.util.*;

import global.coda.hospital.patientdao.DAOFactory;
import global.coda.hospital.patientdao.PatientDAO;
import global.coda.hospital.patientdao.PersonDAOPattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import global.coda.hospital.patientdao.PersonType;
import global.coda.hospital.Hospital;
import global.coda.hospital.enums.*;
import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.exceptions.HospitalExceptions;
import global.coda.hospital.operations.Operations;

public class HospitalRecord {

	// Logger class will log the status
	public static final Logger LOGGER = LogManager.getLogger(Hospital.class);
	// ResourceBundle class will use SystemMessages.properties file
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
			Locale.getDefault());

	PatientRecord patientrecord = new PatientRecord();
	PatientDAO patientdao = null;
	PersonDAOPattern personType = null;
	List<PatientRecord> personList = null;

	public void records() throws HospitalExceptions {
		// object initialization for services
		Operations operation = new Operations();
		Scanner scanner = new Scanner(System.in);
		int key = 0;
		Random random = new Random();
		boolean casevalue = true;
		String persontype = "";

		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS9000I"));
		persontype = scanner.next();
		if (persontype.equalsIgnoreCase("2")) {
			personType = DAOFactory.storagePattern(PersonType.person.PATIENT);
		} else if (persontype.equalsIgnoreCase("1")) {
			personType = DAOFactory.storagePattern(PersonType.person.DOCTOR);

		} else {
			personType = DAOFactory.storagePattern(PersonType.person.PATIENT);
		}
		personList = personType.patientDataBaseRead();
		while (casevalue) {

			try {
				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1000D"));
				int choices = scanner.nextInt();
				PatientEnum choice = PatientEnum.valueOf(choices);
				switch (choice) {
				case CREATE: {
					// create record function
					key = random.nextInt(999999);

					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS1000I"));
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS1100I") + key);

					try {
						personList.add(operation.createRecord(key));
//						 patientdao.patientsingleCSVupdate(operation.create(key));
						// updates patientdatabase
//						patientdao.patientDataBase(personList);

						personType.patientDataBase(personList);

					} catch (HospitalExceptions exception) {
						LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString("HOS1100E"));

					}

					break;
				}
				case READ: {
					// read record function
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS1001I"));
					try {
						operation.readRecord(personList);
					} catch (HospitalExceptions exception) {
						LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString("HOS1100E"));

					}
					break;
				}
				case UPDATE: {
					// update record function
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS1002I"));

					try {
						personList = operation.updateRecord(personList);
						// updates patientdatabase
//						patientdao.patientDataBase(personList);
						// factory choice
						personType.patientDataBase(personList);
					} catch (HospitalExceptions exception) {
						LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString("HOS1100E"));

					}
					break;

				}
				case DELETE: {
					// delete record function
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS1003I"));
					try {
						personList = operation.deleteRecord(personList);
						// updates patientdatabase
//						patientdao.patientDataBase(personList);
						// factory method
						personType.patientDataBase(personList);

					} catch (HospitalExceptions exception) {
						LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString("HOS1100E"));

					}
					break;

				}
				case DISPLAY_ALL: {
					// delete record function
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS1004I"));
					operation.displayAllRecord(personList);
					break;

				}
				case EXIT: {
					// delete record function
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS1005I"));
					personList.clear();
					casevalue = false;

					break;
				}
				default: {
					// default inputs
					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1001D"));
					break;
				}
				}
			} catch (InputMismatchException exception) {
				LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));

			}

		}
		scanner.close();
	}
}
