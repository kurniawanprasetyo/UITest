import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Login Page/Sign In'))

WebUI.verifyElementPresent(findTestObject('Login Page/Error_Required field_Username'), 20)

WebUI.closeBrowser()