import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.google.common.collect.FilteredEntryMultimap.Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Admin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('User Management/Menu User Management'), 3)

WebUI.click(findTestObject('User Management/Menu User Management'))

WebUI.selectOptionByValue(findTestObject('User Management/Data per page'), '10', true)

// Mencari user dengan username yang diinputkan pada global variable

String ExpectedUsername = GlobalVariable.user_username;

int k = 1;

WebDriver driver = DriverFactory.getWebDriver()

WebElement Table = driver.findElement(By.xpath("//*[@id='kt_content']/div[2]/div/div/div[2]/div[1]/table/tbody"))

List<WebElement> Rows = Table.findElements(By.tagName('tr'))

table: for (int i = 0; i < Rows.size(); i++) {
	
	List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
		
	for (int j = 0; j < Cols.size(); j++) {
		
		println(Cols.get(j).getText())
		
		WebUI.delay(1)
		
		// Apabila menemukan menemukan expected user maka akan klik edit user
		
		if (Cols.get(j).getText().equalsIgnoreCase(ExpectedUsername)) {
			
			Cols.get(7).findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody/tr['+k+']/td[8]/button[1]')).click()

			break table
		}
	}
	k++
}

WebUI.sendKeys(findTestObject('Object Repository/User Management/Edit_FirstName'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/User Management/Edit_FirstName'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/User Management/Edit_FirstName'), 'kurniawan')

WebUI.sendKeys(findTestObject('Object Repository/User Management/Edit_Lastname'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/User Management/Edit_Lastname'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/User Management/Edit_Lastname'), 'edit')

WebUI.sendKeys(findTestObject('Object Repository/User Management/Edit_Phone'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/User Management/Edit_Phone'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/User Management/Edit_Phone'),'+62 821-3751-2020')

WebUI.sendKeys(findTestObject('Object Repository/User Management/Edit_Username'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/User Management/Edit_Username'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/User Management/Edit_Username'), 'kurniawanedit')

WebUI.sendKeys(findTestObject('Object Repository/User Management/Email'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/User Management/Email'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/User Management/Email'), 'mbekurprasetyogmail.com')

WebUI.click(findTestObject('Object Repository/User Management/button_Save(Edit)'))

WebUI.verifyElementPresent(findTestObject('Object Repository/User Management/Notif invalid Email'), 10)