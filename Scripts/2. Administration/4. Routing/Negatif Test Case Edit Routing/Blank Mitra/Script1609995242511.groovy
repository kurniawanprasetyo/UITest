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

WebUI.scrollToElement(findTestObject('Routing/Submenu Routing'), 3)

WebUI.click(findTestObject('Routing/Submenu Routing'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Routing/select_3510'), '10', true)

String expectedInstitution = "INTEGRATION BANK(241120)"

String currentlyInstitution = ""

while (!(expectedInstitution.equals(currentlyInstitution))) {
	
	WebDriver driver = DriverFactory.getWebDriver()

	WebElement Table = driver.findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody'))

	List<WebElement> Rows = Table.findElements(By.tagName('tr'))

	table: for (int i = 0; i < Rows.size(); i++) {
		
		println(Rows.get(i).getText())

		List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))

		println(Cols.get(2).getText())

		if (Cols.get(0).getText().equalsIgnoreCase(expectedInstitution)) {
			
			Cols.get(8).click()
			
			currentlyInstitution = expectedInstitution

			table: break
		}
		
	}
	
	if (!(expectedInstitution.equals(currentlyInstitution))) {
		
		WebUI.click(findTestObject('Object Repository/Routing/next Page'))
		
	}

}

WebUI.selectOptionByValue(findTestObject('Object Repository/Routing/Select Feature'), 'outbound', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Routing/Select Transaction Type'), 'C2C', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Routing/select Auto Route'), '0', true)

WebUI.click(findTestObject('Routing/button_Submit'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Routing/Notif Required Field'), 10)