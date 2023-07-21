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

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Maker'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Fee/Add Fee/Klik Fee'))

WebUI.click(findTestObject('Object Repository/Fee/Add Fee/Klik Submenu Fee'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Destination/select Show per Page'), '10', true)

String expectedInstitution = 'Integration Bank(241120)'

String currentlyInstitution = ''

int j = 1

while (!(expectedInstitution.equals(currentlyInstitution))) {
	
    WebDriver driver = DriverFactory.getWebDriver()

    WebElement Table = driver.findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody'))

    List<WebElement> Rows = Table.findElements(By.tagName('tr'))

    table: for (int i = 0; i < Rows.size(); i++) {
		
        println(Rows.get(i).getText())

        List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))

        println(Cols.get(1).getText())

        if (Cols.get(1).getText().equalsIgnoreCase(expectedInstitution) && Cols.get(3).getText().equals('-')) {
			
            Cols.get(5).findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody/tr['+j+']/td[6]/button[2]')).click()

            currentlyInstitution = expectedInstitution

            println(currentlyInstitution)

            table: break
        }
        
        j++
    }
    
    if (!(expectedInstitution.equals(currentlyInstitution))) {
		
        WebUI.click(findTestObject('Object Repository/Routing/next Page'))
    }
    
    j = 1

    println(j)
}

WebUI.click(findTestObject('Fee/Add Fee/Klik start periode'))

String ExpectedDate = GlobalVariable.fee_date_update

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

WebUI.selectOptionByLabel(findTestObject('Object Repository/Fee/Add Fee/Choose Tier'), 'Choose Tier', true)

WebUI.sendKeys(findTestObject('Object Repository/Fee/Update Fee/Input Max Dest'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Fee/Update Fee/Input Max Dest'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/Fee/Update Fee/Input Max Dest'), GlobalVariable.fee_maxdest_updated)

WebUI.sendKeys(findTestObject('Object Repository/Fee/Update Fee/Input fee'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Fee/Update Fee/Input fee'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/Fee/Update Fee/Input fee'), GlobalVariable.fee_fee_updated)

WebUI.click(findTestObject('Object Repository/Fee/Update Fee/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Fee/Update Fee/Notif Required Field'), 10)