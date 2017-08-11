package com.amazonaws.lambda.demo;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import com.amazonaws.services.lambda.runtime.Context;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class ConfigProperties {
	
	public Context ctx = createContext();
	
	
	public void consoleConfiguration() throws IOException {
		
		ctx.getLogger().log("Current Directory : ");
		
		File file = new File("config_properties.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
		        .newInstance();

		try {
			
			ctx.getLogger().log("Current Directory : 1");
		
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			try {
				
				ctx.getLogger().log("Current Directory --");
				Document document = documentBuilder.parse(file);
				
				ctx.getLogger().log("Current Directory :+ ");
				
				Element credentinalElement = document.getDocumentElement();
				
				ctx.getLogger().log(credentinalElement.getTagName());
				
				NodeList aws_credentinal = credentinalElement.getElementsByTagName("aws_credentails");
				
				Node aws_credentinal_item = aws_credentinal.item(0);
				
				NodeList aws_credentinal_item_list =  aws_credentinal_item.getChildNodes();
				
				ctx.getLogger().log(Integer.toString(aws_credentinal_item_list.getLength()));
				
				String aws_access_key = aws_credentinal_item_list.item(0).getTextContent();
				String aws_secret_key = aws_credentinal_item_list.item(1).getTextContent();
				
				ctx.getLogger().log("AWS Access Key : "+aws_access_key);
				ctx.getLogger().log("AWS Secret Key : "+aws_secret_key);
//				
//				//aws_credentinal_item_list.
//				
//				for (int i=0; i < aws_credentinal_item_list.getLength(); i++) {
//					
//					ctx.getLogger().log(Integer.toString(i));
//					ctx.getLogger().log(aws_credentinal_item_list.item(i).getNodeName());
//					ctx.getLogger().log(aws_credentinal_item_list.item(i).getTextContent());
//				}
//				
//				//Element aws_credentinal_item_element = (Element) aws_credentinal_item_list.item(0);
//				
//				//ctx.getLogger().log(aws_credentinal_item_list.item(0));
//				ctx.getLogger().log("In Loops");
//				
//				//ctx.getLogger().log(Integer.toString(aws_credentinal.getLength()));
//				
//				//NodeList credentinals_list = credentinalElement.getChildNodes();
//				
//				//Node aws_credentinals = credentinals_list.item(0);
//				//aws_credentinals.getElements
//				
//				//ctx.getLogger().log(aws_credentinals);
//				
//				//Node usr_2 = usr.item(0);
//				
//				//ctx.getLogger().log(Short.toString(usr_2.getNodeType()));
//				
//				//NodeList usr_ = usr.getChildNodes();
//				
//				//ctx.getLogger().log(usr.toString());
//				
//				//int usr_ = usr.getLength();
//				
//				//ctx.getLogger().log(Integer.toString(usr_));
//				
//				//ctx.getLogger().log(usr.toString());
//				
//				ctx.getLogger().log("Current Directory :++ ");
//				//String currentDir = System.getProperty("user.dir");
//				ctx.getLogger().log("Current Directory :+ ");
				
			} catch (SAXException e) {
				
				ctx.getLogger().log("Exception : 2");
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
			}
		} catch (ParserConfigurationException e) {

			ctx.getLogger().log("Exception : 1");
			e.printStackTrace();
		}
		
		
	}
	
    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }
	


}
