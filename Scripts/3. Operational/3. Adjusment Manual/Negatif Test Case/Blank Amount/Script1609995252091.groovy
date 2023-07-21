import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Maker'), [:], FailureHandling.STOP_ON_FAILURE)

// Menuju ke menu Adjustment

WebUI.click(findTestObject('Adjustment/Menu Virtual Account'))

WebUI.click(findTestObject('Adjustment/Submenu Adjustment'))

// Menuju ke form add Adjustment

WebUI.click(findTestObject('Adjustment/Add_Adjustment'))

WebUI.click(findTestObject('Object Repository/Adjustment/Amount'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Adjustment/Choose Account'), GlobalVariable.va_id, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Adjustment/Choose Type'), 'Refund success', true)

WebUI.setText(findTestObject('Object Repository/Adjustment/Reference_id'), '360001AAEC8DB8082810')

WebUI.click(findTestObject('Object Repository/Adjustment/klik_Submit'))

WebUI.verifyElementPresent(findTestObject('Adjustment/Alert_Required field'), 10)