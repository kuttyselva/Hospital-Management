package global.coda.hospital.driver;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.enums.GlobalEnum;
import global.coda.hospital.enums.PersonEnum;
import global.coda.hospital.exceptions.HospitalExceptions;
import global.coda.hospital.services.BranchServices;
import global.coda.hospital.services.DoctorServices;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.services.PatientServices;
import global.coda.hospital.services.UserAuthentication;

/**
 * Extracts the user's name from the input arguments.
 */
public class HospitalLogin {

	// Logger class will log the status
	private static final Logger LOGGER = LogManager.getLogger(HospitalLogin.class);
	// resource bundle initialization
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("login", Locale.getDefault());
	private String username = "";
	private Scanner scanner = new Scanner(System.in);
	private UserAuthentication userAuthenticate = new UserAuthentication();
	private PatientServices patientServices = new PatientServices();
	private DoctorServices doctorServices = new DoctorServices();

	/**
	 * Authenticates user and choose role menu for the user.
	 */
	public void HospitalSignin() {

		List<Integer> user;
		// getting username and password
		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.USERNAME));
		username = scanner.next();
		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PASSWORD));
		String password = scanner.next();
		// setting user id , role id from dao layer to driver
		user = userAuthenticate.userauth(username, password);
		int userId = user.get(0);
		int roleId = user.get(1);
		LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.SUCCESS));
		LOGGER.info(username + LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.USERID) + " " + userId);
		// setting path according to user role
		while (true) {
			try {
				userpath(roleId);
			} catch (NullPointerException | HospitalExceptions e) {
				LOGGER.error(DriverConstants.INPUT_MISMATCH);
			}
		}
	}

	/**
	 * Shows user role menu.
	 * 
	 * @param roleid stores role id of the user.
	 * @throws HospitalExceptions handles hospitalexceptions.
	 */
	private void userpath(int roleid) throws HospitalExceptions {
		LoginEnum user = LoginEnum.valueOf(roleid);
		switch (user) {
		// Patient menu case
		case PATIENT: {
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PATIENT));
			// getting patient menu choice
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PATIENTMENU));
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONMODIFY));
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PATIENTVIEW));
			try {
				int choice = scanner.nextInt();
				if (choice > 2 || choice < 1) {
					choice = 3;
				}
				PersonEnum patientChoice = PersonEnum.valueOf(choice);
				switch (patientChoice) {
				// to modify patient details
				case MODIFY: {
					// getting update option 1)location 2)age 3)phone 4) disease
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONMODIFYOPTION));
					int modifyChoice = scanner.nextInt();
					if (modifyChoice > 4 || modifyChoice < 1) {
						LOGGER.info(DriverConstants.VALID_CHOICE);
						this.userpath(roleid);
					}
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONUPDATEVALUE));

					String updateValue = scanner.next();
					// true for successful update
					if (patientServices.updateUser(modifyChoice, username, updateValue)) {
						LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
					} else {
						LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
					}
					break;
				}
				// to view doctors in a particular branch
				case VIEW: {
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.BRANCHINP));

					String updateValue = scanner.next();
					// true for successful view of doctors in a branch
					List<DoctorRecord> recordList = patientServices.viewUsers(updateValue);
					DoctorRecord record;
					if (recordList != null) {
						for (DoctorRecord doctorRecord : recordList) {
							record = doctorRecord;
							LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCNAME) + record.getName());
							LOGGER.debug(
									LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCSPE) + record.getSpeciality());
							LOGGER.debug(
									LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCLOC) + record.getLocation());
						}
					} else {
						LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
					}
					break;
				}
				case DEFAULT: {
					LOGGER.info(DriverConstants.VALID_CHOICE);
					break;
				}
				default:
					break;
				}
			} catch (InputMismatchException exception) {
				LOGGER.error(DriverConstants.INPUT_MISMATCH);
				scanner.nextLine();
				throw new HospitalExceptions(DriverConstants.INPUT_MISMATCH);
			}
			break;
		}
		case DOCTOR: {
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCTOR));
			// doctor menu choice
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCTORMENU));
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONMODIFY));
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCTORVIEW));
			try {
				int choice = scanner.nextInt();
				if (choice > 2 || choice < 1) {
					choice = 3;
				}
				PersonEnum doctorchoice = PersonEnum.valueOf(choice);
				switch (doctorchoice) {
				case MODIFY: {
					// modify doctor details 1)location 2)age 3)phone
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCTOR_MODIFY));
					int modifychoice = scanner.nextInt();
					if (modifychoice > 4 || modifychoice < 1) {
						LOGGER.info(DriverConstants.VALID_CHOICE);
						this.userpath(roleid);
					}
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONUPDATEVALUE));

					String updatevalue = scanner.next();
					// true for successful completion of execution
					if (doctorServices.updateDoctor(modifychoice, username, updatevalue)) {
						LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
					} else {
						LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
					}
					break;
				}
				case VIEW: {
					// view patients in a branch
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.BRANCHINP));

					String updatevalue = scanner.next();
					// true for successful view of doctors in a branch
					List<PatientRecord> recordList = doctorServices.viewUsers(updatevalue);
					PatientRecord record;
					if (recordList != null) {
						for (PatientRecord patientRecord : recordList) {
							record = patientRecord;
							LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCNAME) + record.getName());
							LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCSPE) + record.getDisease());
							LOGGER.debug(
									LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCLOC) + record.getLocation());
						}
					} else {
						LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
					}
					break;
				}
				case DEFAULT: {
					LOGGER.info(DriverConstants.VALID_CHOICE);
					break;
				}
				default:
					break;
				}
			} catch (InputMismatchException exception) {
				LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.INPUT_MISMATCH));
				scanner.nextLine();
				throw new HospitalExceptions(DriverConstants.INPUT_MISMATCH);
			}

			break;

		}
		case BRANCH: {
			// branch menu
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.BRANCH));
			BranchDriver branchDriver = new BranchDriver();
			try {
				branchDriver.branchDriver();
			} catch (HospitalExceptions exception) {
				LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.INPUT_MISMATCH));
			}
			break;

		}
		case GLOBAL: {
			GlobalHelpers globalHelpers = new GlobalHelpers();
			BranchServices branchServices = new BranchServices();
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.GLOBAL));
			LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.GLOBALMENU));
			int choice = scanner.nextInt();
			GlobalEnum globalChoice = GlobalEnum.valueOf(choice);
			switch (globalChoice) {
			case CREATEBRANCH: {
				if (branchServices.createBranch(globalHelpers.createBranch())) {
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
				} else {
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
				}
				break;
			}
			case MODIFYBRANCH: {
				if (globalHelpers.modifyBranch()) {
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
				} else {
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
				}
				break;
			}
			case CREATEHOSPITAL: {
				if (globalHelpers.createHospital()) {
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
				} else {
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
				}
				break;

			}
			case MODIFYHOSPITAL: {
				if (globalHelpers.updateHospital()) {
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
				} else {
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
				}
				break;
			}
			case USEROPTION: {
				BranchDriver branchDriver = new BranchDriver();
				branchDriver.branchDriver();
				break;
			}
			default:
				break;
			}

			break;

		}
		default:
			break;
		}
	}

}
