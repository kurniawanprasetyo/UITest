import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Checker'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Fee/Approve Fee/Menu Fee'))

WebUI.scrollToElement(findTestObject('Fee/Approve Fee/Submenu Approval Fee'), 3)

WebUI.click(findTestObject('Fee/Approve Fee/Submenu Approval Fee'))

WebUI.click(findTestObject('Fee/Approve Fee/Edit'))

WebUI.selectOptionByValue(findTestObject('Fee/Approve Fee/Select Status'), 'checked', true)

WebUI.click(findTestObject('Fee/Approve Fee/Save'))

WebUI.click(findTestObject('Object Repository/Sign Out/Profile'))

WebUI.click(findTestObject('Object Repository/Sign Out/Sign out'))