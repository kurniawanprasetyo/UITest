import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Login/Login As Maker'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Mutation/span_Virtual Account'))

WebUI.click(findTestObject('Mutation/span_Mutation'))

WebDriver data = DriverFactory.getWebDriver()

WebElement tabel = data.findElement(By.xpath('//*[@id="kt_content"]/div[2]/div/div[1]/div[2]/div[1]/div[1]/table/tbody'))

List<WebElement> Row = tabel.findElements(By.tagName('tr'))

System.out.println(Row.size())

loop: for (int k = 0; k < Row.size(); k++) {
	
	println(Row.get(k).getText())

	List<WebElement> Col = Row.get(k).findElements(By.tagName('td'))

	for (int l = 0; l < Col.size(); l++) {
		
		println(Col.get(l).getText())

		// Apabila menemukan NOT ALREADY ADJUSTED maka akan melakukan klik pada tombol edit
		if (Col.get(l).getText().equalsIgnoreCase(reference_trx)) {

			println('Text present in row number 3 is : ' + Col.get(l).getText())
			
			break loop
		}
	}
}