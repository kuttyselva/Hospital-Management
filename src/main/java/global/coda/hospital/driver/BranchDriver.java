package global.coda.hospital.driver;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.enums.BranchEnum;
import global.coda.hospital.exceptions.HospitalExceptions;
import global.coda.hospital.services.DoctorServices;
import global.coda.hospital.services.PatientServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class BranchDriver {

    // Logger class will log the status
    private static final Logger LOGGER = LogManager.getLogger(BranchDriver.class);
    // resource bundle initialization
    public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("login", Locale.getDefault());
    private DoctorServices doctorServices =new DoctorServices();
    private PatientServices patientServices =new PatientServices();
    void branchDriver() throws HospitalExceptions {
        Scanner scanner = new Scanner(System.in);
        //branch menu
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.BRANCHMENU));
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.BRANCHMENUS));
        try {
            //getting choice
            int choice = scanner.nextInt();
            if (choice < 1 || choice > 5) {
                choice = 6;
            }
            BranchEnum branchChoice = BranchEnum.valueOf(choice);
            BranchHelpers branch = new BranchHelpers();
            switch (branchChoice) {
                case ADDDOCTOR: {
                    //adding new doctor
                    DoctorRecord doctorRecord = branch.createDoctor();
                    if (doctorServices.createDoctor(doctorRecord)) {
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
                    } else {
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
                    }
                    break;
                }
                case ADDPATIENT: {
                    //adding new patient
                    PatientRecord patientRecord = branch.createPatient();
                    if (patientServices.createPatient(patientRecord)) {
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
                    } else {
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
                    }

                    break;
                }
                case MODIFYDOCTOR: {
                    //modify doctor
                    if (branch.modifyDoctor()) {
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
                    } else {
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
                    }
                    break;
                }
                case MODIFYPATIENT: {
                    //modify patient
                    if (branch.modifyPatient()) {
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
                    } else {
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
                    }
                    break;
                }
                case BRANCHENTRY: {
                    //modify patient
                    if (branch.patientDoctorEntry()) {
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
                    } else {
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
                    }
                    break;
                }
                case DEFAULT: {
                    LOGGER.info(DriverConstants.VALID_CHOICE);
                    break;
                }
            }
        }catch (InputMismatchException exception){
            LOGGER.error(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.INPUT_MISMATCH));
            scanner.nextLine();
            throw new HospitalExceptions(DriverConstants.INPUT_MISMATCH);
        }
    }
}
