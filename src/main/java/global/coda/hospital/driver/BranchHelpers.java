package global.coda.hospital.driver;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.services.BranchServices;
import global.coda.hospital.services.DoctorServices;
import global.coda.hospital.services.PatientServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author VC
 *
 */
public class BranchHelpers {

	// Logger class will log the status
	private static final Logger LOGGER = LogManager.getLogger(BranchHelpers.class);
	// resource bundle initialization
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle(DriverConstants.LOGIN,
			Locale.getDefault());
	private PatientServices patientServices = new PatientServices();
	private DoctorServices doctorServices = new DoctorServices();
	private BranchServices branchServices = new BranchServices();
	private Scanner scanner = new Scanner(System.in);

	// creates patient
	/**
	 * @return true for successful exe.
	 */
	PatientRecord createPatient() {
		PatientRecord record = new PatientRecord();
		try {
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_NAME));
			record.setName(scanner.next());
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_PASS));
			record.setPassword(scanner.next());
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_AGE));
			record.setAge(scanner.nextInt());
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_PHONE));
			record.setPhone(scanner.next());
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_LOCATION));
			record.setLocation(scanner.next());
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_DISEASE));
			record.setDisease(scanner.next());
			return record;
		} catch (InputMismatchException exception) {
			LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.INPUT_MISMATCH));
		}
		return null;
	}

	// modify patient
	/**
	 * @return true for successful exe.
	 */
	boolean modifyPatient() {
		try {
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATE_OPTION));
			int choice = scanner.nextInt();
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_NAME));
			String name = scanner.next();
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONUPDATEVALUE));
			String newValue = scanner.next();
			return patientServices.updateUser(choice, name, newValue);
		} catch (InputMismatchException exception) {
			LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.INPUT_MISMATCH));
		}
		return false;
	}

	// create doctor
	/**
	 * @return true for successful exe.
	 */
	DoctorRecord createDoctor() {
		DoctorRecord record = new DoctorRecord();
		try {
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_NAME));
			record.setName(scanner.next());
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_PASS));
			record.setPassword(scanner.next());
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_AGE));
			record.setAge(scanner.nextInt());
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_PHONE));
			record.setPhone(scanner.next());
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_LOCATION));
			record.setLocation(scanner.next());
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_SPECIALITY));
			record.setSpeciality(scanner.next());
			return record;
		} catch (InputMismatchException exception) {
			LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.INPUT_MISMATCH));
		}
		return null;
	}

	// modify doctor
	/**
	 * @return true for successful exe.
	 */
	boolean modifyDoctor() {
		try {
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATE_OPTION_DOC));
			int choice = scanner.nextInt();
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_NAME));
			String name = scanner.next();
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONUPDATEVALUE));
			String newValue = scanner.next();
			return doctorServices.updateDoctor(choice, name, newValue);
		} catch (InputMismatchException exception) {
			LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.INPUT_MISMATCH));
		}
		return false;
	}

	// entry record
	/**
	 * @return true for successful exe.
	 */
	boolean patientDoctorEntry() {
		try {
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PATIENT_NAME));
			String patientName = scanner.next();
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCNAME));
			String doctorName = scanner.next();
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.BRANCH_NAME));
			String branchName = scanner.next();
			return branchServices.patientDoctorEntry(patientName, doctorName, branchName);
		} catch (InputMismatchException exception) {
			LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.INPUT_MISMATCH));
		}
		return false;
	}
}
