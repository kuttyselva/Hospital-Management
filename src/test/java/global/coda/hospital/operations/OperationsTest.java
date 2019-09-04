package global.coda.hospital.operations;

import java.util.*;

import org.testng.annotations.*;
import global.coda.hospital.bean.PatientRecord;

import global.coda.hospital.exceptions.HospitalExceptions;

public class OperationsTest {
	Operations operation;
	@BeforeTest
	public void SetUp() {
		operation=new Operations();
	}
	
//	//IOexceptions test Invalid Input Exception
//	@Test (expectedExceptions =  {global.coda.hospital.exceptions.HospitalExceptions.class}, expectedExceptionsMessageRegExp = "HOS1000E:Invalid Input Exception")
//	public void createIOTest() throws HospitalExceptions {
//		//giving string as input for age
//			operation.createRecord(1);
//	}
	
//	//IOexceptions test Invalid Input Exception
		@Test (expectedExceptions =  {global.coda.hospital.exceptions.HospitalExceptions.class}, expectedExceptionsMessageRegExp = "HOS1000E:Invalid Input Exception") 
		public void updateIOTest() throws HospitalExceptions {
			List<PatientRecord> recordlist=new ArrayList<>();
			PatientRecord record=new PatientRecord();
			record.BeanRecordInsert("1", "1","selva"," location");
			recordlist.add(record);
			/*
			 * give input as id 1
			 * name a
			 * age a
			 */
				operation.updateRecord(recordlist);
		}
		
	

}



