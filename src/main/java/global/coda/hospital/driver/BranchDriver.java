package global.coda.hospital.driver;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.services.DoctorServices;
import global.coda.hospital.services.PatientServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class BranchDriver {

    // Logger class will log the status
    private static final Logger LOGGER = LogManager.getLogger(BranchDriver.class);
    // resource bundle initialization
    public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle(DriverConstants.LOGIN, Locale.getDefault());
    PatientServices patientServices = new PatientServices();
    DoctorServices doctorServices=new DoctorServices();
    Scanner scanner = null;

    public PatientRecord createPatient() {
        PatientRecord record = new PatientRecord();
        scanner = new Scanner(System.in);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_NAME));
        record.setName(scanner.next());
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_PASS));
        record.setPassword(scanner.next());
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_AGE));
        record.setAge(scanner.nextInt());
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_PHONE));
        record.setPhone(scanner.next());
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_LOCATION));
        record.setLocation(scanner.next());
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_DISEASE));
        record.setDisease(scanner.next());
        scanner.close();
        return record;
    }

    public boolean modifyPatient() {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATE_OPTION));
        scanner = new Scanner(System.in);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_NAME));
        String name = scanner.next();
        int choice = scanner.nextInt();
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONUPDATEVALUE));
        String newValue = scanner.next();

        return patientServices.updateUser(choice, name, newValue);

    }

    public DoctorRecord createDoctor() {
        DoctorRecord record = new DoctorRecord();
        scanner = new Scanner(System.in);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_NAME));
        record.setName(scanner.next());
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_PASS));
        record.setPassword(scanner.next());
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_AGE));
        record.setAge(scanner.nextInt());
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_PHONE));
        record.setPhone(scanner.next());
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_LOCATION));
        record.setLocation(scanner.next());
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_SPECIALITY));
        record.setSpeciality(scanner.next());
        scanner.close();
        return record;
    }

    public boolean modifyDoctor() {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATE_OPTION_DOC));
        scanner = new Scanner(System.in);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.ENTER_NAME));
        String name = scanner.next();
        int choice = scanner.nextInt();
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONUPDATEVALUE));
        String newValue = scanner.next();

        return doctorServices.updateDoctor(choice, name, newValue);

    }
}
