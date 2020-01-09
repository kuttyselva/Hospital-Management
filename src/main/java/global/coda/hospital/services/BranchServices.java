package global.coda.hospital.services;

import global.coda.hospital.bean.BranchRecord;
import global.coda.hospital.branchdao.BranchDao;
import global.coda.hospital.userinterface.AdminInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;
/**
 * @author VC
 */
public class BranchServices implements AdminInterface {
    // Logger class will log the status
    private static final Logger LOGGER = LogManager.getLogger(BranchServices.class);
    // resource bundle initialization
    public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle(ServiceConstants.SQLQUERIES,
            Locale.getDefault());
    private BranchDao branchDao = new BranchDao();

    @Override
    public boolean createBranch(BranchRecord record) {
        return branchDao.createBranchRecord(record);

    }
/**
 * @param patientName of patient.
 * @param doctorName of patient.
 * @param branchName of patient.
 * @return booleanvalue for entry.
 */
    public boolean patientDoctorEntry(String patientName, String doctorName, String branchName){
        return branchDao.branchEntry(patientName,doctorName,branchName);
    }

    @Override
    
    public boolean modifyBranch(int modifyChoice, String branchName, String newValue) {
        BranchRecord branchRecord=new BranchDao().getBranchRecord(branchName);
        boolean result =false;
        switch (modifyChoice){
            case 1:{
                //name update
                branchRecord.setBranchName(newValue);
                result=new BranchDao().updateBranch(branchRecord);
                break;
            }
            case 2:{
                //location update
                branchRecord.setLocation(newValue);
                result=new BranchDao().updateBranch(branchRecord);
                break;
            }
            case 3:{
                //name update
                branchRecord.setHospitalId(Integer.parseInt(newValue));
                result=new BranchDao().updateBranch(branchRecord);
                break;
            }
            default:break;
        }
        return result;
    }
}
