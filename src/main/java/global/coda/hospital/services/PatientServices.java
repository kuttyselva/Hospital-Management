package global.coda.hospital.services;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.patientdao.PatientConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import global.coda.hospital.patientdao.PatientSqlDAO;
import global.coda.hospital.userinterface.PatientInterface;
/**
 * @author VC
 */
public class PatientServices implements PatientInterface {
    // Logger class will log the status
    private static final Logger LOGGER = LogManager.getLogger(PatientServices.class);
    // resource bundle initialization
    public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle(PatientConstants.PATIENT,
            Locale.getDefault());
    private PatientSqlDAO patientdao = new PatientSqlDAO();
/**
 * PatientService constructor.
 */
    public PatientServices() {
    }

	/*
    performs patient role services
    updataing user
    view doctors in a branch
    inputs : choice , patient id , new value
     */

    @Override
    public boolean createPatient(PatientRecord record) {
        if (patientdao.createPatientRecord(record)) {
            return true;
        }
        return false;
    }

    /**
     * @param modifyChoice to get choice.
     * @param patientName to get name.
     * @param newPatientValue holds new patientdata.
     * @return bool for successful update.
     */
    @Override
    public boolean updateUser(int modifyChoice, String patientName, String newPatientValue) {
        PatientRecord record = new PatientSqlDAO().getPatientRecord(patientName);
        boolean result = false;
        switch (modifyChoice) {
            //update location
            case 1: {
                record.setLocation(newPatientValue);
                result = new PatientSqlDAO().updatePatient(record);
                break;
            }

            case 2: {
                //update age
                try {
                    record.setAge(Integer.parseInt(newPatientValue));
                    result = new PatientSqlDAO().updatePatient(record);
                } catch (NumberFormatException exception) {
                    LOGGER.error(ServiceConstants.INPUT_MISMATCH);
                }
                break;

            }
            case 3: {
                //update phone
                record.setPhone(newPatientValue);
                result = new PatientSqlDAO().updatePatient(record);
                break;
            }
            case 4: {
                //update Disease
                record.setDisease(newPatientValue);
                result = new PatientSqlDAO().updatePatient(record);
                break;
            }
            default: break;

        }
        return result;
    }
    /**
     * @param branchname to store name of branch.
     * @return list for successful exe.
     */
    @Override
    public List<DoctorRecord> viewUsers(String branchname) {
        List<DoctorRecord> result = null;
        result = new PatientSqlDAO().viewUserDetails(branchname);
        return result;
    }

}
