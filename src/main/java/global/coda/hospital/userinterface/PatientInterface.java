package global.coda.hospital.userinterface;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.bean.PatientRecord;

import java.util.List;

public interface PatientInterface {

	public abstract boolean createPatient(PatientRecord record);
	public abstract boolean updateUser(int modifyChoice, String username, String newValue);
	public abstract List<DoctorRecord> viewUsers(String branchname);
	
	


}
