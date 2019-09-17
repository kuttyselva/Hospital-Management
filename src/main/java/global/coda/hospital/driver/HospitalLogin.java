package global.coda.hospital.driver;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.enums.BranchEnum;
import global.coda.hospital.enums.GlobalEnum;
import global.coda.hospital.enums.PersonEnum;
import global.coda.hospital.services.BranchServices;
import global.coda.hospital.services.DoctorServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.services.PatientServices;
import global.coda.hospital.services.UserAuthentication;

public class HospitalLogin {

    // Logger class will log the status
    private static final Logger LOGGER = LogManager.getLogger(HospitalLogin.class);
    // resource bundle initialization
    public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("login", Locale.getDefault());
    private int userid = 0;
    private int roleid = 0;
    private String username = "";
    private String password = "";
    private Scanner scanner = null;
    private PatientRecord patientRecord = new PatientRecord();
    private DoctorRecord doctorRecord = new DoctorRecord();
    private UserAuthentication userauthenticate = new UserAuthentication();
    private PatientServices patientservice = new PatientServices();
    private DoctorServices doctorservice = new DoctorServices();

    /*
     * login using username and password this function returns role id of that
     * logged user
     */
    public void HospitalSignin() {

        try {
            List<Integer> user;
            scanner = new Scanner(System.in);
            // getting username and password
            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.USERNAME));
            username = scanner.next();
            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PASSWORD));
            password = scanner.next();
            //setting userid  roleid from dao layer to driver
            user = userauthenticate.userauth(username, password);
            userid = user.get(0);
            roleid = user.get(1);
            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.SUCCESS));
            LOGGER.info(username + LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.USERID) + " " + userid);
            //setting path according to user role
            while (true) {
                userpath(roleid);
            }
        } catch (NullPointerException e) {
            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.INVALID));
        }

    }

    private void userpath(int roleid) {
        LoginEnum user = LoginEnum.valueOf(roleid);
        switch (user) {
            //Patient menu case
            case PATIENT: {
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PATIENT));
                //getting patient menu choice
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PATIENTMENU));
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONMODIFY));
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PATIENTVIEW));
                int choice = scanner.nextInt();
                PersonEnum patientchoice = PersonEnum.valueOf(choice);
                switch (patientchoice) {
                    //to modify patient details
                    case MODIFY: {
                        //getting update option 1)location 2)age 3)phone 4) disease
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONMODIFYOPTION));
                        int modifychoice = scanner.nextInt();
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONUPDATEVALUE));

                        String updatevalue = scanner.next();
                        //true for successfull updation
                        if (patientservice.updateUser(modifychoice, username, updatevalue)) {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
                        } else {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
                        }
                        break;
                    }
                    //to view doctors in a particular branch
                    case VIEW: {
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.BRANCHINP));

                        String updatevalue = scanner.next();
                        //true for successfull view of doctors in a branch
                        List<DoctorRecord> recordlist = patientservice.viewUsers(updatevalue);
                        DoctorRecord record = null;
                        if (recordlist != null) {
                            for (DoctorRecord doctorRecord : recordlist) {
                                record = doctorRecord;
                                LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCNAME) + record.getName());
                                LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCSPE) + record.getSpeciality());
                                LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCLOC) + record.getLocation());
                            }
                        } else {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
                        }
                        break;
                    }
                }


                break;

            }
            case DOCTOR: {
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCTOR));
                //doctor menu choice
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCTORMENU));
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONMODIFY));
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCTORVIEW));
                int choice = scanner.nextInt();
                PersonEnum doctorchoice = PersonEnum.valueOf(choice);
                switch (doctorchoice) {
                    case MODIFY: {
                        //modify doctor details 1)location 2)age 3)phone
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONMODIFYOPTION));
                        int modifychoice = scanner.nextInt();
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.PERSONUPDATEVALUE));

                        String updatevalue = scanner.next();
                        //true for successful completion of execution
                        if (doctorservice.updateDoctor(modifychoice, username, updatevalue)) {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
                        } else {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
                        }
                        break;
                    }
                    case VIEW: {
                        //view patients in a branch
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.BRANCHINP));

                        String updatevalue = scanner.next();
                        //true for successfull view of doctors in a branch
                        List<PatientRecord> recordlist = doctorservice.viewUsers(updatevalue);
                        PatientRecord record = null;
                        if (recordlist != null) {
                            for (PatientRecord patientRecord : recordlist) {
                                record = patientRecord;
                                LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCNAME) + record.getName());
                                LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCSPE) + record.getDisease());
                                LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.DOCLOC) + record.getLocation());
                            }
                        } else {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
                        }
                        break;
                    }
                }

                break;

            }
            case BRANCH: {
                //branch menu
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.BRANCH));
                BranchDriver branchDriver = new BranchDriver();
                try {
                    branchDriver.branchDriver();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            }
            case GLOBAL: {
                GlobalHelpers globalHelpers = new GlobalHelpers();
                BranchServices branchServices = new BranchServices();
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.GLOBAL));
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.GLOBALMENU));
                int choice = scanner.nextInt();
                GlobalEnum globalChoice = GlobalEnum.valueOf(choice);
                switch (globalChoice) {
                    case CREATEBRANCH: {
                        if (branchServices.createBranch(globalHelpers.createBranch())) {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
                        } else {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
                        }
                        break;
                    }
                    case MODIFYBRANCH: {
                        if (globalHelpers.modifyBranch()) {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
                        } else {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
                        }
                        break;
                    }
                    case CREATEHOSPITAL: {
                        if (globalHelpers.createHospital()) {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
                        } else {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATEFAIL));
                        }
                        break;

                    }
                    case MODIFYHOSPITAL: {
                        if (globalHelpers.updateHospital()) {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DriverConstants.UPDATED));
                        } else {
                        }
                        break;
                    }
                    case USEROPTION: {
                        BranchDriver branchDriver = new BranchDriver();
                        branchDriver.branchDriver();
                        break;
                    }
                }

                break;

            }
        }
    }

}
