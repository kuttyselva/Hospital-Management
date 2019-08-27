package global.coda.hospital.patientdao;

import com.opencsv.*;
import com.opencsv.bean.*;
import global.coda.hospital.bean.PatientRecord;

import java.io.*;
import java.util.List;

public class PatientDAO {
    private final String CSV_LOCATION = "C:\\Users\\kutty\\Documents\\Hospital\\src\\main\\resources\\databaseCSV\\data.csv";

    public void patientDataBase(List<PatientRecord> patientRecords) {

        try {

            // Creating writer class to generate
            // csv file
            FileWriter writer = new
                    FileWriter(CSV_LOCATION);

            // create a list of employee

            // Create Mapping Strategy to arrange the
            // column name in order
            ColumnPositionMappingStrategy<PatientRecord> mappingStrategy =
                    new ColumnPositionMappingStrategy<>();
            mappingStrategy.setType(PatientRecord.class);

            // Arrange column name as provided in below array.
            String[] columns = new String[]
                    {"id", "name", "age", "location"};
            mappingStrategy.setColumnMapping(columns);

            // Createing StatefulBeanToCsv object
            StatefulBeanToCsvBuilder<PatientRecord> builder =
                    new StatefulBeanToCsvBuilder<>(writer);
            StatefulBeanToCsv<PatientRecord> beanWriter =
                    builder.withMappingStrategy(mappingStrategy).build();

            // Write list to StatefulBeanToCsv object
            beanWriter.write(patientRecords);

            // closing the writer object
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<PatientRecord> patientDataBaseRead() {
        List<PatientRecord> empList = null;
        CSVReader csvReader = null;

        try {
            /*
             * Reading the CSV File
             * Delimiter is comma
             * Default Quote character is double quote
             * Start reading from line 1
             */
            csvReader = new CSVReader(new FileReader(CSV_LOCATION), ',', '"');
            //mapping of columns with their positions
            ColumnPositionMappingStrategy<PatientRecord> mappingStrategy =
                    new ColumnPositionMappingStrategy<PatientRecord>();
            //Set mappingStrategy type to Employee Type
            mappingStrategy.setType(PatientRecord.class);
            //Fields in Employee Bean
            String[] columns = new String[]{"id", "name", "age", "location"};
            //Setting the colums for mappingStrategy
            mappingStrategy.setColumnMapping(columns);
            //create instance for CsvToBean class
            CsvToBean<PatientRecord> ctb = new CsvToBean<PatientRecord>();
            //parsing csvReader(Employee.csv) with mappingStrategy
            empList = ctb.parse(mappingStrategy, csvReader);
            //Print the Employee Details

        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                //closing the reader

                assert csvReader != null;
                csvReader.close();
                return empList;
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        return empList;
    }
}
