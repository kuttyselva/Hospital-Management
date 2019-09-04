package global.coda.hospital;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.creation.HospitalRecord;
import global.coda.hospital.exceptions.HospitalExceptions;

/*
 * hospital management application
 * base class handling CRUD operations
 */
public class Hospital {
    // Logger class will log the status
    private static final Logger LOGGER = LogManager.getLogger(Hospital.class);
 // ResourceBundle class will use SystemMessages.properties file
 	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
 			Locale.getDefault());

    public static void main(String args[]) throws HospitalExceptions {
        // choice printing
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS0002D"));
        HospitalRecord record = new HospitalRecord();
        record.records();
    }
}
