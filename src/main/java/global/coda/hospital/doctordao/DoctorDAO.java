package global.coda.hospital.doctordao;

import global.coda.hospital.hospitaldao.DatabaseConnection;
import global.coda.hospital.patientdao.PatientConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.ResourceBundle;

public class DoctorDAO {
    public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("doctor",
            Locale.getDefault());
    private static final Logger LOGGER = LogManager.getLogger(DoctorDAO.class);
    private Connection connection=new DatabaseConnection().createconnection();

    public boolean updateDoctor(String query, int userId, String newValue) {

        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newValue);
            statement.setInt(2, userId);
            result = statement.executeUpdate();
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        if (result > 0) {
            return true;
        }
        return false;
    }



    public boolean viewUserDetails(String patientQuery, String branchname) {

        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(patientQuery);
            statement.setString(1, branchname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = true;
                LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(DoctorConstants.PATNAME) + resultSet.getString(1));
                LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(DoctorConstants.PATDIS) + resultSet.getString(2));
                LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(DoctorConstants.PATLOC) + resultSet.getString(3));
            }

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        return result;
    }

}
