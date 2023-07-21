import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

// Login sebagai admin

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Admin'), [:], FailureHandling.STOP_ON_FAILURE)

// Masuk ke menu Virtual Account

WebUI.click(findTestObject('Object Repository/Virtual Account/span_Virtual Account'))

String expectedInstitution = 'Bank Jabar Syariah(360001)'

String currentlyInstitution = ''

String va_id = ''

while (!(expectedInstitution.equals(currentlyInstitution))) {
	
	WebDriver driver = DriverFactory.getWebDriver()

	WebElement Table = driver.findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody'))

	List<WebElement> Rows = Table.findElements(By.tagName('tr'))

	table: for (int i = 0; i < Rows.size(); i++) {
		
		println(Rows.get(i).getText())

		List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))

		println(Cols.get(2).getText())

		if (Cols.get(2).getText().equalsIgnoreCase(expectedInstitution)) {
			
			currentlyInstitution = expectedInstitution

			va_id = Cols.get(0).getText()
			
			println(va_id)

			table: break
		}
		
	}
	
	if (!(expectedInstitution.equals(currentlyInstitution))) {
		
		WebUI.click(findTestObject('Object Repository/Routing/next Page'))
	}
	
}

WebUI.scrollToElement(findTestObject('Object Repository/Virtual Account/button_New Account'), 3)

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Virtual Account/button_New Account'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Virtual Account/select_Choose Institutions'), GlobalVariable.va_ca_id, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Virtual Account/select_Choose Status'), 'ACTIVE', true)

WebUI.setText(findTestObject('Object Repository/Virtual Account/input_EnterVirtual Account ID_va_id'), va_id)

WebUI.setText(findTestObject('Object Repository/Virtual Account/input_Virtual Account Name'), GlobalVariable.va_name)

WebUI.selectOptionByValue(findTestObject('Object Repository/Virtual Account/select_Choose Currency'), GlobalVariable.va_currency, true)

WebUI.selectOptionByValue(findTestObject('Virtual Account/Choose Feature 1'), 'disbursement', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Virtual Account/Choose Status Feature 1'), GlobalVariable.va_feature_status1, true)

WebUI.click(findTestObject('Object Repository/Virtual Account/Klik Pilih Negara 1'))

WebUI.click(findTestObject('Object Repository/Create CA/Choose Chinese'))

WebUI.click(findTestObject('Object Repository/Create CA/Choose Greece'))

WebUI.click(findTestObject('Object Repository/Create CA/Choose Malaysia'))

WebUI.click(findTestObject('Object Repository/Virtual Account/button_Save'))