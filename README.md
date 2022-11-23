Prerequisite:
		1. Maven should be present in system and environment variable should be created
		2. Appium server should be running succesfully with apporitate app opened
	
Software and tools used:
		1.  Eclipse IDE
		2.  Selenium 3.141.0 jar dependency
		3.  testng 6.8.8 jar dependency
		4.  appium java client 8.2.0 jar dependency   

Test approach followed:
                1.  Creating the project with maven dependencies
                2.  Writing the test case in testng annotations
                3.  Configuring the test cases in testng. Xml
                4.  Configure testng. Xml in pom. Xml under surfire plugin
                5.  Run the pom. Xml using maven commands
		6.  Appium server should be up and running, so that automation code will execute in appium server which we configured in remoteserver url
	
Console Output
		The console output is more intuitive and better readable as the default one of maven,testng and Selenium. 
		A  console output will give you a clear overview about which tests are currently running. 
	
TestNG report:

		.\test-output\emailable-report.html
		.\test-output\index.html
		
Command to execcute:

Windows:
		Open command prompt
		Navigate to project directory(command: cd ..(directory))
		command to call :  call mvn clean install
MacOS:
		Open terminal 
		Navigate to project directory
		command to call : mvn clean install
