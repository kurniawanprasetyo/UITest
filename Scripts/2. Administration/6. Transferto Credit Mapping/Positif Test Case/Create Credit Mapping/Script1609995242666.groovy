import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

// Login sebagai admin

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Admin'), [:], FailureHandling.STOP_ON_FAILURE)

// Masuk ke menu TT Credit Mapping

WebUI.click(findTestObject('Routing/Menu Routing Destination'))

WebUI.scrollToElement(findTestObject('Object Repository/TT Credit Mapping/submenu TransferTo Credit Mapping'), 3)

WebUI.click(findTestObject('Object Repository/TT Credit Mapping/submenu TransferTo Credit Mapping'))

WebUI.click(findTestObject('Object Repository/TT Credit Mapping/New TransferTo Credit Mapping'))

WebUI.selectOptionByValue(findTestObject('Object Repository/TT Credit Mapping/Choose Country'), GlobalVariable.credit_mapping_dest, true)

WebUI.setText(findTestObject('Object Repository/TT Credit Mapping/input_Beneficiary Account Number'), GlobalVariable.beneficiary_account_number)

//WebUI.setText(findTestObject('Object Repository/TT Credit Mapping/input_Beneficiary Additional Code'), GlobalVariable.beneficiary_additional_code)

WebUI.setText(findTestObject('Object Repository/TT Credit Mapping/input_Payer ID'), GlobalVariable.payer_id)

WebUI.click(findTestObject('Object Repository/TT Credit Mapping/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/TT Credit Mapping/Notif success credit mapping'), 10)