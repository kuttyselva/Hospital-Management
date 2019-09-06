package global.coda.hospital.patientdao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import global.coda.hospital.Hospital;
import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.constants.HospitalConstants;

public class PatientDAO extends PersonDAOPattern {

	public PatientDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
			Locale.getDefault());
	private final String CSV_LOCATION = LOCAL_MESSAGES_BUNDLE.getString("HOS0000P");
	private static final Logger LOGGER = LogManager.getLogger(Hospital.class);

	public void patientDataBase(List<PatientRecord> patientRecords) {
		try {
			// Creating writer class to generate
			// csv file
			FileWriter writer = new FileWriter(CSV_LOCATION);

			// create a list of employee

			// Create Mapping Strategy to arrange the
			// column name in order
			ColumnPositionMappingStrategy<PatientRecord> mappingStrategy = new ColumnPositionMappingStrategy<>();
			mappingStrategy.setType(PatientRecord.class);
			// Arrange column name as provided in below array.
			String[] columns = new String[] { "id", "name", "age", "location" };
			mappingStrategy.setColumnMapping(columns);

			// Createing StatefulBeanToCsv object
			StatefulBeanToCsvBuilder<PatientRecord> beantocsvbuilder = new StatefulBeanToCsvBuilder<>(writer);
			StatefulBeanToCsv<PatientRecord> beanWriter = beantocsvbuilder.withMappingStrategy(mappingStrategy).build();

			// Write list to StatefulBeanToCsv object
			beanWriter.write(patientRecords);

			// closing the writer object
			writer.close();
		} catch (Exception e) {
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1200E));
		}
	}

	@SuppressWarnings("null")
	public void patientsingleCSVupdate(PatientRecord record) {
		List<PatientRecord> patientRecords = null;

		try {
			// Creating writer class to generate
			// csv file
			File csvfile = new File(CSV_LOCATION);
			if (csvfile.exists() && csvfile.canWrite() && csvfile.isFile()) {
				FileWriter filewriter = new FileWriter(CSV_LOCATION, true);

				patientRecords.add(record);

				// create a list of employee

				// Create Mapping Strategy to arrange the
				// column name in order
				ColumnPositionMappingStrategy<PatientRecord> mappingStrategy = new ColumnPositionMappingStrategy<>();
				mappingStrategy.setType(PatientRecord.class);
				// Arrange column name as provided in below array.
				String[] columns = new String[] { "id", "name", "age", "location" };
				mappingStrategy.setColumnMapping(columns);

				// Createing StatefulBeanToCsv object
				StatefulBeanToCsvBuilder<PatientRecord> beantocsvbuilder = new StatefulBeanToCsvBuilder<>(filewriter);
				StatefulBeanToCsv<PatientRecord> beanWriter = beantocsvbuilder.withMappingStrategy(mappingStrategy)
						.build();

				// Write list to StatefulBeanToCsv object
				beanWriter.write(patientRecords);

				// closing the writer object
				filewriter.close();
			}
		} catch (Exception e) {
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1200E));
		}

	}

	@SuppressWarnings("deprecation")
	public List<PatientRecord> patientDataBaseRead() {
		List<PatientRecord> empList = null;
		CSVReader csvReader = null;

		try {
			/*
			 * Reading the CSV File Delimiter is comma Default Quote character is double
			 * quote Start reading from line 1
			 */
			csvReader = new CSVReader(new FileReader(CSV_LOCATION), ',', '"');
			// mapping of columns with their positions
			ColumnPositionMappingStrategy<PatientRecord> mappingStrategy = new ColumnPositionMappingStrategy<PatientRecord>();
			// Set mappingStrategy type to Employee Type
			mappingStrategy.setType(PatientRecord.class);
			// Fields in Employee Bean
			String[] columns = new String[] { "id", "name", "age", "location" };
			// Setting the colums for mappingStrategy
			mappingStrategy.setColumnMapping(columns);
			// create instance for CsvToBean class
			CsvToBean<PatientRecord> ctb = new CsvToBean<PatientRecord>();
			// parsing csvReader(Employee.csv) with mappingStrategy
			empList = ctb.parse(mappingStrategy, csvReader);
			// Print the Employee Details

		} catch (Exception ee) {
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1200E));
		} finally {
			try {
				// closing the reader

				assert csvReader != null;
				csvReader.close();
				return empList;
			} catch (Exception ee) {
				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(HospitalConstants.HOS1200E));
			}
		}
		return empList;
	}

	// using json file

}
