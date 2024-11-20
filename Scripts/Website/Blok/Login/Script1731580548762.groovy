import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Website/Blok/OpenBrowser'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Website/Blok/Registrasion'), [('email') : email, ('password') : password, ('repeatpassword') : repeat_password
        , ('answer') : answer], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/Website/Registrasi/Page_OWASP Juice Shop/input_Login_email'), email)

WebUI.setEncryptedText(findTestObject('Object Repository/Website/Registrasi/Page_OWASP Juice Shop/input_Email_password'), 
    password)

WebUI.click(findTestObject('Website/Registrasi/Page_OWASP Juice Shop/button_exit_to_app  Log in'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Website/Registrasi/Page_OWASP Juice Shop/div_All Products'))

