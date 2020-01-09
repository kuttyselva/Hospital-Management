package global.coda.hospital.persondao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.databasedao.DatabaseConnection;

/**
 * @author VC
 *
 */
public class PatientSqlDAO {
	/**
	 * constructor.
	 */
	public PatientSqlDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	Connection connection = DatabaseConnection.createconnection();
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("patient", Locale.getDefault());
	private static final Logger LOGGER = LogManager.getLogger(PatientSqlDAO.class);

	/**
	 * @param patientQuery    for patient.
	 * @param patientUserId   of patient.
	 * @param newPatientValue of patient.
	 * @return true for success.
	 */
	public boolean updatePatient(String patientQuery, int patientUserId, String newPatientValue) {

		int result = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(patientQuery);
			statement.setString(1, newPatientValue);
			statement.setInt(2, patientUserId);
			result = statement.executeUpdate();
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
		}
		if (result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @param patientQuery for patient.
	 * @param branchId     of patient.
	 * @return true for success.
	 */
	public boolean viewUserDetails(String patientQuery, int branchId) {

		boolean result = false;
		try {
			PreparedStatement statement = connection.prepareStatement(patientQuery);
			statement.setInt(1, branchId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result = true;
				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(PatientConstants.DOCNAME) + resultSet.getString(1));
				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(PatientConstants.DOCSPE) + resultSet.getString(2));
				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(PatientConstants.DOCLOC) + resultSet.getString(3));
			}

		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
		}
		return result;
	}
}
