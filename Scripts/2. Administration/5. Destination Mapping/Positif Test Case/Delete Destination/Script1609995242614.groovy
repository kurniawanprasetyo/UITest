import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Admin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Routing/Menu Routing Destination'))

WebUI.scrollToElement(findTestObject('Object Repository/Destination/Submenu Destination'), 3)

WebUI.click(findTestObject('Object Repository/Destination/Submenu Destination'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Destination/select Show per Page'), '10', true)

String eDestination = "All Banks Cyprus"

String sDestination = ""

int j = 1;

while (!eDestination.equals(sDestination)){
	
	WebDriver driver = DriverFactory.getWebDriver()
	
	WebElement Table = driver.findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody'))
	
	List<WebElement> Rows = Table.findElements(By.tagName('tr'))
	
	table: for (int i = 0; i < Rows.size(); i++) {
		
		println(Rows.get(i).getText())
	
		List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
		
		println(Cols.get(1).getText())
			
		if (Cols.get(1).getText().equalsIgnoreCase(eDestination)) {
				
			Cols.get(7).findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody/tr['+j+']/td[8]/button[2]')).click()
											  
			sDestination = eDestination
			
			println(sDestination)
	
			break table
		}
	
	j++
	
	}
		
	if (!eDestination.equals(sDestination)){
	
		WebUI.click(findTestObject('Object Repository/Routing/next Page'))
	
	}
	
	j = 1;
	
	println(j)
}

WebUI.click(findTestObject('Object Repository/Destination/button Konfirmasi Delete'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Destination/Notif Success Delete'), 5)