# Katalon-taskfinal-Dina

# Katalon-taskAPI
Katalon API Integration (JSON)
This project provides an integration with the Katalon API for automating and managing test executions, retrieving test results, and manipulating test cases in Katalon Studio. The Katalon API uses JSON for data exchange, making it easy to interact with programmatically from external systems.

# Table of Contents
* Overview
* Katalon API Authentication
* API Endpoints
  * Post CreateToken
  * Get BookingIds
  * PUT UpdateBooking
  * PATCH PartialUpdateBooking
  * DEL DeleteBooking
* Error Handling

# Overview
Katalon Studio provides a powerful automation solution for web, API, mobile, and desktop testing. The Katalon API allows external tools to trigger tests, manage test cases, and retrieve results. This integration uses JSON to send and receive data, making it simple to automate testing workflows and integrate Katalon into CI/CD pipelines.

# Katalon API Authentication
The Katalon API requires an API Key for authentication. You can obtain the API key from your Katalon Dashboard and use it in your requests to authenticate against the API.

# API Endpoints

  * POST CreateToken
    
Endpoint: POST (https://restful-booker.herokuapp.com/auth)
Description: Trigger the execution of a test suite in Katalon.
Request Body:
```
{
    "username" : "admin",
    "password" : "password123"
}
```

Response:
```
HTTP/1.1 200 OK

{
    "token": "abc123"
}
```

 * Get BookingIds
   
Endpoint: GET [/v1/test-executions/{executionId}/results]
Description: Retrieve the results of a test execution.
Response:
```
{
    "firstname": "Dina",
    "lastname": "Chan",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    },
    "additionalneeds": "Breakfast"
}
```

  * PUT UpdateBooking
    
Update Test Case
Endpoint: PUT (https://restful-booker.herokuapp.com/booking/:id)
Description: Update an existing test case.
Request Body:
```
{
    "firstname" : "James",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
```
Response:
```
HTTP/1.1 200 OK

{
    "firstname" : "James",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
```


  * PATCH PartialUpdateBooking
Update Test Case
Endpoint: PATCH (https://restful-booker.herokuapp.com/booking/:id)
Description: Update an existing test case without all data.
Request Body:
```
{
    "firstname" : "James",
    "lastname" : "Brown"
}
```

```
{
    "firstname" : "James",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
```
  * DEL DeleteBooking
    
Delete Test Case
Endpoint: DELETE https://restful-booker.herokuapp.com/booking/1
Description: Delete a specific test case.
Request Body:
```
curl -X DELETE \
  https://restful-booker.herokuapp.com/booking/1 \
  -H 'Content-Type: application/json' \
  -H 'Cookie: token=abc123'
```
Response:
```
HTTP/1.1 201 Created
```


# Error Handling
The Katalon API returns HTTP status codes along with error messages for failed requests.

200 OK: Successful request.
201 Created: Resource successfully created.
400 Bad Request: Invalid request format or missing required parameters.
401 Unauthorized: Invalid API Key or missing authentication.
404 Not Found: Resource not found (e.g., test case or test suite ID).
500 Internal Server Error: Unexpected error on the server.
  

# Katalon-taskMobile-Katalon
To configure **Katalon Studio** for mobile testing with **Appium**, you need to ensure that both **Appium** and **Katalon Studio** are set up properly for mobile test automation. Katalon Studio uses Appium as its default driver for mobile testing, so this process primarily involves setting up Appium and configuring Katalon Studio to use it.

Here’s how you can configure Katalon Studio to work with Appium for mobile testing:

### 1. **Install Katalon Studio**
   - Download and install **Katalon Studio** from the official website: [Katalon Downloads](https://www.katalon.com/download/).
   - Install and launch Katalon Studio.

### 2. **Install Appium**

   Appium is a powerful mobile automation framework that Katalon Studio uses by default for mobile testing. You need to install Appium to run mobile tests effectively.

   **Steps to Install Appium:**
   1. **Install Node.js**: 
      - Appium requires **Node.js**. Download and install it from [Node.js official website](https://nodejs.org/).
   
   2. **Install Appium**:
      - Open a terminal (or command prompt) and install Appium globally via npm:
        ```bash
        npm install -g appium
        ```

        ```bash
        appium driver install uiautomator2
        ```
   
   3. **Install Appium Doctor** (Optional but recommended):
      - Appium Doctor helps verify your setup:
        ```bash
        npm install -g appium-doctor
        ```
      - Run **Appium Doctor** to check if everything is set up correctly:
        ```bash
        appium-doctor
        ```
   
   4. **Start the Appium Server**:
      - Run the Appium server using this command in your terminal:
        ```bash
        appium
        ```
      - This will start the Appium server, and it should display a message like “Appium REST HTTP interface listener started” when it is ready to accept connections.

### 3. **Set Up Mobile Testing in Katalon Studio**

   After installing Appium, you need to configure Katalon Studio to interact with the Appium server for mobile testing.

   **Steps to configure Katalon Studio:**

   1. **Open Katalon Studio** and create a new project (if you don't have one already).
   
   2. **Enable Mobile Testing:**
      - In Katalon Studio, go to **File > New > Project**.
      - Choose **Mobile Testing** and create a new project.

   3. **Set Up Mobile Settings:**
      - Go to **Project > Settings > Execution > Mobile**.
      - In the **Mobile Settings** section, make sure **Appium** is selected as the default driver.

### 4. **Configure Desired Capabilities**

   The most important part of using Appium in Katalon Studio is setting the **Desired Capabilities** for the mobile device and app you’re testing. These capabilities define the test environment, such as the mobile platform (Android or iOS), the app to test, and device settings.

   To configure desired capabilities in Katalon Studio:
   
   1. **Add a Desired Capability:**
      - In **Project Settings**, navigate to **Execution > Mobile**.
      - Under **Mobile** settings, select **Appium** as the driver and configure the desired capabilities for Android or iOS.
   
   2. **Desired Capabilities for Android Example:**
      - You’ll need to provide details such as the **device name**, **platform version**, and **app package** and **app activity**.
      - Example configuration:
        ```json
        {
          "platformName": "Android",
          "platformVersion": "10",
          "deviceName": "emulator-5554",
          "appPackage": "com.example.myapp",
          "appActivity": "com.example.myapp.MainActivity"
        }
        ```

   3. **Desired Capabilities for iOS Example:**
      - You need to specify similar capabilities for iOS (e.g., device name, platform version, app path, etc.).
      - Example configuration:
        ```json
        {
          "platformName": "iOS",
          "platformVersion": "14.5",
          "deviceName": "iPhone Simulator",
          "automationName": "XCUITest",
          "app": "/path/to/your/app.app"
        }
        ```

   **Set Desired Capabilities for your mobile project:**
   - Go to **Execution > Mobile** and input your desired capabilities in the respective fields for Android or iOS.

### 5. **Configure Appium Server URL**

   Katalon Studio needs to communicate with the Appium server. To do this:
   
   1. **Go to Project Settings > Execution > Mobile > Appium Settings**.
   2. **Set Appium Server URL**:
      - By default, the Appium server URL is `http://127.0.0.1:4723/wd/hub`.
      - If your Appium server is running on a different machine or port, update the URL accordingly.
   
### 6. **Write and Run Mobile Test Scripts**

   After configuring the desired capabilities and setting up the Appium server, you can start writing mobile test scripts in Katalon Studio.

   **To create a mobile test case:**
   1. Go to **Test Cases** > **Add New Test Case**.
   2. Select **Mobile** as the test type.
   3. Use Katalon’s mobile testing commands such as:
      - `Mobile.startApplication()`: Start the app.
      - `Mobile.tap()`: Tap on an element.
      - `Mobile.setText()`: Set text in a field.
      - `Mobile.closeApplication()`: Close the app.

   **Example Mobile Test Script for Android:**
   ```groovy
   Mobile.startApplication('path/to/your/app.apk', true)
   Mobile.tap(findTestObject('YourAppObject'), 10)
   Mobile.setText(findTestObject('YourTextField'), 'Hello World', 10)
   Mobile.closeApplication()
   ```

### 7. **Run Tests on the Device**

   - **For Android**: Make sure you have an Android device or emulator connected. You can check the connection with the `adb devices` command.
   - **For iOS**: Ensure you have an iOS device or simulator connected. You can check the connection with `ideviceinfo` (for real devices).
   
   To run the test, select the device and click **Run** in Katalon Studio.

### 8. **Using Appium Features with Katalon**

   You can further extend your tests by using **Appium-specific features** through **Katalon**'s **Custom Keywords**.

   For example:
   - You can write custom Appium commands using Appium’s **WebDriver** API and add those to your tests.
   - This allows for more advanced mobile test configurations beyond what Katalon offers by default.

### Conclusion

By following these steps, you’ll have successfully configured Katalon Studio for mobile testing using Appium. Katalon’s built-in support for Appium allows you to perform comprehensive mobile test automation for both Android and iOS devices. Be sure to adjust the desired capabilities based on the specifics of your app and testing environment, and explore Katalon’s documentation for more advanced features.



# Katalon-taskWebsite-Katalon

To configure **Katalon Studio** for **website testing**, you need to set up the environment and ensure that Katalon can interact with web browsers and test your web applications. Katalon Studio supports both **automated web testing** using Selenium and **manual testing** for web applications. Below are the steps to configure Katalon Studio for website testing:

### Step-by-Step Guide to Configure Katalon Studio for Website Testing:

---

### 1. **Install Katalon Studio**
   - **Download and Install Katalon Studio**:
     - Download **Katalon Studio** from [Katalon’s official website]
     - Follow the installation steps based on your OS (Windows/macOS/Linux).

   - **Launch Katalon Studio**:
     - After installation, open Katalon Studio.

---

### 2. **Set Up Katalon Project for Web Testing**
   - **Create a New Project**:
     - In Katalon Studio, go to **File > New > Project**.
     - Select **Web Testing** as the project type.
     - Enter the project name and location and click **OK**.
---

### 3. **Set Up Web Browsers for Testing**
   Katalon Studio supports popular web browsers like **Google Chrome**, **Mozilla Firefox**, **Microsoft Edge**, and **Safari** (on macOS). You need to configure the required browsers and their drivers to run tests.

---

### 4. **Create Test Cases for Web Testing**

   **Add Test Cases**:
   - In Katalon Studio, navigate to **Test Cases** > **Add New Test Case**.
   - Select **Web Testing** as the test type.

   **Record a Web Test**:
   - Katalon Studio provides a **Web Recorder** tool that allows you to record actions on your website and automatically generate test steps.
   - Click on **Record Web** in the **Test Case** window.
   - This will open a browser window where you can interact with your website. Katalon will automatically generate test steps based on the actions you perform (e.g., clicking buttons, entering text, etc.).

   **Manual Script Creation**:
   - You can also manually write your web test scripts by using Katalon’s built-in **WebUI** keywords such as:
     - `WebUI.openBrowser()`: Opens the browser.
     - `WebUI.navigateToUrl()`: Navigates to a URL.
     - `WebUI.click()`: Clicks on a web element.
     - `WebUI.setText()`: Sets text in an input field.
     - `WebUI.verifyTextPresent()`: Verifies that a certain text is present on the page.

   **Example Test Script**:
   ```groovy
   WebUI.openBrowser('https://example.com')
   WebUI.setText(findTestObject('Page_Login/username'), 'testuser')
   WebUI.setText(findTestObject('Page_Login/password'), 'password123')
   WebUI.click(findTestObject('Page_Login/loginButton'))
   WebUI.verifyTextPresent('Welcome, testuser', false)
   WebUI.closeBrowser()
   ```

---

### 5. **Configure Execution Settings**
   **Select Browser for Test Execution**:
   - Go to **Project > Settings > Execution > Web**.
   - Under **Execution Settings**, you can select which browser you want to run the test on (e.g., Chrome, Firefox, Edge).
   - You can also configure **headless mode** for running tests without the graphical user interface, useful for CI/CD pipelines.

   **Set Browser Options**:
   - You can also configure browser options for debugging or headless testing. For example, for **Chrome**, you might set options like:
     - `--headless`: Run tests without opening the browser window.
     - `--incognito`: Open the browser in incognito mode.
     - `--start-maximized`: Open the browser maximized.
   
---

### 6. **Run the Test**
   - To run the test, click on the **Run** button at the top of Katalon Studio.
   - Choose the browser you want to run the test on (e.g., Chrome, Firefox, Edge).
   - Katalon will open the browser, perform the actions defined in the test script, and then generate a **test report**.

---

### 7. **View Test Reports**
   - After running the tests, you can view detailed **test execution reports** generated by Katalon Studio.
   - Navigate to **Reports** in Katalon Studio to view test execution results, logs, screenshots, and more.

---
### Conclusion
Katalon Studio provides a comprehensive environment for **website testing**, supporting a variety of browsers and test cases for web applications. By following the above steps, you’ll be able to easily configure your Katalon project, write test scripts, and execute them across different browsers.
