package global.coda.hospital.doctordao;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.databasedao.DatabaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class DoctorDAO {
    //sql query resource bundle
    public static final ResourceBundle QUERIES = ResourceBundle.getBundle(DoctorConstants.SQLQUEIRES,
            Locale.getDefault());
    //local message resource bundle
    public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle(DoctorConstants.DOCTOR,
            Locale.getDefault());

    private static final Logger LOGGER = LogManager.getLogger(DoctorDAO.class);
    //establishing connection between DAO and db
    private Connection connection = new DatabaseConnection().createconnection();

    /*
    creates new Doctor record
    gets input into doctor bean
    input doctor record
    output true for successful insertion
     */
    public boolean createDoctorRecord(DoctorRecord record) {

        int result = 0;
        int userid = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(DoctorConstants.DOCTOR_CREATE_USER), Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, record.getName());
            statement.setString(2, record.getPassword());
            statement.setString(3, record.getLocation());
            statement.setInt(4, record.getAge());
            statement.setString(5, record.getPhone());
            statement.setInt(6, 2);
            result = statement.executeUpdate();
            ResultSet resultset = statement.getGeneratedKeys();
            if (resultset.next()) {
                userid = resultset.getInt(1);
            }
            statement = connection.prepareStatement(QUERIES.getString(DoctorConstants.DOCTOR_CREATE_DOCTOR));
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

    /*
        gets Doctor record
        input doctor name
        output DoctorRecord for successful Execution
         */
    public DoctorRecord getDoctorRecord(String patientName) {
        DoctorRecord record = null;
        try {
            record = new DoctorRecord();
            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(DoctorConstants.DOCTOR_DATA));
            statement.setString(1, patientName);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                record.setId(result.getInt(1));
                record.setName(result.getString(2));
                record.setLocation(result.getString(3));
                record.setAge(result.getInt(4));
                record.setPhone(result.getString(5));
                record.setSpeciality(result.getString(6));
            }
            return record;


        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        return record;
    }
    /*
        updates existing Doctor record
        gets input into doctor bean
        input doctor record
        output true for successful insertion
         */
    public boolean updateDoctor(DoctorRecord record) {

        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(DoctorConstants.DOCTOR_UPDATE));
            statement.setString(1, record.getLocation());
            statement.setInt(2, record.getAge());
            statement.setString(3, record.getPhone());
            statement.setInt(4, record.getId());
            result = statement.executeUpdate();
            statement = connection.prepareStatement(QUERIES.getString(DoctorConstants.DOCTOR_TABLE_UPDATE));
            statement.setString(1, record.getSpeciality());
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
    /*
       viewing patients in a branch
        gets input into doctor bean
        input branch name
        output list of patient records
         */
    public List<PatientRecord> viewDoctorDetails(String branchname) {
        List<PatientRecord> recordlist = new ArrayList<>();
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(DoctorConstants.PATIENTS_IN_BRANCH));
            statement.setString(1, branchname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = true;
                PatientRecord record = new PatientRecord();
                record.setName(resultSet.getString(1));
                record.setDisease(resultSet.getString(2));
                record.setLocation(resultSet.getString(3));
                recordlist.add(record);
            }

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        return recordlist;
    }

}
