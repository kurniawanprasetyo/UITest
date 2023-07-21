import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

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

String ExpectedVA = ''

String FoundVA = ''

String ExpectedTrx = ''

String Status = 'false'

ExpectedTrx = WebUI.getText(findTestObject('Object Repository/Adjustment/GetRefTrx'))

println(ExpectedTrx)

ExpectedVA = WebUI.getText(findTestObject('Object Repository/Adjustment/GetVA'))

println(ExpectedVA)

while (Status.equals('false')) {

	WebDriver driver = DriverFactory.getWebDriver()

	WebElement Table = driver.findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div/div[2]/div[1]/table/tbody'))

	List<WebElement> Rows = Table.findElements(By.tagName('tr'))

	table: for (int i = 0; i < Rows.size(); i++) {

		List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
        
		println(Rows.get(i).getText())
		
		if (!(Cols.get(1).getText().equals(ExpectedVA))){

			println(Cols.get(1).getText())
			
			FoundVA = Cols.get(1).getText()
			
			println(FoundVA)
		
			Status = 'true'

			break table
		
		}
	}
	
	if (Status.equals('false')) {
		
		WebUI.click(findTestObject('Object Repository/Routing/next Page'))
	}

}

String final_va = FoundVA.split(/[()]/)[1];

WebUI.click(findTestObject('Adjustment/Menu Virtual Account'))

WebUI.click(findTestObject('Adjustment/Submenu Adjustment'))

// Menuju ke form add Adjustment

WebUI.click(findTestObject('Adjustment/Add_Adjustment'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Adjustment/Choose Account'), final_va, true)

WebUI.setText(findTestObject('Object Repository/Adjustment/Amount'), GlobalVariable.amount)

WebUI.selectOptionByValue(findTestObject('Object Repository/Adjustment/Choose Type'), GlobalVariable.type, true)

WebUI.setText(findTestObject('Object Repository/Adjustment/Reference_id'), ExpectedTrx)

WebUI.click(findTestObject('Object Repository/Page_CashIn/klik_Submit'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Adjustment/Alert_Error'),10)