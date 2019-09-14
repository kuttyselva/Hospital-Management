package global.coda.hospital.patientdaocsv;

import java.util.List;

import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.exceptions.HospitalExceptions;

public abstract class PersonDAOPattern {
	String type="";

	public PersonDAOPattern() {
		
	}
	public void patientDataBase(List<PatientRecord> recordmap) {	
	}
	public List<PatientRecord> patientDataBaseRead() throws HospitalExceptions {
		return null;
		}
}
