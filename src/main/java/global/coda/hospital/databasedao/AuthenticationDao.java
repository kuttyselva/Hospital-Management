package global.coda.hospital.databasedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AuthenticationDao {
    // Logger class will log the status
    private static final Logger LOGGER = LogManager.getLogger(AuthenticationDao.class);
    public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle(HospitalQueries.SQL_QUERIES,
            Locale.getDefault());

    public List<Integer> authUser(String username, String password) {
        List<Integer> userValues = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.createconnection();
            PreparedStatement authenticateStmt = connection
                    .prepareStatement(LOCAL_MESSAGES_BUNDLE.getString(HospitalQueries.authenticate));
            authenticateStmt.setString(1, username);
            authenticateStmt.setString(2, password);
            ResultSet resultSet = authenticateStmt.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            userValues.add(resultSet.getInt(1));
            userValues.add(resultSet.getInt(2));


        } catch (SQLException exception) {
            LOGGER.error(exception.getMessage());
        }
        return userValues;
    }
}

