package global.coda.hospital.patientdaocsv;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import global.coda.hospital.bean.PatientRecord;

/**
 * @author VC
 *
 */
public class PatientDAOJson extends PersonDAOPattern {
	/**
	 * constructor.
	 */
	public PatientDAOJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param patientRecords of records.
	 */
	public void patientDataBase(List<PatientRecord> patientRecords) {
		ObjectMapper jsonmapper = new ObjectMapper();
		try {
			for (int i = 1; i < patientRecords.size(); i++) {
				jsonmapper.writeValue(new File(
						"C:\\Users\\VC\\eclipse-workspace\\Hospital\\src\\main\\resources\\databaseCSV\\dbjson.json"),
						patientRecords);
			}
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
