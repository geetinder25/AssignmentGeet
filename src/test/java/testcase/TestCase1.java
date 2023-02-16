package testcase;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class TestCase1 extends BaseTest {

	@Test
	public void calculateNumberOfParcelStations() {
		//store all parcel station web elements in an arraylist
		List<WebElement> ArrayList = driver.findElements(By.xpath(locators.getProperty("count_packetStation_xpath")));
		log.info("Webelements of all parcel stations have been stored in ArrayList");
		int size = ArrayList.size();
		System.out.println("Number of A1 parcel stations: "+size);
		
		//Assertion if the count of Parcel stations is equal to 96
		Assertions.assertEquals(96, size);
		log.info("Assertion is successful");

	}


}
