package global.coda.hospital.driver;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.enums.BranchEnum;
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
    public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("login", Locale.getDefault());
    PatientRecord patientRecord=new PatientRecord();
    DoctorRecord doctorRecord=new DoctorRecord();
    DoctorServices doctorservice=new DoctorServices();
    PatientServices patientservice=new PatientServices();
    public void branchDriver(){
        Scanner scanner =new Scanner(System.in);
        //branch menu
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.BRANCHMENU));
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.BRANCHMENUS));
        //getting choice
        int choice = scanner.nextInt();
        BranchEnum branchchoice = BranchEnum.valueOf(choice);
        BranchHelpers branch = new BranchHelpers();
        switch (branchchoice) {
            case ADDDOCTOR: {
                //adding new doctor
                doctorRecord = branch.createDoctor();
                if (doctorservice.createDoctor(doctorRecord)) {
                    LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
                } else {
                    LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
                }
                break;
            }
            case ADDPATIENT: {
                //adding new patient
                patientRecord = branch.createPatient();
                if (patientservice.createPatient(patientRecord)) {
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
        }
    }
}
