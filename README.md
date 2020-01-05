# TechnicalTest
Amazon app


Prerequisites :
 - Appium should installed
 - Android sdk should installed
 - Android home path should set
 - Any Ide to open the project, I would prefer Intellij community edition
 - Android device with Version 8 or above
 
 
 #Start project
 - Clone the repo from the given url
 - Open the project in Intellij and let the dependencies auto install
             (OR)
 - Dependencies will be installed which running the script 
 
 #Setup
 - Please connect a andriod device to the system and make sure the developer options are turned on
    
    (OR)
 - Start a device from GenyMotion with android with version 8 or above
 - Open terminal and type below command and check whether the device is connected
  ```shell
  adb devices
  ```
  It should show you deviceId in the terminal
  - Install Amazon shopping app from Play store and run the below command to get the PACKAGE_NAME and PACKAGE_ACTIVITY
   ```$xslt
  adb shell dumpsys window windows | grep -E 'mCurrentFocus|mFocusedApp'
  ```
 - Please update the following variable in /TechnicalTest/src/main/java/com/validation/apptest/basePage.java file 
 PLATFORM_NAME, PLATFORM_VERSION, DEVICE_NAME, APP_PACKAGE, APP_ACTIVITY according to the connected device
 
   
  
 #Run

 -cd to the cloned repo and be in root and run the below command
 ```shell
 mvn clean install test -DsuiteXmlFile=testng_appTest.xml
``` 

#Report

To view the testNg report after running test goto /TechnicalTest/target/surefire-reports/emailable-report.html
right click and open in chrome browser
