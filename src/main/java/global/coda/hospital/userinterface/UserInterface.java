package global.coda.hospital.userinterface;

public interface UserInterface {
	

	public abstract boolean updateUser(int modifyChoice, int patientUserId, String newPatientValue);
	public abstract boolean viewUsers(int branchId);
	
	


}
