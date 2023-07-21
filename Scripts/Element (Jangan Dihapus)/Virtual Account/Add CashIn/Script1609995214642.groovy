import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

// Login Sebagai SEO Maker
WebUI.setText(findTestObject('Login Page/Username'), GlobalVariable.email_maker)

WebUI.setText(findTestObject('Login Page/Password'), GlobalVariable.pass_maker)

WebUI.click(findTestObject('Login Page/Sign In'))

// Menuju ke menu Virtual Account
WebUI.click(findTestObject('Page_CashIn/Menu Virtual Account'))

WebUI.click(findTestObject('Page_CashIn/Submenu CashIn'))

// Menuju ke Form Add Cash In
WebUI.click(findTestObject('Page_CashIn/klik_AddCashIn'))

WebUI.selectOptionByValue(findTestObject('Page_CashIn/select Account'), va_id, true)

WebUI.setText(findTestObject('Page_CashIn/input Amount(IDR)'), amount)

WebUI.setText(findTestObject('Page_CashIn/input Remark'), GlobalVariable.remark)

WebUI.click(findTestObject('Page_CashIn/klik_Submit'))

// Log Out
WebUI.click(findTestObject('Object Repository/Sign Out/Profile'))

WebUI.click(findTestObject('Object Repository/Sign Out/Sign out'))

// Login sebagai Checker untuk melakukan checked
WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Virtual Account/Checked by Checker'), [:], FailureHandling.STOP_ON_FAILURE)

// Login sebagai approval untuk melakukan approved
WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Virtual Account/Approve by Approval'), [:], FailureHandling.STOP_ON_FAILURE)

