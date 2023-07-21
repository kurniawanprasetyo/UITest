import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Maker'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_CashIn/Menu Virtual Account'))

WebUI.click(findTestObject('Page_CashIn/Submenu CashIn'))

WebUI.click(findTestObject('Page_CashIn/klik_AddCashIn'))

WebUI.selectOptionByValue(findTestObject('Page_CashIn/select Account'), GlobalVariable.va_id, true)

WebUI.setText(findTestObject('Page_CashIn/input Amount(IDR)'), GlobalVariable.amount)

WebUI.setText(findTestObject('Page_CashIn/input Remark'), GlobalVariable.remark)

WebUI.click(findTestObject('Page_CashIn/klik_Submit'))

WebUI.click(findTestObject('Object Repository/Sign Out/Profile'))

WebUI.click(findTestObject('Object Repository/Sign Out/Sign out'))

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Virtual Account/Checked by Checker'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Virtual Account/Approve by Approval'), [:], FailureHandling.STOP_ON_FAILURE)