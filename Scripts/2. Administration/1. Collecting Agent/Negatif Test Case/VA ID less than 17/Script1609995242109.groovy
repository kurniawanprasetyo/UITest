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

WebUI.setText(findTestObject('Create CA/Institution ID'), RandomStringUtils.randomNumeric(6))

WebUI.setText(findTestObject('Create CA/Institution Name'), GlobalVariable.ca_name)

WebUI.setText(findTestObject('Create CA/Phone Number'), GlobalVariable.ca_phone)

WebUI.setText(findTestObject('Create CA/No NPWP'), RandomStringUtils.randomNumeric(15))

WebUI.setText(findTestObject('Create CA/No TDP'), RandomStringUtils.randomNumeric(13))

WebUI.selectOptionByValue(findTestObject('Create CA/Choose Country'), GlobalVariable.ca_country, true)

WebUI.setText(findTestObject('Create CA/Province'), GlobalVariable.ca_province)

WebUI.setText(findTestObject('Create CA/District'), GlobalVariable.ca_district)

WebUI.setText(findTestObject('Create CA/Input Alamat'), GlobalVariable.ca_alamat)

WebUI.click(findTestObject('Create CA/Next Profile'))

WebUI.setText(findTestObject('Create CA/Product Name'), GlobalVariable.ca_product)

WebUI.selectOptionByValue(findTestObject('Create CA/Choose Status'), '1', true)

WebUI.selectOptionByValue(findTestObject('Create CA/Choose Feature'), GlobalVariable.ca_feature_1, true)

WebUI.selectOptionByValue(findTestObject('Create CA/Choose Status Feature'), '1', true)

// Masukkan CA ID kurang dari 17 karakter (random)

WebUI.setText(findTestObject('Create CA/Account ID 1'), RandomStringUtils.randomNumeric(10))

WebUI.setText(findTestObject('Create CA/Input Account Name 1'), GlobalVariable.account_name1)

WebUI.selectOptionByValue(findTestObject('Create CA/Choose Currency'), GlobalVariable.ca_curency_1, true)

WebUI.click(findTestObject('Create CA/Klik Pilih'))

WebUI.click(findTestObject('Create CA/Pilih Indonesia'))

WebUI.click(findTestObject('Create CA/Klik Pilih'))

WebUI.click(findTestObject('Create CA/Next Feature'))

WebUI.verifyElementPresent(findTestObject('Create CA/Error Must be 17 Character'), 10)