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

WebUI.callTestCase(findTestCase('Mobile/TC-OpenAplicationTODO'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Mobile/Create TASK TODO/android.widget.Button - Oke_Configuration'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Create TASK TODO/android.widget.TextView - Skip'), 0)

Mobile.tap(findTestObject('Mobile/Create TASK TODO/android.widget.ImageButton'), 0)

Mobile.setText(findTestObject('Object Repository/Mobile/Create TASK TODO/android.widget.EditText - Enter your task'), 'Katalon Mobile Punya Dinsky', 
    0)

Mobile.tap(findTestObject('Object Repository/Mobile/Create TASK TODO/android.widget.EditText - Set Date'), 0)

Mobile.tap(findTestObject('Mobile/Create TASK TODO/android.view.View - Date19'), 0)

Mobile.tap(findTestObject('Mobile/Create TASK TODO/android.widget.Button - OKE_SetDate'), 0)

Mobile.tap(findTestObject('Mobile/Create TASK TODO/android.widget.EditText - Set Time'), 0)

Mobile.tap(findTestObject('Mobile/Create TASK TODO/android.widget.RadialTimePickerViewHours'), 0)

Mobile.tap(findTestObject('Mobile/Create TASK TODO/android.widget.RadialTimePickerViewMinutes'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Create TASK TODO/android.widget.Button - OKE_SetTime'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Create TASK TODO/android.widget.Spinner'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Create TASK TODO/android.widget.CheckedTextView - Personal'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Create TASK TODO/android.widget.ImageView'), 0)

Mobile.setText(findTestObject('Object Repository/Mobile/Create TASK TODO/android.widget.EditText - Enter category'), 'ARAH Coffee Cipete', 
    0)

Mobile.tap(findTestObject('Object Repository/Mobile/Create TASK TODO/android.widget.Button - ADD'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Create TASK TODO/android.widget.TextView'), 0)

WebUI.verifyElementText(findTestObject('Mobile/Verify_TextNegative/android.widget.Toast - Please add title'), '', FailureHandling.OPTIONAL)

