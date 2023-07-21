import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Maker'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Fee/Add Fee/Klik Fee'))

WebUI.delay(3)

WebUI.scrollToElement(findTestObject('Object Repository/Fee/Add Fee/Klik Submenu Fee'), 3)

WebUI.click(findTestObject('Object Repository/Fee/Add Fee/Klik Submenu Fee'))

// Mencari Start Period berdasarkan Institution

String expectedInstitution = GlobalVariable.va_id_operational_search

String startPeriod = ' '

String expDest = ''

WebUI.delay(5)

WebDriver driver = DriverFactory.getWebDriver()

WebElement Table = driver.findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody'))

List<WebElement> Rows = Table.findElements(By.tagName('tr'))

table: for (int i = 0; i < Rows.size(); i++) {
	
    List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))

    for (int j = 0; j < Cols.size(); j++) {
        println(Cols.get(j).getText())

        WebUI.delay(1)

        // Menyimpan data start period dan destination country
		
        if (Cols.get(j).getText().equalsIgnoreCase(expectedInstitution)) {
			
            startPeriod = Cols.get(2).getText()

            expDest = Cols.get(4).getText()

            break table
        }
    }
}

String ePeriod = startPeriod.split('-')[2]

String eMonth = startPeriod.split('-')[1]

String eYear = startPeriod.split('-')[0]

// Menghapus 00:00:00 yang berada di belakang start period
String eDate = ePeriod.replace(' 00:00:00', '')

// Mengubah tanggal menjadi int (dari string)
int value = Integer.parseInt(eDate)

// Mengurangi tanggal menjadi 2 hari sebelum
int newDate = value - 2

// Mengubah tanggal menjadi String (sebelumnya int)
String finalPeriod = String.valueOf(newDate)

// Mengubah bulan dari angka menjadi huruf
String finalMonth = ''

switch (eMonth) {
    case '1':
        finalMonth = 'January'

        break
    case '2':
        finalMonth = 'February'

        break
    case '3':
        finalMonth = 'March'

        break
    case '4':
        finalMonth = 'April'

        break
    case '5':
        finalMonth = 'May'

        break
    case '6':
        finalMonth = 'June'

        break
    case '7':
        finalMonth = 'July'

        break
    case '8':
        finalMonth = 'August'

        break
    case '9':
        finalMonth = 'September'

        break
    case '10':
        finalMonth = 'October'

        break
    case '11':
        finalMonth = 'November'

        break
    case '12':
        finalMonth = 'December'

        break
    default:
        break
}

println(finalMonth)

// Masuk ke form add fee

WebUI.click(findTestObject('Fee/Add Fee/Add Fee'))

WebUI.selectOptionByValue(findTestObject('Fee/Add Fee/Select CA'), GlobalVariable.va_id_operational_fee, true)

WebUI.click(findTestObject('Fee/Add Fee/Klik start periode'))

String choosestartYearMonth = WebUI.getText(findTestObject('Routing/GetMonthandYear'))

String chooseYear = choosestartYearMonth.split(' ')[1]

println(chooseYear)

String chooseMonth = choosestartYearMonth.split(' ')[0]

println(chooseMonth)

while (!(chooseYear.equals(eYear)) || !(chooseMonth.equals(finalMonth))) {
	
    WebUI.click(findTestObject('Object Repository/Routing/button_Next Month'))

    choosestartYearMonth = WebUI.getText(findTestObject('Routing/GetMonthandYear'))

    chooseMonth = (choosestartYearMonth.split(' ')[0])

    chooseYear = (choosestartYearMonth.split(' ')[1])
}

WebDriver driverDate = DriverFactory.getWebDriver()

List<WebElement> date = driverDate.findElements(By.xpath('//div[contains(@class,\'react-datepicker__day react-datepicker__day--\')]'))

for (WebElement e : date) {
	
    println(e.getText())

    if (e.getText().equals(finalPeriod)) {
		
        e.click()

        break
    }
}

WebUI.selectOptionByLabel(findTestObject('Fee/Add Fee/Select Destination'), expDest, true)

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Fee/Add Fee/Add Fee Profile'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Fee/Add Fee/Choose Tier'), '1', true)

WebUI.setText(findTestObject('Object Repository/Fee/Add Fee/Max Fee'), '400')

WebUI.setText(findTestObject('Object Repository/Fee/Add Fee/Fee USD'), '7')

WebUI.click(findTestObject('Fee/Add Fee/Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/User Management/Notif Start Period less than previous Start Period'), 10)