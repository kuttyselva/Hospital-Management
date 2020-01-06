package global.coda.hospital.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import global.coda.hospital.enums.PersonEnum;
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
    private Scanner scanner = null;
    private UserAuthentication userauthenticate = new UserAuthentication();
    private PatientServices patientservice = new PatientServices();
    private DoctorServices doctorservice = new DoctorServices();

    /*
     * login using username and password this function returns role id of that
     * logged user
     */
    public void HospitalSignin() {
        String username = "";
        String password = "";
        try {
            List<Integer> user;
            scanner = new Scanner(System.in);
            // getting username and password
            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.USERNAME));
            username = scanner.next();
            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.PASSWORD));
            password = scanner.next();
            //setting userid  roleid from dao layer to driver
            user = userauthenticate.userauth(username, password);
            userid = user.get(0);
            roleid = user.get(1);
            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.SUCCESS));
            LOGGER.info(username + LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.USERID) + " " + userid);
            //setting path according to user role
            userpath(roleid);
        } catch (NullPointerException e) {
            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.INVALID));
        }

    }

    private void userpath(int roleid) {
        LoginEnum user = LoginEnum.valueOf(roleid);
        switch (user) {
            //Patient menu case
            case PATIENT: {
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.PATIENT));
                //getting patient menu choice
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.PATIENTMENU));
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.PERSONMODIFY));
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.DOCTORVIEW));
                int choice = scanner.nextInt();
                PersonEnum patientchoice = PersonEnum.valueOf(choice);
                switch (patientchoice) {
                    //to modify patient details
                    case MODIFY: {
                        //getting update option 1)location 2)age 3)phone
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.PERSONMODIFYOPTION));
                        int modifychoice = scanner.nextInt();
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.PERSONUPDATEVALUE));

                        String updatevalue = scanner.next();
                        //true for successfull updation
                        if (patientservice.updateUser(modifychoice, userid, updatevalue)) {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.UPDATED));
                        } else {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.UPDATEFAIL));
                        }
                        break;
                    }
                    //to view doctors in a particular branch
                    case VIEW: {
						LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.DOCTORVIEW));
						LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.BRANCHINP));

						String updatevalue = scanner.next();
						//true for successfull view of doctors in a branch
						if (patientservice.viewUsers(updatevalue)) {
							LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.UPDATED));
						} else {
							LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.UPDATEFAIL));
						}
                        break;
                    }
                }


                break;

            }
            case DOCTOR: {
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.DOCTOR));
                //doctor menu choice
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.DOCTORMENU));
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.PERSONMODIFY));
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.DOCTORVIEW));
                int choice = scanner.nextInt();
                PersonEnum doctorchoice = PersonEnum.valueOf(choice);
                switch (doctorchoice) {
                    case MODIFY: {
                        //modify doctor details 1)location 2)age 3)phone
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.PERSONMODIFYOPTION));
                        int modifychoice = scanner.nextInt();
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.PERSONUPDATEVALUE));

                        String updatevalue = scanner.next();
                        //true for successful completion of execution
                        if (doctorservice.updateUser(modifychoice, userid, updatevalue)) {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.UPDATED));
                        } else {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.UPDATEFAIL));
                        }
                        break;
                    }
                    case VIEW: {
                        //view patients in a branch
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.BRANCHVIW));
                        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.BRANCHINP));

                        String updatevalue = scanner.next();
                        //true for successful execution
                        if (doctorservice.viewUsers(updatevalue)) {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.UPDATED));
                        } else {
                            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.UPDATEFAIL));
                        }
                        break;
                    }
                }

                break;

            }
            case BRANCH: {
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.BRANCH));
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.BRANCHMENU));

                break;

            }
            case GLOBAL: {
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.GLOBAL));
                LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(LoginConstants.GLOBALMENU));

                break;

            }
        }
    }

}
