import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

// Login sebagai admin

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Admin'), [:], FailureHandling.STOP_ON_FAILURE)

// Masuk ke menu Collection Agent

WebUI.click(findTestObject('Create CA/Collecting Agent'))

WebUI.click(findTestObject('Create CA/Add CA'))

// Masukkan CA ID kurang dari 6 karakter

WebUI.setText(findTestObject('Create CA/Institution ID'), RandomStringUtils.randomNumeric(5))

WebUI.setText(findTestObject('Create CA/Institution Name'), GlobalVariable.ca_name)

WebUI.setText(findTestObject('Create CA/Phone Number'), GlobalVariable.ca_phone)

WebUI.setText(findTestObject('Create CA/No NPWP'), RandomStringUtils.randomNumeric(15))

WebUI.setText(findTestObject('Create CA/No TDP'), RandomStringUtils.randomNumeric(13))

WebUI.selectOptionByValue(findTestObject('Create CA/Choose Country'), GlobalVariable.ca_country, true)

WebUI.setText(findTestObject('Create CA/Province'), GlobalVariable.ca_province)

WebUI.setText(findTestObject('Create CA/District'), GlobalVariable.ca_district)

WebUI.setText(findTestObject('Create CA/Input Alamat'), GlobalVariable.ca_alamat)

WebUI.click(findTestObject('Create CA/Next Profile'))

WebUI.verifyElementPresent(findTestObject('Create CA/Error Must be 6 character'), 10)