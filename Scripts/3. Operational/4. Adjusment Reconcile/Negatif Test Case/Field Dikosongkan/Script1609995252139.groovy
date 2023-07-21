import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Maker'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Adjustment Reconsile/Menu Reconcile'))

WebUI.click(findTestObject('Adjustment Reconsile/Submenu Report'))

WebUI.click(findTestObject('Adjustment Reconsile/Submenu Recon VA'))

WebUI.selectOptionByValue(findTestObject('Adjustment Reconsile/select_3510 (1)'), '10', true)

String ExpectedValue = 'NOT ALREADY ADJUSTED'

String CurrentlyValue = ''

String note = ''

String reference_trx = ''

int k = 1;

while (!(ExpectedValue.equals(CurrentlyValue))) {

	WebDriver driver = DriverFactory.getWebDriver()

	WebElement Table = driver.findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody'))

	List<WebElement> Rows = Table.findElements(By.tagName('tr'))

	System.out.println(Rows.size())

	table: for (int i = 0; i < Rows.size(); i++) {
    
		println(Rows.get(i).getText())

		List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))

		// Apabila menemukan NOT ALREADY ADJUSTED maka akan melakukan klik pada tombol edit
		
		if (Cols.get(2).getText().equalsIgnoreCase(ExpectedValue)) {
            
			CurrentlyValue = ExpectedValue
			
			Cols.get(4).findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody/tr['+k+']/td[5]/button')).click()

			reference_trx = Cols.get(0).getText()

			note = Cols.get(3).getText()

			break table
		}
	}

	k++
	
	if (!(ExpectedValue.equals(CurrentlyValue))) {
		
		WebUI.click(findTestObject('Object Repository/Routing/next Page'))
	}
	
}

WebUI.click(findTestObject('Adjustment Reconsile/button_Submit'))

//WebUI.click(findTestObject('Adjustment Reconsile/Notif Success'))

println('Reference Trx yang dilakukan adjustment = ' + reference_trx)

WebUI.verifyElementPresent(findTestObject('Adjustment Reconsile/Error This field is required (Amount)'), 10)

WebUI.verifyElementPresent(findTestObject('Object Repository/Adjustment Reconsile/Error This field is required (type)'), 10)