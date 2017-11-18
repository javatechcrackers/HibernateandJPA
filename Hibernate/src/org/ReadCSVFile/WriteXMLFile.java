package org.ReadCSVFile;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXMLFile {
	
	public static void writefile(ArrayList<String> list){
		try {
		
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Monitor");
			doc.appendChild(rootElement);
			
		
			Element declares = doc.createElement("declares");
			rootElement.appendChild(declares);
	 
			for(int i=0;i<list.size();i++)
			{
				Element declare = doc.createElement("declare");
				declare.appendChild(doc.createTextNode(list.get(i)));
				declares.appendChild(declare);
				Attr attr = doc.createAttribute("id");
				attr.setValue(list.get(i).toLowerCase());
				declare.setAttributeNode(attr);
				
				Attr attr2 = doc.createAttribute("type");
				attr2.setValue("headerindex");
				declare.setAttributeNode(attr2);
				
			
			}
		
	/*		Element queries = doc.createElement("queries");
			rootElement.appendChild(queries);
	 
			for(int i=0;i<list.size();i++)
			{
				Element query = doc.createElement("query");
				query.appendChild(doc.createTextNode(list.get(i)));
				queries.appendChild(query);
				
				Element attributes = doc.createElement("attributes");
				query.appendChild(attributes);
				Attr attr = doc.createAttribute("alias");
				attr.setValue(list.get(i).toLowerCase());
				query.setAttributeNode(attr);
				
				Attr attr2 = doc.createAttribute("class =");
				attr2.setValue("none");
				query.setAttributeNode(attr2);
				
			
			}
			*/
			
			Element queries = doc.createElement("queries");
			rootElement.appendChild(queries);
	 
			for(int i=0;i<list.size();i++)
			{
				Element query = doc.createElement("query");
				//query.appendChild(doc.createTextNode(list.get(i)));
				queries.appendChild(query);
				
				for(int j=0;j<i;j++)
				{
				Element attributes = doc.createElement("attributes");
				query.appendChild(attributes);
				
				Attr attr = doc.createAttribute("alias=");
				attr.setValue(list.get(i).toLowerCase());
				attributes.setAttributeNode(attr);
				
				Attr attr2 = doc.createAttribute("class=");
				attr2.setValue("none");
				attributes.setAttributeNode(attr2);
				}
				
				Element default_ = doc.createElement("default_");
				query.appendChild(default_);
				
				/*Attr attr = doc.createAttribute("id");
				attr.setValue(list.get(i).toLowerCase());
				query.setAttributeNode(attr);
				
				Attr attr2 = doc.createAttribute("type");
				attr2.setValue("headerindex");
				query.setAttributeNode(attr2);*/
				
			
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("E://[PROJECTS]//[HIBERNATE]//Hibernate//src//org//ReadCSVFile//file.xml"));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
	 
			System.out.println("File saved!");
	 
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		}

	private static void header() {
		// TODO Auto-generated method stub
		
	}
		
	}
	
	
