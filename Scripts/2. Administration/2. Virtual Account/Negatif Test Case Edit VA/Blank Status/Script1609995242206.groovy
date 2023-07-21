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

String expectedInstitution = 'Artajasa UAT(987987)'

String currentlyInstitution = ''

int j = 1

while (!(expectedInstitution.equals(currentlyInstitution))) {
	
	WebDriver driver = DriverFactory.getWebDriver()

	WebElement Table = driver.findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody'))

	List<WebElement> Rows = Table.findElements(By.tagName('tr'))

	table: for (int i = 0; i < Rows.size(); i++) {
		
		println(Rows.get(i).getText())

		List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))

		println(Cols.get(2).getText())

		if (Cols.get(2).getText().equalsIgnoreCase(expectedInstitution)) {
			
			Cols.get(5).findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody/tr['+j+']/td[6]/a[2]')).click()
			
			currentlyInstitution = expectedInstitution

			table: break
		}
		
		j++
		
	}
	
	if (!(expectedInstitution.equals(currentlyInstitution))) {
		
		WebUI.click(findTestObject('Object Repository/Routing/next Page'))
		
	}
	
	j = 1
}

WebUI.sendKeys(findTestObject('Object Repository/Virtual Account/input_Virtual Account Name'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Virtual Account/input_Virtual Account Name'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/Virtual Account/input_Virtual Account Name'), 'VA Edited')

WebUI.selectOptionByLabel(findTestObject('Object Repository/Virtual Account/select_Choose Status'), 'Choose Status', true)

WebUI.click(findTestObject('Object Repository/Virtual Account/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Virtual Account/Notif Required Field'), 10)