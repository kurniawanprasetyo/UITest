import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Admin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('User Management/Menu User Management'), 3)

WebUI.click(findTestObject('User Management/Menu User Management'))

// Menyimpan username yang sudah terdaftar di menu user

WebUI.delay(5)

String existUsername = ''

WebDriver driver = DriverFactory.getWebDriver()

WebElement table = driver.findElement(By.xpath("//*[@id='kt_content']/div[2]/div/div/div[2]/div[1]/table/tbody"))

List<WebElement> Rows = table.findElements(By.tagName('tr'))

List<WebElement> Cols = Rows.get(0).findElements(By.tagName('td'))

println(Cols.get(2).getText())

existUsername = Cols.get(2).getText()

WebUI.click(findTestObject('User Management/Add User'))

WebUI.selectOptionByValue(findTestObject('User Management/Choose Role'), GlobalVariable.user_role, true)

WebUI.selectOptionByValue(findTestObject('User Management/Choose Institution'), GlobalVariable.user_institution, true)

WebUI.setText(findTestObject('User Management/First Name'), GlobalVariable.user_first_name)

WebUI.setText(findTestObject('User Management/Last Name'), GlobalVariable.user_last_name)

WebUI.setText(findTestObject('User Management/Phone Number'), GlobalVariable.user_phone_number)

WebUI.setText(findTestObject('User Management/Username'), existUsername)

WebUI.setText(findTestObject('User Management/Email'), GlobalVariable.user_email)

WebUI.setText(findTestObject('User Management/PAssword'), GlobalVariable.user_pass)

WebUI.setText(findTestObject('User Management/Confirm Password'), GlobalVariable.user_pass)

WebUI.click(findTestObject('User Management/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/User Management/Notif Username Exist'), 10)