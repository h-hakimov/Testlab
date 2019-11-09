This is a test task.

To run program use Maven mvn exec:java. Start class is Main. Program do scripts from script.xml in Google Chrome.

The system implements 5 scripts:
  openUrl - Open specific URL in browser
  
  Click - Make a click on element in browser. Parameter must be in short Xpath value
  
  setValue - Set value on element in browser. Parameter must be in shor Xpath value plus value after '|' char. 
             For example, //*[@id="tsf"]/div[2]/div[1]/div[1]/div/div[2]/input | Yandex
             
  checkElementVisible - Check if element on web page is visible. Parameter must be in short Xpath value
  
  Screenshot - Take a screensot on web page and save it in screenshot.png.
  
  
