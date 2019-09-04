package global.coda.hospital.patientdao;

import java.util.List;

import global.coda.hospital.bean.PatientRecord;

public abstract class PersonDAOPattern {
	String type="";

	public PersonDAOPattern() {
		
	}
	public void patientDataBase(List<PatientRecord> recordmap) {	
	}
	public List<PatientRecord> patientDataBaseRead() {
		return null;
		}
}
