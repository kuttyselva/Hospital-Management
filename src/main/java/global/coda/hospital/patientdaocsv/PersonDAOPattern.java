package global.coda.hospital.patientdaocsv;

import java.util.List;

import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.exceptions.HospitalExceptions;

/**
 * @author VC
 *
 */
public abstract class PersonDAOPattern {
	String type = "";

	/**
	 * constructor.
	 */
	public PersonDAOPattern() {

	}

	/**
	 * @param recordmap of record.
	 */
	public void patientDataBase(List<PatientRecord> recordmap) {
	}

	/**
	 * @return list of records.
	 * @throws HospitalExceptions for handle.
	 */
	public List<PatientRecord> patientDataBaseRead() throws HospitalExceptions {
		return null;
	}
}
