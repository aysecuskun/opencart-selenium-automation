package testCases;

import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC001_TestCase extends BaseClass {
	
	@Test
	public void DemoTest() {
		  
		System.out.println(driver.getTitle());
		
	}

}
