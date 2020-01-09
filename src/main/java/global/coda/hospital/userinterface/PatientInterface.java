package global.coda.hospital.userinterface;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.bean.PatientRecord;

import java.util.List;

/**
 * @author VC
 */
public interface PatientInterface {
	/**
	 * @param record of patient.
	 * @return bool for success.
	 */
	public abstract boolean createPatient(PatientRecord record);

	/**
	 * @param modifyChoice of patient.
	 * @param username     of patient.
	 * @param newValue     of patient.
	 * @return bool for success.
	 */
	public abstract boolean updateUser(int modifyChoice, String username, String newValue);

	/**
	 * @param branchname of patient.
	 * @return list of doc in branch.
	 */
	public abstract List<DoctorRecord> viewUsers(String branchname);

}
