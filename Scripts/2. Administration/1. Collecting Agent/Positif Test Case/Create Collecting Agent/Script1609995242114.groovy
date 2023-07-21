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

WebUI.setText(findTestObject('Create CA/Institution ID'), GlobalVariable.ca_id)

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

WebUI.setText(findTestObject('Create CA/Account ID 1'), GlobalVariable.va_id1)

WebUI.setText(findTestObject('Create CA/Input Account Name 1'), GlobalVariable.account_name1)

WebUI.selectOptionByValue(findTestObject('Create CA/Choose Currency'), GlobalVariable.ca_curency_1, true)

WebUI.click(findTestObject('Create CA/Klik Pilih'))

WebUI.click(findTestObject('Object Repository/Create CA/Choose Chinese'))

WebUI.click(findTestObject('Object Repository/Create CA/Choose Philippine'))

WebUI.click(findTestObject('Object Repository/Create CA/Choose Indonesia'))

WebUI.click(findTestObject('Create CA/Klik Pilih'))

WebUI.click(findTestObject('Create CA/Create Feature'))

WebUI.selectOptionByValue(findTestObject('Create CA/Choose Feature 2'), GlobalVariable.ca_feature_2, true)

WebUI.selectOptionByValue(findTestObject('Create CA/Choose Status Feature 2'), '1', true)

WebUI.setText(findTestObject('Create CA/Account ID 2'), GlobalVariable.va_id2)

WebUI.setText(findTestObject('Create CA/Input Account Name 2'), GlobalVariable.account_name2)

WebUI.selectOptionByValue(findTestObject('Create CA/Choose Currency 2'), GlobalVariable.ca_currency_2, true)

WebUI.click(findTestObject('Create CA/Klik Pilih 2'))

WebUI.click(findTestObject('Object Repository/Create CA/Choose Chinese'))

WebUI.click(findTestObject('Object Repository/Create CA/Choose Philippine'))

WebUI.click(findTestObject('Object Repository/Create CA/Choose Indonesia'))

WebUI.click(findTestObject('Create CA/Klik Pilih 2'))

WebUI.click(findTestObject('Create CA/Next Feature'))

WebUI.setText(findTestObject('Create CA/Username PIC'), GlobalVariable.ca_username)

WebUI.setText(findTestObject('Create CA/Password PIC'), GlobalVariable.ca_pass)

WebUI.setText(findTestObject('Create CA/PIC Name'), GlobalVariable.ca_pic_name)

WebUI.setText(findTestObject('Create CA/PIC Role'), GlobalVariable.ca_pic_role)

WebUI.setText(findTestObject('Create CA/PIC Phone Number'), GlobalVariable.ca_pic_phone)

WebUI.setText(findTestObject('Create CA/PIC Email'), GlobalVariable.ca_pic_email)

WebUI.click(findTestObject('Create CA/button_Save'))

WebUI.click(findTestObject('Create CA/button_Close'))

WebUI.click(findTestObject('Create CA/Successfull create institutions'))

WebUI.verifyElementPresent(findTestObject('Create CA/Notif Success Create CA'), 10)