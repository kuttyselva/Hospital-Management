package global.coda.hospital.userinterface;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.bean.PatientRecord;

import java.util.List;

/**
 * @author VC
 */
public interface DoctorInterface {
	/**
	 * @param record of doctor.
	 * @return bool for success.
	 */
	public abstract boolean createDoctor(DoctorRecord record);

	/**
	 * @param modifyChoice record of doctor.
	 * @param username     record of doctor.
	 * @param newValue     record of doctor.
	 * @return bool for success.
	 */
	public abstract boolean updateDoctor(int modifyChoice, String username, String newValue);

	/**
	 * @param branchname record of doctor.
	 * @return list of record.
	 */
	public abstract List<PatientRecord> viewUsers(String branchname);

}
