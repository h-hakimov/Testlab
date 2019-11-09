/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Main {
    
    public void makeTest(String file){
        XmlParser xmlparser = new XmlParser();
        xmlparser.parse(file);
        BrowserActions browser = new BrowserActions();
        if(xmlparser.getActionlist().size() > 0){
            browser.init();
            for (Action act : xmlparser.getActionlist()){
                if (act.getName().equals("openURL")){
                    browser.moveToUrl(act.getParam());
                }
                if (act.getName().equals("Click")){
                    browser.click(act.getParam());
                }
                if (act.getName().equals("setValue")){
                    String delims = "[|]";
                    String[] params = act.getParam().split(delims);
                    browser.setValue(params[0], params[1]);
                }
                if (act.getName().equals("checkElementVisible")){
                    if (browser.checkElementVisible(act.getParam())){
                        System.out.println("It's visible!");
                    } else System.out.println("It's NOT visible!");
                }
                if (act.getName().equals("Screenshot")){
                    browser.screenshot();
                }
            }
            browser.closeBrowser();
        }
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String file = "script.xml";
        
        Main main = new Main();
        main.makeTest(file);
        
    }
}
