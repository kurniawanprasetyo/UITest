import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.google.common.collect.FilteredEntryMultimap.Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.Keys as Keys

// Login sebagai admin

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Admin'), [:], FailureHandling.STOP_ON_FAILURE)

// Masuk ke menu TT Credit Mapping

WebUI.click(findTestObject('Routing/Menu Routing Destination'))

WebUI.scrollToElement(findTestObject('Object Repository/TT Credit Mapping/submenu TransferTo Credit Mapping'), 3)

WebUI.click(findTestObject('Object Repository/TT Credit Mapping/submenu TransferTo Credit Mapping'))

String eDestination = "CHE"

String sDestination = ""

int j = 1;

while (!eDestination.equals(sDestination)){
	
	WebDriver driver = DriverFactory.getWebDriver()
	
	WebElement Table = driver.findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody'))
	
	List<WebElement> Rows = Table.findElements(By.tagName('tr'))
	
	table: for (int i = 0; i < Rows.size(); i++) {
		
		println(Rows.get(i).getText())
	
		List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
		
		println(Cols.get(0).getText())
			
		if (Cols.get(0).getText().equalsIgnoreCase(eDestination)) {
				
			Cols.get(4).findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody/tr['+j+']/td[5]/button[1]')).click()
											  
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

WebUI.sendKeys(findTestObject('Object Repository/TT Credit Mapping/input_Beneficiary Account Number'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/TT Credit Mapping/input_Beneficiary Account Number'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/TT Credit Mapping/input_Beneficiary Account Number'), 'iban_edit')

WebUI.sendKeys(findTestObject('Object Repository/TT Credit Mapping/input_Beneficiary Additional Code'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/TT Credit Mapping/input_Beneficiary Additional Code'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/TT Credit Mapping/input_Beneficiary Additional Code'), 'swift_bic_code_edit')

WebUI.click(findTestObject('Object Repository/TT Credit Mapping/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/TT Credit Mapping/Notif success update credit mapping'),10)