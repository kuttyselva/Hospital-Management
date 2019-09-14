package global.coda.hospital.userinterface;

public interface UserInterface {
	

	public abstract boolean updateUser(int modifyChoice, int userId, String newValue);
	public abstract boolean viewUsers(String branchname);
	
	


}
