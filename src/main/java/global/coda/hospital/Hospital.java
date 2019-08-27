package global.coda.hospital;

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

    public static void main(String args[]) throws HospitalExceptions {
        // choice printing
        LOGGER.info("Main Method Invoked");
        HospitalRecord record = new HospitalRecord();
        record.records();
    }
}
