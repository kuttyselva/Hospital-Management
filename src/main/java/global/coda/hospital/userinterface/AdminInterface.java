package global.coda.hospital.userinterface;

import global.coda.hospital.bean.BranchRecord;

public interface AdminInterface {

    public abstract boolean createBranch(BranchRecord record);
    public abstract boolean modifyBranch(int modifyChoice, String branchName, String newValue);


}
