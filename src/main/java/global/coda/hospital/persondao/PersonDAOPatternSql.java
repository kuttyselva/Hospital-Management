package global.coda.hospital.persondao;

import java.sql.SQLException;
import java.util.List;

import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.exceptions.HospitalExceptions;

public abstract class PersonDAOPatternSql {
	String type="";

	public PersonDAOPatternSql() {
		
	}
	public void patientDataBase(List<PatientRecord> recordmap) {	
	}
	public List<PatientRecord> patientDataBaseRead() throws HospitalExceptions {
		return null;
		}
	public abstract boolean createPatient(PatientRecord createRecord) throws ClassNotFoundException, SQLException;
	public abstract boolean checkUser(String string) throws ClassNotFoundException, SQLException;
}