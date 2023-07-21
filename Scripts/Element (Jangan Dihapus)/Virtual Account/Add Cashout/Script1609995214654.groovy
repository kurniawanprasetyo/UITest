import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

// Login sebagai SEO Maker

WebUI.setText(findTestObject('Login Page/Username'), GlobalVariable.email_maker)

WebUI.setText(findTestObject('Login Page/Password'), GlobalVariable.pass_maker)

WebUI.click(findTestObject('Login Page/Sign In'))

// Menuju ke menu Cash Out

WebUI.click(findTestObject('Page_CashIn/Menu Virtual Account'))

WebUI.click(findTestObject('Page_CashOut/Submenu_Cash Out'))

// Menuju ke form add Cash Out

WebUI.click(findTestObject('Page_CashOut/Add_Cash Out'))

WebUI.selectOptionByValue(findTestObject('Page_CashOut/Account'), GlobalVariable.va_id_operational, true)

WebUI.setText(findTestObject('Page_CashOut/Amount'), GlobalVariable.amount)

WebUI.setText(findTestObject('Page_CashOut/Remark'), GlobalVariable.remark)

WebUI.click(findTestObject('Page_CashOut/Submit'))

WebUI.verifyElementPresent(findTestObject('Page_Approval/Tombol Edit'), 10)

// Log Out

WebUI.click(findTestObject('Object Repository/Sign Out/Profile'))

WebUI.click(findTestObject('Object Repository/Sign Out/Sign out'))