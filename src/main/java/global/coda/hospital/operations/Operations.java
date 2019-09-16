//package global.coda.hospital.operations;
//
//import java.util.*;
//import global.coda.hospital.patientdaocsv.PatientDAO;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import global.coda.hospital.bean.PatientRecord;
//import global.coda.hospital.constants.HospitalConstants;
//import global.coda.hospital.exceptions.HospitalExceptions;
//
//public class Operations {
//	PatientRecord record;
//	PatientDAO patientdao;
//	// Logger class will log the status
//	private static final Logger LOGGER = LogManager.getLogger(Operations.class);
//	// resource bundle initialization
//	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
//			Locale.getDefault());
////	HospitalRecord hospital = new HospitalRecord();
//	Scanner scanner = new Scanner(System.in);
//	// create patient service function
//	public PatientRecord createRecord(int passedkey) throws HospitalExceptions {
//		/*
//		 * creates a new entry in list of patient records
//		 * returns a new patient object
//		 */
//		String key = String.valueOf(passedkey);
//
//		String location = "";
//		try {
//			PatientRecord patientrecord = new PatientRecord();
//			StringBuilder locations = new StringBuilder();
//			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS2000D));
//			String name = scanner.next();
//			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1102I));
//			String password = scanner.next();
//			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1101I));
//			String phone = scanner.next();
//			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS2001D));
//			String age = scanner.next();
//			Integer.parseInt(age);
//			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS2002D));
//			location = scanner.next();
//			locations.append(location);
//			locations.append(" ");
//			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS2003D));
//			location = scanner.next();
//			locations.append(location);
//			locations.append(" ");
//			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS2004D));
//			location = scanner.next();
//			locations.append(location);
//			location = locations.toString();
//
//			patientrecord = new PatientRecord();
//			patientrecord.BeanRecordInsert(key, age, name, location,password,phone);
//			LOGGER.info("Created");
//
//			return patientrecord;
//		} catch (NumberFormatException e) {
//			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1000E));
//			throw new HospitalExceptions(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1000E));
//		}
//	}
//
//
//	// delete patient service function
//	public List<PatientRecord> deleteRecord(List<PatientRecord> recordmap) throws HospitalExceptions {
//
//
//		int flag = 0;
//		if (recordmap == null) {
//			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS2002I));
//		}
//		try {
//			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS5000D));
//			String name = scanner.next();
//
//			assert recordmap != null;
//			for (int index = 0; index < recordmap.size(); index++) {
//
//				record = recordmap.get(index);
//				if (name.equals(record.getId())) {
//					recordmap.remove(index);
//					flag = 1;
//					LOGGER.info("Record Deleted");
//
//				}
//
//			}
//			if (flag == 0) {
//				if (flag == 0) {
//					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS2001I));
//				}
//			}
//			return recordmap;
//		} catch (NumberFormatException e) {
//			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1000E));
//			throw new HospitalExceptions(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1000E));
//		}
//	}
//
//	// display all records function
//	public boolean displayAllRecord(List<PatientRecord> recordmap) {
//		PatientRecord record;
//		if (recordmap.size()==1) {
//			return false;
//		} else {
//			for (int index = 1; index < recordmap.size(); index++) {
//				record = recordmap.get(index);
//				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1102D) + record.getId());
//				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1103D) + record.getName());
//				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1104D) + record.getAge());
//				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1105D) + record.getLocation());
//				System.out.println();
//
//			}
//			return true;
//		}
//
//	}
//
//	// read a record function
//	public boolean readRecord(List<PatientRecord> recordmap) throws HospitalExceptions {
//
//
//		int flag = 0;
//		if (recordmap.isEmpty()) {
//			return false;
//		}
//		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS3000D));
//		try {
//			String name = scanner.next();
//
//			for (int index = 0; index < recordmap.size(); index++) {
//
//				record = recordmap.get(index);
//				if (name.equals(record.getId())) {
//					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1102D) + record.getId());
//					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1103D) + record.getName());
//					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1104D) + record.getAge());
//					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1105D) + record.getLocation());
//					flag = 1;
//				}
//
//			}
//
//			if (flag == 0) {
//				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS2001I));
//			}
//		} catch (NumberFormatException e) {
//			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1000E));
//			throw new HospitalExceptions(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1000E));
//
//		}
//		return true;
//
//	}
//
//	// update record function
//	public PatientRecord updateRecord() throws HospitalExceptions {
//		@SuppressWarnings("resource")
//		Scanner scanner = new Scanner(System.in);
//
//		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS3000D));
//		try {
//			String name = scanner.next();
//			String location;
//
//
//					StringBuilder locations = new StringBuilder();
//					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS2000D));
//					String names = scanner.next();
//					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS2001D));
//					String age = scanner.next();
//					Integer.parseInt(age);
//					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS2002D));
//					location = scanner.next();
//					locations.append(location);
//					locations.append(" ");
//					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS2003D));
//					location = scanner.next();
//					locations.append(location);
//					locations.append(" ");
//					LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS2004D));
//					location = scanner.next();
//					locations.append(location);
//					location = locations.toString();
//					record.setAge(age);
//					record.setLocation(location);
//					record.setName(names);
//					LOGGER.info("Updated");
//			return record;
//		} catch (NumberFormatException e) {
//			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1000E));
//			throw new HospitalExceptions(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1000E));
//
//		} catch (NullPointerException e) {
//			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1003E));
//			throw new HospitalExceptions(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1003E));
//
//		}
//
//	}
//
//}
