package global.coda.hospital.userinterface;

import global.coda.hospital.bean.DoctorRecord;
import global.coda.hospital.bean.PatientRecord;

public interface AdminInterface {

    public abstract boolean createPatient(PatientRecord record);
    public abstract boolean createDoctor(DoctorRecord record);
    public abstract boolean modifyPatient(int modifyChoice, int userId, String newValue);
    public abstract boolean modifyDoctor(int modifyChoice, int userId, String newValue);
    public abstract boolean patientDoctorEntry(DoctorRecord record);





}
