package global.coda.hospital.operations;

import org.testng.AssertJUnit;
import static org.testng.Assert.*;

import java.io.IOException;
import java.util.InputMismatchException;

import org.testng.annotations.*;

import global.coda.hospital.exceptions.HospitalExceptions;

public class OperationsTest {
	Operations operation;
	@BeforeTest
	public void SetUp() {
		operation=new Operations();
	}
	
//	//IOexceptions test Invalid Input Exception
//	@Test (expectedExceptions =  {global.coda.hospital.exceptions.HospitalExceptions.class}, expectedExceptionsMessageRegExp = "Invalid Input Exception")
//	public void createIOTest() throws HospitalExceptions {
//		//giving string as input for age
//			operation.create();
//	}
	
//	//IOexceptions test Invalid Input Exception
//		@Test (expectedExceptions =  {global.coda.hospital.exceptions.HospitalExceptions.class}, expectedExceptionsMessageRegExp = "Invalid Input Exception") 
//		public void updateIOTest() throws HospitalExceptions {
//			
//				operation.update();
//		}
		
	

}



