import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Login Page/Username'), GlobalVariable.email_checker)

WebUI.setText(findTestObject('Login Page/Password'), GlobalVariable.pass_checker)

WebUI.click(findTestObject('Login Page/Sign In'))