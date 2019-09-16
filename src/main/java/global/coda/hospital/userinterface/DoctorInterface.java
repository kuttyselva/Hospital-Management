package global.coda.hospital.userinterface;

import global.coda.hospital.bean.DoctorRecord;


public interface DoctorInterface {
    public abstract boolean createDoctor(DoctorRecord record);
    public abstract boolean updateDoctor(int modifyChoice, int userId, String newValue);
    public abstract boolean viewUsers(String branchname);

}
