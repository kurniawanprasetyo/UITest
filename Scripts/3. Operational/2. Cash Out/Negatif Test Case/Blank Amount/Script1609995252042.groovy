import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Maker'), [:], FailureHandling.STOP_ON_FAILURE)

// Menuju ke menu Cash Out

WebUI.click(findTestObject('Page_CashIn/Menu Virtual Account'))

WebUI.click(findTestObject('Page_CashOut/Submenu_Cash Out'))

// Menuju ke form add Cash Out

WebUI.click(findTestObject('Page_CashOut/Add_Cash Out'))

WebUI.selectOptionByValue(findTestObject('Page_CashOut/Account'), GlobalVariable.va_id, true)

WebUI.setText(findTestObject('Page_CashOut/Remark'), GlobalVariable.remark)

WebUI.click(findTestObject('Object Repository/Page_CashOut/Submit - Blank Account'))

WebUI.verifyElementPresent(findTestObject('Page_CashOut/Error This field is required'), 20)