package global.coda.hospital.userinterface;

import global.coda.hospital.bean.PatientRecord;

public interface PatientInterface {

	public abstract boolean createPatient(PatientRecord record);
	public abstract boolean updateUser(int modifyChoice, int userId, String newValue);
	public abstract boolean viewUsers(String branchname);
	
	


}
