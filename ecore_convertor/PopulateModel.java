package gen;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import DataModel.ParserPackage;

public class PopulateModel {
	
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	
	public void populateModel() {
		
		try {
			
			Files.walk(Paths.get("data/source/")).forEach(filePath -> {
				
				if(Files.isRegularFile(filePath)) {
					
					File theFile = filePath.toFile();
					
					if(theFile.getName().startsWith("FR")) {
					
						try {
							System.out.println("Current File: " + filePath);
							parse(Jsoup.parse(theFile, "UTF-8"));
						} catch (Exception e) {
							e.printStackTrace();
						}
					
					}
					
				}
				
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void parse(Document doc) {
		
		boolean firstRun = true;
		boolean inDoc = false;
		String newFileName = "";
		
		//Set Up XML
		org.w3c.dom.Document xmlDoc = null;
		org.w3c.dom.Element rootElem = null;
		
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(Element e : doc.getAllElements()) {
			
			String currentNode = e.nodeName();
			
			EClassifier eClassifier = ParserPackage.eINSTANCE.getEClassifier(currentNode);
			if (eClassifier instanceof EClass && firstRun){
				
				//System.out.println("----------\n START OF DOC \n----------");
				
				firstRun = false;
				inDoc = true;
				
				xmlDoc = builder.newDocument();
				
				rootElem = xmlDoc.createElement("doc");
				xmlDoc.appendChild(rootElem);
				
			} else if (eClassifier instanceof EClass && !firstRun) { //new doc tag
				
				saveData(newFileName, xmlDoc);
				
				//System.out.println("----------\n START OF DOC \n----------");
				
				xmlDoc = builder.newDocument();
				
				rootElem = xmlDoc.createElement("doc");
				xmlDoc.appendChild(rootElem);
				
			} else if(inDoc) {
				
				//System.out.println("Node Name: " + currentNode);
				
				String currentAttribute = "";
				
				org.w3c.dom.Element currentNodeElem = xmlDoc.createElement(currentNode.toString());
				rootElem.appendChild(currentNodeElem);
				
				for(Node n : e.childNodes()) {
					
					String attr = n.attributes().get("text").trim();
					attr = attr.replace("\n", " ");
					attr = attr.replace("&hyph;", "-");
					attr = attr.replace("hyph;", "-");
						
					currentAttribute = attr;

					if(!attr.equals("")) {
						org.w3c.dom.Element paraElem = xmlDoc.createElement("textblock");
						paraElem.appendChild(xmlDoc.createTextNode(attr));
						currentNodeElem.appendChild(paraElem);
					}
				}
				
				if(currentNode.equals("docno"))
					newFileName = "data/converted/" + currentAttribute.trim() + ".xml";
				
			}
			
		}
		
		saveData(newFileName, xmlDoc);
		
	}
	
	private void saveData(String newFileName, org.w3c.dom.Document xmlDoc) {
		
		//System.out.println("----------\n END OF DOC \n----------");
		
		try {
			
			TransformerFactory tranFact = TransformerFactory.newInstance();
			Transformer transformer = tranFact.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(xmlDoc);
			StreamResult result = new StreamResult(new File(newFileName));
			transformer.transform(source, result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("BEGIN");
		
		PopulateModel modelPop = new PopulateModel();
		
		modelPop.populateModel();
		
		System.out.println("COMPLETE");
		
	}

}
