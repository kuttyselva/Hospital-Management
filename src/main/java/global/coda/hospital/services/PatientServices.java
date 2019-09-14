package global.coda.hospital.services;

import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.patientdao.PatientSqlDAO;
import global.coda.hospital.userinterface.UserInterface;

public class PatientServices implements UserInterface {
	// Logger class will log the status
	private static final Logger LOGGER = LogManager.getLogger(PatientServices.class);
	// resource bundle initialization
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("sqlqueries",
			Locale.getDefault());

	public PatientServices() {
	}
	/*
    performs patient role services
    updataing user
    view doctors in a branch
    inputs : choice , patient id , new value
     */
	@Override
	public boolean updateUser(int modifyChoice, int patientUserId, String newPatientValue) {
		boolean result = false;
		switch (modifyChoice) {
			//update location
		case 1: {
			String patientQuery = LOCAL_MESSAGES_BUNDLE.getString(ServiceConstants.UPDATELOCATION);
			result = new PatientSqlDAO().updatePatient(patientQuery, patientUserId, newPatientValue);
			break;
		}

		case 2: {
			//update age
			String patientQuery = LOCAL_MESSAGES_BUNDLE.getString(ServiceConstants.UPDATEAGE);
			result = new PatientSqlDAO().updatePatient(patientQuery, patientUserId, newPatientValue);
			break;
		}
		case 3: {
			//update phone
			String patientQuery = LOCAL_MESSAGES_BUNDLE.getString(ServiceConstants.UPDATEPHONE);
			result = new PatientSqlDAO().updatePatient(patientQuery, patientUserId, newPatientValue);
			break;
		}

		}
		return result;
	}

	@Override
	public boolean viewUsers(String branchname) {
		boolean result = false;
		String viewDoctorQuery = LOCAL_MESSAGES_BUNDLE.getString(ServiceConstants.DOCTORBRANCH);
		result = new PatientSqlDAO().viewUserDetails(viewDoctorQuery, branchname);
		return result;
	}

}
