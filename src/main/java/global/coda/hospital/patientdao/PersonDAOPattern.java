package global.coda.hospital.patientdao;

import java.util.List;

import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.exceptions.HospitalExceptions;

/**
 * @author VC
 */
public abstract class PersonDAOPattern {
	protected String type = "";

	/**
	 * constructor.
	 */
	public PersonDAOPattern() {

	}

	/**
	 * @param recordmap list of record.
	 */
	public void patientDataBase(List<PatientRecord> recordmap) {
	}

	/**
	 * @return list of rec.
	 * @throws HospitalExceptions handling.
	 */
	public List<PatientRecord> patientDataBaseRead() throws HospitalExceptions {
		return null;
	}
}
