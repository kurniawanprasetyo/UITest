import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import groovy.time.TimeCategory as TimeCategory
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Maker'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Fee/Add Fee/Klik Fee'))

WebUI.click(findTestObject('Object Repository/Fee/Add Fee/Klik Submenu Fee'))

WebUI.click(findTestObject('Fee/Add Fee/Add Fee'))

WebUI.selectOptionByValue(findTestObject('Fee/Add Fee/Select CA'), ca_id, true)

WebUI.click(findTestObject('Fee/Add Fee/Klik start periode'))

String ExpectedDate = date

String eDate = ExpectedDate.split('-')[0]

String eMonth = ExpectedDate.split('-')[1]

String eYear = ExpectedDate.split('-')[2]

String choosestartYearMonth = WebUI.getText(findTestObject('Routing/GetMonthandYear'))

String chooseYear = choosestartYearMonth.split(' ')[1]

String chooseMonth = choosestartYearMonth.split(' ')[0]

while (!(chooseYear.equals(eYear)) || !(chooseMonth.equals(eMonth))) {
    WebUI.click(findTestObject('Object Repository/Routing/button_Next Month'))

    choosestartYearMonth = WebUI.getText(findTestObject('Routing/GetMonthandYear'))

    chooseMonth = (choosestartYearMonth.split(' ')[0])

    chooseYear = (choosestartYearMonth.split(' ')[1])
}

WebDriver driverDate = DriverFactory.getWebDriver()

List<WebElement> date = driverDate.findElements(By.xpath('//div[contains(@class,\'react-datepicker__day react-datepicker__day--\')]'))

for (WebElement e : date) {
    if (e.getText().equals(eDate)) {
        e.click()

        break
    }
}

WebUI.selectOptionByValue(findTestObject('Fee/Add Fee/Select Destination'), dest, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Fee/Add Fee/Choose Tier'), tier, true)

WebUI.setText(findTestObject('Object Repository/Fee/Add Fee/Max Fee'), fee_max)

WebUI.setText(findTestObject('Object Repository/Fee/Add Fee/Fee USD'), fee_usd)

WebUI.click(findTestObject('Fee/Add Fee/Save'))

WebUI.verifyElementPresent(findTestObject('Fee/Add Fee/Notif Success'), 10)

WebUI.click(findTestObject('Object Repository/Sign Out/Profile'))

WebUI.click(findTestObject('Object Repository/Sign Out/Sign out'))

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Fee/Checked by Checker'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Fee/Denied by Approval'), [:], FailureHandling.STOP_ON_FAILURE)