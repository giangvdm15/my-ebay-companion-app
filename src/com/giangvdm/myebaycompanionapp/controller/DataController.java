package com.giangvdm.myebaycompanionapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author giangvdm
 */
public class DataController {
    
    private static final String CONFIG_FILE_PATH = "data/config.xml";
    
    private static final String DEBUG_FILE_PATH = "data/debug.log";
    
    private void checkAllRequiredFiles() throws IOException {
        // create directory to store all data files
        new File("data").mkdir();
        
        // config xml file
        File configXmlFile = new File(CONFIG_FILE_PATH.trim());
        if (!configXmlFile.isFile()) {
            configXmlFile.createNewFile();
        }
        
        // debug logger file
        File debugLogFile = new File(DEBUG_FILE_PATH.trim());
        if (!debugLogFile.isFile()) {
            debugLogFile.createNewFile();
        }
    }
    
    public DataController() throws IOException {
        checkAllRequiredFiles();
    }
    
    public void getCurrencyRatesConfig() throws IOException {
        
        File configXmlFile = new File(CONFIG_FILE_PATH.trim());
        
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document xmlDoc = dBuilder.parse(configXmlFile);
            xmlDoc.getDocumentElement().normalize();
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
