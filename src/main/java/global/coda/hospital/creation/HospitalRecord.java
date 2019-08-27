package global.coda.hospital.creation;

import java.util.*;

import global.coda.hospital.patientdao.PatientDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.Hospital;
import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.exceptions.HospitalExceptions;
import global.coda.hospital.operations.Operations;

public class HospitalRecord {
	/**
	 * 
	 */

	// Logger class will log the status
	public static final Logger LOGGER = LogManager.getLogger(Hospital.class);
	// ResourceBundle class will use SystemMessages.properties file
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
			Locale.getDefault());
	PatientRecord bean = new PatientRecord();
	PatientDAO patientdao=new PatientDAO();
	List<PatientRecord> recordmap = patientdao.patientDataBaseRead();

	@SuppressWarnings("resource")
	public void records() throws HospitalExceptions{
		// object initialization for services
		Operations operation = new Operations();

		// bean class object declaration
		int key = 0;
		Random random=new Random();
		boolean casevalue = true;
		while (casevalue) {
			LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1000D"));

			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			try {
				int choice = in.nextInt();
				switch (choice) {
				case 1: {
					// create record function
					key=random.nextInt(9999);
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS1000I"));
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS1100I") + key);

					try {
						 recordmap.add(operation.create(key));
						 patientdao.patientDataBase(recordmap);

					} catch (HospitalExceptions e) {
						e.printStackTrace();
					}

					break;
				}
				case 2: {
					// read record function
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS1001I"));
					try {
						operation.Read(recordmap);
					} catch (HospitalExceptions e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						records();
					}
					break;
				}
				case 3: {
					// update record function
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS1002I"));

					try {
						recordmap=operation.Update(recordmap);
						patientdao.patientDataBase(recordmap);
					} catch (HospitalExceptions e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						records();
					}
					break;

				}
				case 4: {
					// delete record function
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS1003I"));
					try {
						recordmap = operation.Delete(recordmap);
						patientdao.patientDataBase(recordmap);

					} catch (HospitalExceptions e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally {
						this.records();
					}
					break;

				}
				case 5: {
					// delete record function
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS1004I"));
					operation.DisplayAll(recordmap);
					break;

				}
				case 6: {
						// delete record function
						LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS1005I"));
						recordmap.clear();
						casevalue = false;

						break;
					}
				default: {
					// default inputs
					LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString("HOS1001D"));
					break;
				}
				}
			} catch (InputMismatchException e) {
				LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString("HOS1000E"));
				records();
				
			}

		}
	}
}
