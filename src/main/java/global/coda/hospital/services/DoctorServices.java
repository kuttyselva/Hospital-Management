package global.coda.hospital.services;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.doctordao.DoctorDAO;
import global.coda.hospital.userinterface.DoctorInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author VC
 */
public class DoctorServices implements DoctorInterface {
	// Logger class will log the status
	private static final Logger LOGGER = LogManager.getLogger(DoctorServices.class);
	// resource bundle initialization
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle(ServiceConstants.SQLQUERIES,
			Locale.getDefault());
	public static final ResourceBundle LOCAL_MESSAGES = ResourceBundle.getBundle(ServiceConstants.LOGIN,
			Locale.getDefault());
	private DoctorDAO doctordao = new DoctorDAO();
	/*
	 * performs doctor role services updataing user view patients in a branch inputs
	 * : choice , doctor id , new value
	 */

	@Override
	public boolean createDoctor(DoctorRecord record) {
		return doctordao.createDoctorRecord(record);
	}

	@Override
	public boolean updateDoctor(int modifyChoice, String doctorName, String newdoctorValue) {
		DoctorRecord record = new DoctorDAO().getDoctorRecord(doctorName);
		boolean result = false;
		switch (modifyChoice) {
		case 1: {
			// location update
			record.setLocation(newdoctorValue);
			result = new DoctorDAO().updateDoctor(record);
			break;
		}

		case 2: {
			// update age
			try {
				record.setAge(Integer.parseInt(newdoctorValue));
				result = new DoctorDAO().updateDoctor(record);
			} catch (NumberFormatException exception) {
				LOGGER.error(ServiceConstants.INPUT_MISMATCH);
			}
			break;
		}
		case 3: {
			// update phone
			record.setPhone(newdoctorValue);
			result = new DoctorDAO().updateDoctor(record);
			break;
		}
		case 4: {
			// update Disease
			record.setSpeciality(newdoctorValue);
			result = new DoctorDAO().updateDoctor(record);
			break;
		}
		default:
			break;

		}
		return result;
	}

	@Override
	public List<PatientRecord> viewUsers(String branchname) {
		// view patients in branch
		List<PatientRecord> result = null;
		result = new DoctorDAO().viewDoctorDetails(branchname);
		return result;
	}
}
