import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

// Login sebagai admin

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Admin'), [:], FailureHandling.STOP_ON_FAILURE)

// Masuk ke menu TT Credit Mapping

WebUI.click(findTestObject('Routing/Menu Routing Destination'))

WebUI.scrollToElement(findTestObject('Object Repository/TT Credit Mapping/submenu TransferTo Credit Mapping'), 3)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/TT Credit Mapping/submenu TransferTo Credit Mapping'))

String existDest = ''

String existPayer = ''

WebDriver driver = DriverFactory.getWebDriver()

WebElement table = driver.findElement(By.xpath("//*[@id='kt_content']/div[2]/div/div/div[2]/div[1]/table/tbody"))

List<WebElement> Rows = table.findElements(By.tagName('tr'))

List<WebElement> Cols = Rows.get(2).findElements(By.tagName('td'))

existDest = Cols.get(0).getText()

existPayer = Cols.get(3).getText()

println(existDest)

println(existPayer)

WebUI.click(findTestObject('Object Repository/TT Credit Mapping/New TransferTo Credit Mapping'))

WebUI.selectOptionByValue(findTestObject('Object Repository/TT Credit Mapping/Choose Country'), existDest, true)

WebUI.setText(findTestObject('Object Repository/TT Credit Mapping/input_Beneficiary Account Number'), 'iban')

WebUI.setText(findTestObject('Object Repository/TT Credit Mapping/input_Beneficiary Additional Code'), 'swift_bic_code')

WebUI.setText(findTestObject('Object Repository/TT Credit Mapping/input_Payer ID'), existPayer)

WebUI.click(findTestObject('Object Repository/TT Credit Mapping/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/TT Credit Mapping/Notif Credit Mapping Already Exist'),10)