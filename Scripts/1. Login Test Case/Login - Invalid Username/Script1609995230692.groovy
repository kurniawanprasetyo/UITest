import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Login Page/Username'), 'seomaker123')

WebUI.setText(findTestObject('Login Page/Password'), GlobalVariable.pass_maker)

WebUI.click(findTestObject('Login Page/Sign In'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Login Page/Error_The login detail is incorrect'), 20)

WebUI.closeBrowser()