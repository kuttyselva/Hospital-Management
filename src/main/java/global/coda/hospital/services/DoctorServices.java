package global.coda.hospital.services;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.doctordao.DoctorDAO;
import global.coda.hospital.userinterface.DoctorInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class DoctorServices implements DoctorInterface {
    // Logger class will log the status
    private static final Logger LOGGER = LogManager.getLogger(DoctorServices.class);
    // resource bundle initialization
    public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle(ServiceConstants.SQLQUERIES,
            Locale.getDefault());
    private DoctorDAO doctordao=new DoctorDAO();
    /*
performs doctor role services
updataing user
view patients in a branch
inputs : choice , doctor id , new value
 */


@Override
public boolean createDoctor(DoctorRecord record) {
    return doctordao.createDoctorRecord(record);
}

    @Override
    public boolean updateDoctor(int modifyChoice, int doctorUserId, String newdoctorValue) {
        boolean result = false;
        switch (modifyChoice) {
            case 1: {
                //location update

                result = new DoctorDAO().updateDoctorLocation(doctorUserId, newdoctorValue);
                break;
            }

            case 2: {
                //update age

                result = new DoctorDAO().updateDoctorAge( doctorUserId, newdoctorValue);
                break;
            }
            case 3: {
                //update phone

                result = new DoctorDAO().updateDoctorPhone(doctorUserId, newdoctorValue);
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
        result = new DoctorDAO().viewDoctorDetails(viewDoctorQuery, branchname);
        return result;
    }
}
