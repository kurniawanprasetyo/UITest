import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Maker'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Fee/Add Fee/Klik Fee'))

WebUI.scrollToElement(findTestObject('Object Repository/Fee/Add Fee/Klik Submenu Fee'), 3)

WebUI.click(findTestObject('Object Repository/Fee/Add Fee/Klik Submenu Fee'))

WebUI.click(findTestObject('Fee/Add Fee/Add Fee'))

WebUI.sendKeys(findTestObject('Object Repository/Fee/Add Fee/Klik start periode'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Fee/Add Fee/Klik start periode'), Keys.chord(Keys.BACK_SPACE))

WebUI.selectOptionByValue(findTestObject('Fee/Add Fee/Select CA'), GlobalVariable.va_id_operational_fee, true)

WebUI.selectOptionByValue(findTestObject('Fee/Add Fee/Select Destination'), GlobalVariable.fee_dest_code, true)

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Fee/Add Fee/Add Fee Profile'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Fee/Add Fee/Choose Tier'), '1', true)

WebUI.setText(findTestObject('Object Repository/Fee/Add Fee/Max Fee'), '400')

WebUI.setText(findTestObject('Object Repository/Fee/Add Fee/Fee USD'), '7')

WebUI.click(findTestObject('Fee/Add Fee/Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/User Management/Notif Required Field'), 10)