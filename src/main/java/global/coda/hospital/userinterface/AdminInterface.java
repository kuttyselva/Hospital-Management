package global.coda.hospital.userinterface;

import global.coda.hospital.bean.BranchRecord;

/**
 * @author VC
 */
public interface AdminInterface {
	/**
	 * @param record of branch.
	 * @return bool for successful creation.
	 */
	public abstract boolean createBranch(BranchRecord record);

	/**
	 * @param modifyChoice of branch.
	 * @param branchName   of branch.
	 * @param newValue     of branch.
	 * @return bool for success.
	 */
	public abstract boolean modifyBranch(int modifyChoice, String branchName, String newValue);

}
