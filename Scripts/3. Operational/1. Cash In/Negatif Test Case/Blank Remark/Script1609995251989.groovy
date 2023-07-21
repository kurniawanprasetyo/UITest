import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Maker'), [:], FailureHandling.STOP_ON_FAILURE)

// Menuju ke menu Add Cash In

WebUI.click(findTestObject('Page_CashIn/Menu Virtual Account'))

WebUI.click(findTestObject('Page_CashIn/Submenu CashIn'))

// Menuju ke form Add Cash IN

WebUI.click(findTestObject('Page_CashIn/klik_AddCashIn'))

WebUI.selectOptionByValue(findTestObject('Page_CashIn/select Account'), GlobalVariable.va_id, true)

WebUI.setText(findTestObject('Page_CashIn/input Amount(IDR)'), GlobalVariable.amount)

WebUI.click(findTestObject('Page_CashIn/klik_Submit'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_CashOut/Error This field is required'), 20)