package global.coda.hospital.doctordao;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.databasedao.DatabaseConnection;

import global.coda.hospital.services.ServiceConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class DoctorDAO {
    public static final ResourceBundle QUERIES = ResourceBundle.getBundle("doctor",
            Locale.getDefault());
    public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("doctor",
            Locale.getDefault());
    private static final Logger LOGGER = LogManager.getLogger(DoctorDAO.class);
    private Connection connection=new DatabaseConnection().createconnection();

    public boolean createDoctorRecord(DoctorRecord record) {

        int result = 0;
        int userid = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(DoctorConstants.DOCTORCRUSER), Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, record.getName());
            statement.setString(2, record.getPassword());
            statement.setString(3, record.getLocation());
            statement.setString(4, record.getAge());
            statement.setString(5, record.getPhone());
            statement.setInt(6, 1);
            result = statement.executeUpdate();
            ResultSet resultset = statement.getGeneratedKeys();
            if (resultset.next()) {
                userid = resultset.getInt(1);
            }
            statement = connection.prepareStatement(QUERIES.getString(DoctorConstants.DOCTORCRDOCTOR));
            statement.setString(1, record.getSpeciality());
            statement.setInt(2, userid);
            result = statement.executeUpdate();
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        if (result > 0) {
            return true;
        }
        return false;
    }

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

    public boolean updateDoctorPhone(int userId, String newValue) {

        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(DoctorConstants.UPDATEPHONE));
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
    public boolean updateDoctorAge(int userId, String newValue) {

        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(DoctorConstants.UPDATEAGE));
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
    public boolean updateDoctorLocation(int userId, String newValue) {

        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(DoctorConstants.UPDATELOCATION));
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

    public boolean updateDoctorSpeciality(int userId, String newValue) {

        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(DoctorConstants.UPDATELOCATION));
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



    public boolean viewDoctorDetails(String patientQuery, String branchname) {

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
