package global.coda.hospital.patientdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.bean.PatientRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.databasedao.DatabaseConnection;

public class PatientSqlDAO {
    public PatientSqlDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Connection connection = new DatabaseConnection().createconnection();
    public static final ResourceBundle SQL_QUERIES = ResourceBundle.getBundle(PatientConstants.SQLQUEIRES,
            Locale.getDefault());
    public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle(PatientConstants.PATIENT,
            Locale.getDefault());
    private static final Logger LOGGER = LogManager.getLogger(PatientSqlDAO.class);

    public boolean createPatientRecord(PatientRecord record) {


        int result = 0;
        int userid = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_QUERIES.getString(PatientConstants.PATIENT_CREATE_USER), Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, record.getName());
            statement.setString(2, record.getPassword());
            statement.setString(3, record.getLocation());
            statement.setInt(4, record.getAge());
            statement.setString(5, record.getPhone());
            statement.setInt(6, 1);
            result = statement.executeUpdate();
            ResultSet resultset = statement.getGeneratedKeys();
            if (resultset.next()) {
                userid = resultset.getInt(1);
            }
            statement = connection.prepareStatement(SQL_QUERIES.getString(PatientConstants.PATIENT_CREATE_PATIENT));
            statement.setString(1, record.getDisease());
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

    public PatientRecord getPatientRecord(String patientName) {
        PatientRecord record = null;
        try {
            record = new PatientRecord();
            PreparedStatement statement = connection.prepareStatement(SQL_QUERIES.getString(PatientConstants.PATIENT_RECORD));
            statement.setString(1, patientName);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                record.setId(result.getInt(1));
                record.setName(result.getString(2));
                record.setLocation(result.getString(3));
                record.setAge(result.getInt(4));
                record.setPhone(result.getString(5));
                record.setDisease(result.getString(6));
            }
            return record;


        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        return record;
    }

    public boolean updatePatient(PatientRecord record) {

        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_QUERIES.getString(PatientConstants.PATIENT_UPDATE));
            statement.setString(1, record.getLocation());
            statement.setInt(2, record.getAge());
            statement.setString(3, record.getPhone());
            statement.setInt(4, record.getId());
            result = statement.executeUpdate();
            statement = connection.prepareStatement(SQL_QUERIES.getString(PatientConstants.PATIENT_TABLE_UPDATE));
            statement.setString(1, record.getDisease());
            statement.setInt(2, record.getId());
            result = statement.executeUpdate();
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        if (result > 0) {
            return true;
        }
        return false;

    }


    public List<DoctorRecord> viewUserDetails( String branchname) {
        List<DoctorRecord> recordlist = new ArrayList<>();

        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_QUERIES.getString(PatientConstants.DOCTOR_IN_BRANCH));
            statement.setString(1, branchname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = true;
                DoctorRecord record = new DoctorRecord();
                record.setName(resultSet.getString(1));
                record.setSpeciality(resultSet.getString(2));
                record.setLocation(resultSet.getString(3));
                recordlist.add(record);
            }

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        return recordlist;
    }

}

