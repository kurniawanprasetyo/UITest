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

// Masuk ke menu recon VA untuk mencari reference trx dengan status Already Adjusted

WebUI.click(findTestObject('Adjustment Reconsile/Menu Reconcile'))

WebUI.click(findTestObject('Adjustment Reconsile/Submenu Report'))

WebUI.click(findTestObject('Adjustment Reconsile/Submenu Recon VA'))

WebUI.selectOptionByValue(findTestObject('Adjustment Reconsile/select_3510 (1)'), '10', true)

String ExpectedValue = 'ALREADY ADJUSTED'

String CurrentlyValue = ''

String note = ''

String reference_trx = ''

int k = 1;

while (!(ExpectedValue.equals(CurrentlyValue))) {

// Mencari va id dengan status already adjusted

	WebDriver driver = DriverFactory.getWebDriver()

	WebElement Table = driver.findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody'))

	List<WebElement> Rows = Table.findElements(By.tagName('tr'))

	System.out.println(Rows.size())

	table: for (int i = 0; i < Rows.size(); i++) {
    
		println(Rows.get(i).getText())

		List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
		
		// Apabila menemukan ALREADY ADJUSTED maka akan melakukan klik pada tombol edit
        
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
	
// Masuk ke menu form add adjusment reconcile

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

WebUI.verifyElementPresent(findTestObject('Adjustment Reconsile/Error 400'), 10)

println('Reference Trx yang dilakukan adjustment = ' + reference_trx)