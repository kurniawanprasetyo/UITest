import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Login Page/Username'), GlobalVariable.email_maker)

WebUI.setText(findTestObject('Login Page/Password'), 'seomaker123')

WebUI.click(findTestObject('Login Page/Sign In'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Login Page/Error_The login detail is incorrect'), 20)