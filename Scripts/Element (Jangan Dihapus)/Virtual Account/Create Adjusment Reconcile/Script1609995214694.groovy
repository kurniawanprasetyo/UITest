import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Maker'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Adjustment Reconsile/Menu Reconcile'))

WebUI.click(findTestObject('Adjustment Reconsile/Submenu Report'))

WebUI.click(findTestObject('Adjustment Reconsile/Submenu Recon VA'))

WebUI.selectOptionByValue(findTestObject('Adjustment Reconsile/select_3510 (1)'), '10', true)

String ExpectedValue = 'NOT ALREADY ADJUSTED'

String eValue = ''

String note = ''

String reference_trx = ''

while (!ExpectedValue.equals(eValue)){

	WebDriver driver = DriverFactory.getWebDriver()

	WebElement Table = driver.findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody'))

	List<WebElement> Rows = Table.findElements(By.tagName('tr'))

	table: for (int i = 0; i < Rows.size(); i++) {

		List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
		
		// Apabila menemukan NOT ALREADY ADJUSTED maka akan melakukan klik pada tombol edit
		
		if (Cols.get(2).getText().equalsIgnoreCase(ExpectedValue)) {
			
			Cols.get(4).click()

			note = Cols.get(3).getText()
		
			reference_trx = Cols.get(0).getText()

			break table
		}
	}
	
	if (!ExpectedValue.equals(eValue)){
		
			WebUI.click(findTestObject('Object Repository/Routing/next Page'))
	}

}

WebUI.setText(findTestObject('Adjustment Reconsile/Amount'), GlobalVariable.amount)

// Jika bertipe KREDIT maka akan melakukan refund dan apabila bertipe DEBIT akan melakukan Deduct

switch (note) {
	case 'R1-FAIL :: Debit found, Kredit not found, need reversal!':
		WebUI.selectOptionByValue(findTestObject('Adjustment Reconsile/Select Type'), 'Deduct transfer', true)
		break
		
	case 'R1-FAIL :: Debit not found, Kredit found, need adjusment debit!':
		WebUI.selectOptionByValue(findTestObject('Adjustment Reconsile/Select Type'), 'Refund success', true)
		break
		
	case 'R1-SUCCESS : Debit found, Kredit found, debit again!':
		WebUI.selectOptionByValue(findTestObject('Adjustment Reconsile/Select Type'), 'Refund success', true)
		break
		
	case 'R1-SUCCESS : Debit not found, Kredit found, debit double (return kredit & debit amount trx+fee)!':
		WebUI.selectOptionByValue(findTestObject('Adjustment Reconsile/Select Type'), 'Refund success', true)
		break
		
	default:
        break
}

WebUI.click(findTestObject('Adjustment Reconsile/button_Submit'))

WebUI.click(findTestObject('Object Repository/Sign Out/Profile'))

WebUI.click(findTestObject('Object Repository/Sign Out/Sign out'))
