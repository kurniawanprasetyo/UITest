import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

// Login sebagai admin

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Admin'), [:], FailureHandling.STOP_ON_FAILURE)

// Masuk ke menu Virtual Account

WebUI.click(findTestObject('Object Repository/Virtual Account/span_Virtual Account'))

WebUI.click(findTestObject('Object Repository/Virtual Account/button_New Account'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Virtual Account/select_Choose Institutions'), GlobalVariable.va_ca_id, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Virtual Account/select_Choose Status'), 'ACTIVE', true)

WebUI.setText(findTestObject('Object Repository/Virtual Account/input_EnterVirtual Account ID_va_id'), GlobalVariable.va_id)

WebUI.setText(findTestObject('Object Repository/Virtual Account/input_Virtual Account Name'), GlobalVariable.va_name)

WebUI.selectOptionByValue(findTestObject('Virtual Account/Choose Feature 1'), GlobalVariable.va_feature1, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Virtual Account/Choose Status Feature 1'), GlobalVariable.va_feature_status1, true)

WebUI.click(findTestObject('Object Repository/Virtual Account/Klik Pilih Negara 1'))

WebUI.click(findTestObject('Object Repository/Create CA/Choose Chinese'))

WebUI.click(findTestObject('Object Repository/Create CA/Choose Greece'))

WebUI.click(findTestObject('Object Repository/Create CA/Choose Malaysia'))

WebUI.click(findTestObject('Object Repository/Virtual Account/button_Add Feature'))

WebUI.selectOptionByValue(findTestObject('Virtual Account/Choose Feature 2'), GlobalVariable.va_feature2, true)
	
WebUI.selectOptionByValue(findTestObject('Object Repository/Virtual Account/Choose Status Feature 2'), GlobalVariable.va_feature_status2, true)

WebUI.click(findTestObject('Object Repository/Virtual Account/Klik Pilih Negara 2'))

WebUI.click(findTestObject('Object Repository/Create CA/Choose Chinese'))

WebUI.click(findTestObject('Object Repository/Create CA/Choose Greece'))

WebUI.click(findTestObject('Object Repository/Create CA/Choose Malaysia'))

WebUI.click(findTestObject('Object Repository/Virtual Account/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Virtual Account/Notif Required Field'), 10)