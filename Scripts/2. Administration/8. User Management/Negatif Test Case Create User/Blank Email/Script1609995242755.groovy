import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Admin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('User Management/Menu User Management'), 3)

WebUI.click(findTestObject('User Management/Menu User Management'))

WebUI.click(findTestObject('User Management/Add User'))

WebUI.selectOptionByValue(findTestObject('User Management/Choose Role'), GlobalVariable.user_role, true)

WebUI.selectOptionByValue(findTestObject('User Management/Choose Institution'), GlobalVariable.user_institution, true)

WebUI.setText(findTestObject('User Management/First Name'), GlobalVariable.user_first_name)

WebUI.setText(findTestObject('User Management/Last Name'), GlobalVariable.user_last_name)

WebUI.setText(findTestObject('User Management/Phone Number'), GlobalVariable.user_phone_number)

WebUI.setText(findTestObject('User Management/Username'), GlobalVariable.user_username)

WebUI.setText(findTestObject('User Management/PAssword'), GlobalVariable.user_pass)

WebUI.setText(findTestObject('User Management/Confirm Password'), GlobalVariable.user_pass)

WebUI.click(findTestObject('User Management/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/User Management/Notif Required Field'), 10)