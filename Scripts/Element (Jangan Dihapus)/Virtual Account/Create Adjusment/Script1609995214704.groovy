import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Maker'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.maximizeWindow()

// Menuju ke menu Report > Adjusment Reconcile

WebUI.click(findTestObject('Adjustment Reconsile/Menu Reconcile'))

WebUI.click(findTestObject('Adjustment Reconsile/Submenu Report'))

WebUI.click(findTestObject('Adjustment Reconsile/Submenu Recon VA'))

WebUI.delay(2)

// Mencari VA id yang tersedia, untuk pencarian akan diambil data Recon paling atas

String note = ''

String reference_trx = ''

String va = ''

WebDriver driver = DriverFactory.getWebDriver()

WebElement Table = driver.findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody'))

List<WebElement> Rows = Table.findElements(By.tagName('tr'))

List<WebElement> Cols = Rows.get(0).findElements(By.tagName('td'))

// Mendapatkan reference trx dari recon paling atas

reference_trx = Cols.get(0).getText()

// Mendapatkan tipe dari recon yang paling atas

note = Cols.get(3).getText()

// Mendapatkan VA id dari recon paling atas

va = Cols.get(1).getText()

String virtualAccount = va.split(/[()]/)[1];

println(virtualAccount)

// Menuju ke menu Adjusment untuk melakukan adjusment manual

WebUI.click(findTestObject('Adjustment/Menu Virtual Account'))

WebUI.click(findTestObject('Adjustment/Submenu Adjustment'))

WebUI.click(findTestObject('Adjustment/Add_Adjustment'))

// Masuk ke form add adjusment manual

WebUI.selectOptionByValue(findTestObject('Object Repository/Adjustment/Choose Account'), virtualAccount, true)

WebUI.setText(findTestObject('Object Repository/Adjustment/Amount'), GlobalVariable.amount)

// Apabila tipe nya kredit maka akan dilakukan refund, sedangkan apabila tipe nya debit maka akan dilakukan deduct

WebUI.selectOptionByValue(findTestObject('Object Repository/Adjustment/Choose Type'), 'Refund success', true)

WebUI.setText(findTestObject('Object Repository/Adjustment/Reference_id'), reference_trx)

WebUI.click(findTestObject('Page_CashIn/klik_Submit'))

WebUI.click(findTestObject('Object Repository/Sign Out/Profile'))

WebUI.click(findTestObject('Object Repository/Sign Out/Sign out'))