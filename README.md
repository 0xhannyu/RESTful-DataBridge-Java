# RESTful-DataBridge-Java

This is a very simple RESTful API made with SparkJava framework.

**Steps To Use**
- Get the dependency mentioned in the pom.xml in your project.
- Connect your PC to your Mobile Hotspot.
- Get the IPv4 Address by running _ipconfig_ in the terminal.
- Open the link **http://{YOUR-IPv4-ADDRESS}:4567/home** in your mobile browser.

**Endpoints**
- (GET) /mtc/:data - **http://{YOUR-IPv4-ADDRESS}:4567/hanu/DATA**  will send DATA to your PC and get printed on terminal.
- (GET) /ctm - will let you send the data from a .txt file to your mobile browser.
