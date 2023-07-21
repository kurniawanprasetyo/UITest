import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

// Login sebagai SEO Approval

WebUI.setText(findTestObject('Login Page/Username'), GlobalVariable.email_approval)

WebUI.setText(findTestObject('Login Page/Password'), GlobalVariable.pass_approval)

WebUI.click(findTestObject('Login Page/Sign In'))

// Menuju ke menu Approval Account

WebUI.click(findTestObject('Object Repository/Page_Approval/Virtual Account'))

WebUI.scrollToElement(findTestObject('Page_Approval/Submenu Approval Account'), 3)

WebUI.click(findTestObject('Page_Approval/Submenu Approval Account'))

// Mengubah status menjadi DENIED

WebUI.click(findTestObject('Page_Approval/button_Edit'))

WebUI.selectOptionByValue(findTestObject('Page_Approval/select_Action'), 'denied', true)

WebUI.click(findTestObject('Page_Approval/klik_Update'))

// Log out

WebUI.click(findTestObject('Object Repository/Sign Out/Profile'))

WebUI.click(findTestObject('Object Repository/Sign Out/Sign out'))