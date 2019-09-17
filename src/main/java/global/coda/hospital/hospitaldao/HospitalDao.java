package global.coda.hospital.hospitaldao;

import global.coda.hospital.bean.HospitalRecord;
import global.coda.hospital.databasedao.DatabaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HospitalDao {
    //sql query resource bundle
    public static final ResourceBundle QUERIES = ResourceBundle.getBundle(HospitalConstants.SQLQUEIRES,
            Locale.getDefault());
    //local message resource bundle
    public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle(HospitalConstants.HOSPITAL,
            Locale.getDefault());

    private static final Logger LOGGER = LogManager.getLogger(HospitalDao.class);
    //establishing connection between DAO and db
    private Connection connection = new DatabaseConnection().createconnection();

    /*
  creates new Hospital record
  gets input into hospital bean
  input hospital record
  output true for successful insertion
   */
    public boolean createHospital(HospitalRecord hospitalRecord) {
        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(HospitalConstants.CREATE_HOS));
            statement.setString(1, hospitalRecord.getHospitalName());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result > 0) {
            return true;
        }
        return false;
    }
/*
updates hospital record
input hospital record
output true for successful update
 */
    public boolean updateHospital(String hospitalName,HospitalRecord hospitalRecord) {
        int result = 0;
        int hospitalId = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERIES.getString(HospitalConstants.UPDATE_HOS));
            statement.setString(1, hospitalRecord.getHospitalName());
            statement.setString(2, hospitalName);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result > 0) {
            return true;
        }
        return false;
    }


}
