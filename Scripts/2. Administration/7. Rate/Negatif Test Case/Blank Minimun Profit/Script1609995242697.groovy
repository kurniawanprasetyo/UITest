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
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Admin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/Rate Artajasa/menu Rate'), 3)

WebUI.click(findTestObject('Object Repository/Rate Artajasa/menu Rate'))

WebUI.scrollToElement(findTestObject('Object Repository/Rate Artajasa/Submenu Threshold Profit'), 3)

WebUI.click(findTestObject('Object Repository/Rate Artajasa/Submenu Threshold Profit'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Rate Artajasa/select Page'), '10', true)

String eDestCurr = GlobalVariable.rate_curr

String sDestCurr = ""

int j = 1;

while (!eDestCurr.equals(sDestCurr)){
	
	WebDriver driver = DriverFactory.getWebDriver()
	
	WebElement Table = driver.findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody'))
	
	List<WebElement> Rows = Table.findElements(By.tagName('tr'))
	
	table: for (int i = 0; i < Rows.size(); i++) {
		
		println(Rows.get(i).getText())
	
		List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
		
		println(Cols.get(0).getText())
			
		if (Cols.get(0).getText().equalsIgnoreCase(eDestCurr)) {
				
			Cols.get(5).findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody/tr['+j+']/td[6]/button')).click()
											 
			sDestCurr = eDestCurr
			
			println(sDestCurr)
	
			break table
		}
	
	j++
	
	}
		
	if (!eDestCurr.equals(sDestCurr)){
	
		WebUI.click(findTestObject('Object Repository/Routing/next Page'))
	
	}
	
	j = 1;
	
	println(j)
	
}

WebUI.sendKeys(findTestObject('Object Repository/Rate Artajasa/min profit updated'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Rate Artajasa/min profit updated'), Keys.chord(Keys.BACK_SPACE))

WebUI.click(findTestObject('Object Repository/Rate Artajasa/button Save'))