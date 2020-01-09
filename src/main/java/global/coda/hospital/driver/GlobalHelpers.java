package global.coda.hospital.driver;

import global.coda.hospital.bean.BranchRecord;
import global.coda.hospital.bean.HospitalRecord;
import global.coda.hospital.services.BranchServices;
import global.coda.hospital.services.HospitalServices;
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
public class GlobalHelpers {
	BranchRecord branchRecord = new BranchRecord();
	// Logger class will log the status
	private static final Logger LOGGER = LogManager.getLogger(GlobalHelpers.class);
	// resource bundle initialization
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle(DriverConstants.LOGIN,
			Locale.getDefault());
	Scanner scanner = new Scanner(System.in);
	BranchServices branchServices = new BranchServices();
	HospitalServices hospitalServices = new HospitalServices();
	HospitalRecord hospitalRecord = new HospitalRecord();

	/**
	 * @return true for success.
	 */
	public BranchRecord createBranch() {
		// hospital name ,branch name,location
		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.BRANCH_NAME));
		branchRecord.setBranchName(scanner.next());
		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.BRANCH_LOCATION));
		branchRecord.setLocation(scanner.next());
		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.HOSPITAL_NAME));
		branchRecord.setHospitalName(scanner.next());

		return branchRecord;
	}

	/**
	 * @return true for success.
	 */
	public boolean modifyBranch() {
		try {
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.BRANCH_UPDATE_MENU));
			int choice = scanner.nextInt();
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.BRANCH_NAME));
			String name = scanner.next();
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONUPDATEVALUE));
			String newValue = scanner.next();
			return branchServices.modifyBranch(choice, name, newValue);
		} catch (InputMismatchException exception) {
			LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.INPUT_MISMATCH));
		}
		return false;
	}

	/**
	 * @return true for success.
	 */
	public boolean createHospital() {
		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.HOSPITAL_NAME));
		hospitalRecord.setHospitalName(scanner.next());
		return hospitalServices.createHospital(hospitalRecord);
	}

	/**
	 * @return true for success.
	 */
	public boolean updateHospital() {
		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.HOSPITAL_NAME));
		String hospitalName = scanner.next();
		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONUPDATEVALUE));
		String newValue = scanner.next();
		return hospitalServices.modifyHospital(hospitalName, newValue);

	}
}
