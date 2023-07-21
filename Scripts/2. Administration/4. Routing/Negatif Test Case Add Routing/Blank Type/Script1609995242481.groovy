import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Admin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Routing/Menu Routing Destination'))

WebUI.scrollToElement(findTestObject('Routing/Submenu Routing'), 3)

WebUI.click(findTestObject('Routing/Submenu Routing'))

WebUI.click(findTestObject('Routing/Add Routing'))

WebUI.selectOptionByValue(findTestObject('Routing/Select Institution'), GlobalVariable.routing_ca, true)

WebUI.selectOptionByValue(findTestObject('Routing/Select Feature'), GlobalVariable.routing_feature, true)

WebUI.selectOptionByValue(findTestObject('Routing/Input Destination'), GlobalVariable.routing_dest, true)

WebUI.click(findTestObject('Routing/input_Start Date _start_date'))

// Split Start Date

String startEDate = "9-October-2021"

String startDate = startEDate.split("-")[0]

String startMonth = startEDate.split("-")[1]

String startYear = startEDate.split("-")[2]

// Mencari Month dan Year diisikan pada startEDate

String choosestartYearMonth = WebUI.getText(findTestObject('Routing/GetMonthandYear'))

String chooseYear = choosestartYearMonth.split(" ")[1]

String chooseMonth = choosestartYearMonth.split(" ")[0]

while ((!chooseYear.equals(startYear))||(!chooseMonth.equals(startMonth))){
	
	WebUI.click(findTestObject('Object Repository/Routing/button_Next Month'))
	
	choosestartYearMonth = WebUI.getText(findTestObject('Routing/GetMonthandYear'))
	
	chooseMonth = choosestartYearMonth.split(" ")[0]
	
	chooseYear = choosestartYearMonth.split(" ")[1]
}

// Mencari date yang diisikan pada StartEDate

WebDriver driver_startdate = DriverFactory.getWebDriver()

List<WebElement> start_date = driver_startdate.findElements(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--')]"))

for (WebElement e : start_date){

	if(e.getText().equals(startDate)){
		
		e.click()

		break
	}
}

WebUI.click(findTestObject('Object Repository/Routing/input_End Date _end_date'))

// Split End Date

String endEDate = "18-January-2022"

String endDate = endEDate.split("-")[0]
	
String endMonth = endEDate.split("-")[1]

String endYear = endEDate.split("-")[2]

// Mencari Bulan dan Tahun yang diisikan di EndEDate

String chooseEndYearMonth = WebUI.getText(findTestObject('Routing/GetMonthandYear'))

String chooseEndYear = chooseEndYearMonth.split(" ")[1]

String chooseEndMonth = chooseEndYearMonth.split(" ")[0]

while ((!chooseEndYear.equals(endYear))||(!chooseEndMonth.equals(endMonth))){
	
	WebUI.click(findTestObject('Object Repository/Routing/button_Next Month'))
	
	chooseEndYearMonth = WebUI.getText(findTestObject('Routing/GetMonthandYear'))
	
	chooseEndMonth = chooseEndYearMonth.split(" ")[0]
	
	chooseEndYear = chooseEndYearMonth.split(" ")[1]
}

// Mencari Date yang diisikan pada EndEdate

WebDriver driver_enddate = DriverFactory.getWebDriver()

List<WebElement> end_date = driver_enddate.findElements(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--')]"))

for (WebElement e : end_date){

	if(e.getText().equals(endDate)){
		
		e.click()

		break
	}
}

WebUI.selectOptionByValue(findTestObject('Routing/Select Mitra'), GlobalVariable.routing_mitra, true)

WebUI.selectOptionByValue(findTestObject('Routing/select Auto Route'), '0', true)

WebUI.click(findTestObject('Routing/button_Submit'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Routing/Notif Required Field'), 10)