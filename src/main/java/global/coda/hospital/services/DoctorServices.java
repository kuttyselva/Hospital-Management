package global.coda.hospital.services;

import global.coda.hospital.doctordao.DoctorDAO;
import global.coda.hospital.userinterface.UserInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class DoctorServices implements UserInterface {
    // Logger class will log the status
    private static final Logger LOGGER = LogManager.getLogger(DoctorServices.class);
    // resource bundle initialization
    public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("sqlqueries",
            Locale.getDefault());
/*
performs doctor role services
updataing user
view patients in a branch
inputs : choice , doctor id , new value
 */
    @Override
    public boolean updateUser(int modifyChoice, int doctorUserId, String newdoctorValue) {
        boolean result = false;
        switch (modifyChoice) {
            case 1: {
                //location update
                String query = LOCAL_MESSAGES_BUNDLE.getString(ServiceConstants.UPDATELOCATION);
                result = new DoctorDAO().updateDoctor(query, doctorUserId, newdoctorValue);
                break;
            }

            case 2: {
                //update age
                String query = LOCAL_MESSAGES_BUNDLE.getString(ServiceConstants.UPDATEAGE);
                result = new DoctorDAO().updateDoctor(query, doctorUserId, newdoctorValue);
                break;
            }
            case 3: {
                //update phone
                String query = LOCAL_MESSAGES_BUNDLE.getString(ServiceConstants.UPDATEPHONE);
                result = new DoctorDAO().updateDoctor(query, doctorUserId, newdoctorValue);
                break;
            }

        }
        return result;
    }

    @Override
    public boolean viewUsers(String branchname) {
        //view patients in branch
        boolean result = false;
        String viewDoctorQuery = LOCAL_MESSAGES_BUNDLE.getString(ServiceConstants.PATIENTBRANCH);
        result = new DoctorDAO().viewUserDetails(viewDoctorQuery, branchname);
        return result;
    }
}
