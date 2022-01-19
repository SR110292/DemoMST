# SuryaDemoProject #

Please note that the same test script had been duplicated with
different test data for parallel execution verification.

ENV SETUP IN WINDOWS:
1. Ensure Java (JRE and JDK) is in your computer
2. Install Maven in your computer (rename the extracted folder as "Maven")
3. Ensure the Maven bin folder is located as mentioned in the path: "C:\Program Files\Maven\bin"
4. Set environment System variable for JAVA as below
      Variable Name: JAVA_HOME
      Variable value: C:\Program Files\Java\jdk1.8.0_241 
5. Set environment System variable for MAVEN as below
      Variable Name: MAVEN_HOME
      Variable value: C:\Program Files\Maven
6. Add the Maven bin path in environment System variable  
      Variable Name: Path
      Add Variable value: C:\Program Files\Maven\bin 
7. Type the below commands in command prompt to ensure the java and maven are installed.
	    java -version  --> Java version should be displayed
	    mvn -version   --> Maven version should be displayed
	    
ENV SETUP IN MAC:
1. Ensure Java (JRE and JDK) is in your computer.
2. Download Maven and unzip on the user folder (rename the extracted folder as "Maven").
3. Enter bash command as "touch ~/.zprofile" 
4. Enter the command as "vim ~/.zprofile"
5. Inside the .zprofile file, type the below lines
		export M2_HOME=/users/<username>/Maven
		export PATH=$PATH:$M2_HOME/bin
6. Save and quit the .zprofile
7. Type the below commands in command prompt to ensure maven is installed
	    mvn -version --> Maven version should be displayed

TO RUN THE CODE:
1. After finishing all the above steps, either double click on the bat file "trigger.bat" 
   or Enter the command "mvn clean install" in the CMD prompt of the project folder.
2. Hopefully, the automation code should be triggered.

PARAMETERS AND DATA VARIABLES:
1. Browser can be changed in the "config.properties" file of the project folder.
	    key: browser
	    value: Edge (or) Chrome (or) FireFox

ANALYSIS:
1. After execution, the execution status would be displayed in the CMD prompt itself.
2. We can see the test report in the below 
   project folder: "\test-output\Report\Report.html".

COMPRESS:
1. Double click on the "compress.bat" file to create a portable zip folder.
2. This zipped folder will be created now in the project folder path - "target/Demo-0.0.1-SNAPSHOT-bundle.zip"
