
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */

public class XmlParser implements Parser {

    
    private File xml;
    private DocumentBuilder docbuild;
    private Document document;
    private ArrayList<Action> actionlist = new ArrayList<Action>();

    /**
     * Get List of actions
     * @return List of actions
     */
    public ArrayList<Action> getActionlist() {
        return actionlist;
    }

    /**
     * Set List of actions
     * @param actionlist List of actions
     */
    public void setActionlist(ArrayList<Action> actionlist) {
        this.actionlist = actionlist;
    }

    /**
     *
     */
    public XmlParser() {
        try {
            docbuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parse XML file and fetch actions to ArrayList
     * @param file
     */
    @Deprecated
    public void parse(File file) {
        try {
            xml = file;
            document = docbuild.parse(xml);
            parseXML();
        } catch (SAXException ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Parse XML file and fetch actions to ArrayList
     * @param file
     */
    public void parse(String file){
        try {
            document = docbuild.parse(file);
            parseXML();
        } catch (SAXException ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Parse XML file and fetch actions to ArrayList
     * 
     */
    private void parseXML() {
        Node root = document.getDocumentElement();
        NodeList actions = root.getChildNodes();
        for(int i = 0; i < actions.getLength(); i++){
            if(actions.item(i).getNodeType() != Node.TEXT_NODE){
                Action act = new Action();
                act.setName(actions.item(i).getAttributes().getNamedItem("name").getTextContent());
                System.out.println(act.getName());
                NodeList inaction = actions.item(i).getChildNodes();
                for (int j = 0; j < inaction.getLength(); j++){
                    if (inaction.item(j).getNodeType() != Node.TEXT_NODE){
                        if(inaction.item(j).getNodeName().equals("param")){
                            act.setParam(inaction.item(j).getAttributes().getNamedItem("name").getTextContent());
                            System.out.println(" " + act.getParam());
                        } else if(inaction.item(j).getNodeName().equals("description")){
                            act.setDiscription(inaction.item(j).getTextContent());
                            System.out.println(" " + act.getDescription());
                        }
                    }
                }
                actionlist.add(act);
            }
        }
    }
}
