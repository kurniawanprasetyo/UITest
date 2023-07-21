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

WebUI.click(findTestObject('Object Repository/Destination/button Add Dest'))

WebUI.setText(findTestObject('Object Repository/Destination/input Destination ID'), GlobalVariable.dest_id)

WebUI.setText(findTestObject('Object Repository/Destination/input_Destination Name'), GlobalVariable.dest_name)

WebUI.selectOptionByValue(findTestObject('Object Repository/Destination/select Country Code'), GlobalVariable.country_code, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Destination/select Feature'), GlobalVariable.dest_feature, true)

WebUI.setText(findTestObject('Object Repository/Destination/input 987 Payer ID'), GlobalVariable.inbond_payer)

WebUI.click(findTestObject('Object Repository/Destination/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Destination/Notif Success Add'), 5)