package global.coda.hospital.branchdao;

import global.coda.hospital.bean.BranchRecord;
import global.coda.hospital.databasedao.DatabaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class BranchDao {
    //sql query resource bundle
    private static final ResourceBundle QUERIES = ResourceBundle.getBundle(BranchConstants.SQL_QUERIES,
            Locale.getDefault());
    private static final Logger LOGGER = LogManager.getLogger(BranchDao.class);
    //establishing connection between DAO and db
    private Connection connection = DatabaseConnection.createconnection();

     /*
    creates new Branch record
    gets input into Branch bean
    input Branch record
    output true for successful insertion
     */

    public boolean createBranchRecord(BranchRecord branchRecord) {
        int result = 0;
        int hospitalId = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(BranchConstants.HOSPITAL_ID));
            statement.setString(1, branchRecord.getHospitalName());
            ResultSet resultset = statement.executeQuery();
            if (resultset.next()) {
                hospitalId = resultset.getInt(1);
            }

            statement = connection.prepareStatement(QUERIES.getString(BranchConstants.BRANCH_CREATE));
            statement.setString(1, branchRecord.getBranchName());
            statement.setString(2, branchRecord.getLocation());
            statement.setInt(3, hospitalId);
            result = statement.executeUpdate();

        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage());
        }
        return result > 0;
    }

    /*
           gets branch record
           input branch name
           output branchrecord for successful Execution
            */
    public BranchRecord getBranchRecord(String branchName) {
        BranchRecord branchRecord = null;
        try {
            branchRecord = new BranchRecord();
            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(BranchConstants.GET_BRANCH));
            statement.setString(1, branchName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                branchRecord.setId(resultSet.getInt(1));
                branchRecord.setBranchName(resultSet.getString(2));
                branchRecord.setLocation(resultSet.getString(3));
                branchRecord.setHospitalId(resultSet.getInt(4));
            }
            return branchRecord;

        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage());
        }
        return branchRecord;

    }

    public boolean updateBranch(BranchRecord branchRecord) {
        int result = 0;
        int branchId = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(BranchConstants.BRANCH_ID));
            statement.setString(1, branchRecord.getBranchName());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                branchId = resultSet.getInt(1);
            }
            statement = connection.prepareStatement(QUERIES.getString(BranchConstants.UPDATE_BRANCH));
            statement.setString(1, branchRecord.getBranchName());
            statement.setString(2, branchRecord.getLocation());
            statement.setInt(3, branchRecord.getHospitalId());
            statement.setInt(4, branchId);

            result = statement.executeUpdate();
        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage());
        }
        return result > 0;
    }

    public boolean branchEntry(String patientName, String doctorName, String branchName) {
        int result ;
        int patientId = 0;
        int doctorId = 0;
        int branchId = 0;
        try {
//            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(BranchConstants.USER_ID));
//            statement.setString(1, patientName);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                patientId = resultSet.getInt(1);
//            }
//            statement = connection.prepareStatement(QUERIES.getString(BranchConstants.USER_ID));
//            statement.setString(1, doctorName);
//            resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                doctorId = resultSet.getInt(1);
//            }
//            statement = connection.prepareStatement(QUERIES.getString(BranchConstants.BRANCH_ID));
//            statement.setString(1, branchName);
//            resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                branchId = resultSet.getInt(1);
//            }
//            statement = connection.prepareStatement(QUERIES.getString(BranchConstants.BRANCH_USER));
//            statement.setInt(1, branchId);
//            statement.setInt(2, patientId);
//            statement.executeUpdate();
//
//            statement = connection.prepareStatement(QUERIES.getString(BranchConstants.BRANCH_USER));
//            statement.setInt(1, branchId);
//            statement.setInt(2, doctorId);
//            statement.executeUpdate();
//
//            statement = connection.prepareStatement(QUERIES.getString(BranchConstants.PATIENT_DOCTOR));
//            statement.setInt(1, patientId);
//            statement.setInt(2, doctorId);
            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(BranchConstants.DOC_PAT_BRAN));
            statement.setString(1,patientName);
            statement.setString(2,doctorName);
            statement.setString(3,branchName);
            result = statement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return false;
    }


}
