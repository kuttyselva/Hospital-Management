package global.coda.hospital.operations;

import static org.testng.Assert.assertFalse;

import java.util.*;

import org.apache.logging.log4j.core.util.Assert;
import org.testng.annotations.*;
import global.coda.hospital.bean.PatientRecord;

import global.coda.hospital.exceptions.HospitalExceptions;

//public class OperationsTest {
//	Operations operation;
//	List<PatientRecord> recordlist;
//	PatientRecord record;
//	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
//			Locale.getDefault());
//	@BeforeTest
//	public void SetUp() {
//		operation = new Operations();
//		recordlist = new ArrayList<>();
//		record = new PatientRecord();
//		
//	}
//
////	//IOexceptions test Invalid Input Exception
//	/*
//	 * create function test
//	 */
//	@Test (expectedExceptions =  {global.coda.hospital.exceptions.HospitalExceptions.class}, expectedExceptionsMessageRegExp = "HOS1000E:Invalid Input Exception")
//	public void createIOTest() throws HospitalExceptions {
//		//giving string as input for age
//			operation.createRecord(1);
//	}
//
////	//IOexceptions test Invalid Input Exception
//	/*
//	 * update function test
//	 */
//	@Test(expectedExceptions = {
//			global.coda.hospital.exceptions.HospitalExceptions.class }, expectedExceptionsMessageRegExp = "HOS1000E:Invalid Input Exception")
//	public void updateIOTest() throws HospitalExceptions {
//
//		record.BeanRecordInsert("1", "1", "selva", " location");
//		recordlist.add(record);
//		/*
//		 * give input as id 1 name a age a
//		 */
//		operation.updateRecord(recordlist);
//	}
//	
//	/*
//	 * delete function test
//	 * input name=a,age=a
//	 */
//	@Test
//	public void deleteIOTest() throws HospitalExceptions {
//
//		record.BeanRecordInsert("1", "1", "selva", " location");
//		recordlist.add(record);
//		/*
//		 * give input as id 1 name a age a
//		 */
//		operation.deleteRecord(recordlist);
//		Assert.isEmpty(recordlist);
//	}
//	
//	/*
//	 * display all test
//	 * sending empty collection
//	 */
//	@Test
//	public void displayallTest() throws HospitalExceptions {
//
//		
//		record.BeanRecordInsert("id", "age", "name", " location");
//		recordlist.add(record);
//		assertFalse(operation.displayAllRecord(recordlist));
//	}
//	
//	
//	/*
//	 * read test
//	 * sending empty collection
//	 */
//	@Test
//	public void readTest() throws HospitalExceptions {
//		assertFalse(operation.readRecord(recordlist));
//	}
//	
//	

