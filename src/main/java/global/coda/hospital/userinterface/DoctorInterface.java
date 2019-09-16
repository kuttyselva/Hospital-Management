package global.coda.hospital.userinterface;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.bean.PatientRecord;

import java.util.List;


public interface DoctorInterface {
    public abstract boolean createDoctor(DoctorRecord record);
    public abstract boolean updateDoctor(int modifyChoice, String username, String newValue);
    public abstract List<PatientRecord> viewUsers(String branchname);

}
