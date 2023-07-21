import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Virtual Account/Add Cashout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Virtual Account/Checked by Checker'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Element (Jangan Dihapus)/Virtual Account/Approve by Approval'), [:], FailureHandling.STOP_ON_FAILURE)