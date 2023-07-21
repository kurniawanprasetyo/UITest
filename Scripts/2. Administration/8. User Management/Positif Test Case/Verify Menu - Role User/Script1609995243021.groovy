import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Login Page/Username'), GlobalVariable.user_email)

WebUI.setText(findTestObject('Login Page/Password'), GlobalVariable.user_pass)

WebUI.click(findTestObject('Login Page/Sign In'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify Menu/Menu Virtual Account'), 10)

WebUI.click(findTestObject('Object Repository/Verify Menu/Menu Virtual Account'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify Menu/Submenu Mutation'), 10)

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify Menu/Menu Reconcile'), 10)

WebUI.click(findTestObject('Object Repository/Verify Menu/Menu Reconcile'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify Menu/Submenu Report'), 10)

WebUI.click(findTestObject('Object Repository/Verify Menu/Submenu Report'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify Menu/Submenu Success'), 10)

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify Menu/Submenu Failed'), 10)

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify Menu/Submenu Pending'), 10)

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify Menu/Submenu Overdue'), 10)

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify Menu/Submenu Verification'), 10)

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify Menu/Menu Transactions'), 10)

WebUI.click(findTestObject('Object Repository/Verify Menu/Menu Transactions'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify Menu/Submenu Monitoring'), 10)

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify Menu/Menu Fee'), 10)

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify Menu/Menu Rate'), 10)

WebUI.click(findTestObject('Object Repository/Verify Menu/Menu Rate'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify Menu/Submenu Rate Artajasa'), 10)
