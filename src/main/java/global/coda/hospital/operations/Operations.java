package global.coda.hospital.operations;

import java.util.*;
import global.coda.hospital.patientdao.PatientDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.Hospital;
import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.creation.HospitalRecord;
import global.coda.hospital.exceptions.HospitalExceptions;

public class Operations {
	PatientRecord record;
	PatientDAO patientdao;
	// Logger class will log the status
	private static final Logger LOGGER = LogManager.getLogger(Hospital.class);
	// resource bundle initialization
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
			Locale.getDefault());
	HospitalRecord hospital = new HospitalRecord();
	Scanner scanner = new Scanner(System.in);
	// create patient service function
	public PatientRecord createRecord(int passedkey) throws HospitalExceptions {
		String key = String.valueOf(passedkey);
		
		String location = "";
		try {
			PatientRecord patientrecord = new PatientRecord();
			StringBuilder locations = new StringBuilder();
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2000D"));
			String name = scanner.next();
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2001D"));
			String age = scanner.next();
			Integer.parseInt(age);
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002D"));
			location = scanner.next();
			locations.append(location);
			locations.append(" ");
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2003D"));
			location = scanner.next();
			locations.append(location);
			locations.append(" ");
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2004D"));
			location = scanner.next();
			locations.append(location);
			location = locations.toString();

			patientrecord = new PatientRecord();
			patientrecord.BeanRecordInsert(key, age, name, location);
			LOGGER.info("Created");

			return patientrecord;
		} catch (NumberFormatException e) {
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));
			throw new HospitalExceptions(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));
		}
	}
	

	// delete patient service function
	public List<PatientRecord> deleteRecord(List<PatientRecord> recordmap) throws HospitalExceptions {

		
		int flag = 0;
		if (recordmap == null) {
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002I"));
		}
		try {
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS5000D"));
			String name = scanner.next();

			assert recordmap != null;
			for (int index = 0; index < recordmap.size(); index++) {

				record = recordmap.get(index);
				if (name.equals(record.getId())) {
					recordmap.remove(index);
					flag = 1;
					LOGGER.info("Record Deleted");

				}

			}
			if (flag == 0) {
				if (flag == 0) {
					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2001I"));
				}
			}
			return recordmap;
		} catch (NumberFormatException e) {
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));
			throw new HospitalExceptions(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));
		}
	}

	// display all records function
	public void displayAllRecord(List<PatientRecord> recordmap) {
		PatientRecord record;
		if (recordmap.size()==1) {
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002I"));
		} else {
			for (int index = 1; index < recordmap.size(); index++) {
				record = recordmap.get(index);
				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1102D") + record.getId());
				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1103D") + record.getName());
				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1104D") + record.getAge());
				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1105D") + record.getLocation());
				System.out.println();

			}
		}

	}

	// read a record function
	public void readRecord(List<PatientRecord> recordmap) throws HospitalExceptions {

		
		int flag = 0;
		if (recordmap.isEmpty()) {
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002I"));
		}
		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS3000D"));
		try {
			String name = scanner.next();

			for (int index = 0; index < recordmap.size(); index++) {

				record = recordmap.get(index);
				if (name.equals(record.getId())) {
					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1102D") + record.getId());
					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1103D") + record.getName());
					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1104D") + record.getAge());
					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1105D") + record.getLocation());
					flag = 1;
				}

			}

			if (flag == 0) {
				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2001I"));
			}
		} catch (NumberFormatException e) {
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));
			throw new HospitalExceptions(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));

		}

	}

	// update record function
	public List<PatientRecord> updateRecord(List<PatientRecord> recordmap) throws HospitalExceptions {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int flag = 0;
		if (recordmap.isEmpty()) {
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002I"));
		}
		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS3000D"));
		try {
			String name = scanner.next();
			String location;
			for (int index = 0; index < recordmap.size(); index++) {

				record = recordmap.get(index);
				if (name.equals(record.getId())) {

					StringBuilder locations = new StringBuilder();
					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2000D"));
					String names = scanner.next();
					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2001D"));
					String age = scanner.next();
					Integer.parseInt(age);
					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2002D"));
					location = scanner.next();
					locations.append(location);
					locations.append(" ");
					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2003D"));
					location = scanner.next();
					locations.append(location);
					locations.append(" ");
					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2004D"));
					location = scanner.next();
					locations.append(location);
					location = locations.toString();
					record.setAge(age);
					record.setLocation(location);
					record.setName(names);
					LOGGER.info("Updated");
					flag = 1;

				}
			}
			if (flag == 0) {
				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS2001I"));
			}
			return recordmap;
		} catch (NumberFormatException e) {
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));
			throw new HospitalExceptions(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));

		} catch (NullPointerException e) {
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1003E"));
			throw new HospitalExceptions(LOCAL_MESSAGES_BUNDLE.getString("HOS1003E"));

		}

	}
	
}
