package gen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import DataModel.DataModelPackage;

public class PopulateModel {
	
	public void populateModel() {
		
		try {
			
			parse(Jsoup.parse(new File("data/source/01/FR940104.0"), "UTF-8"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void parse(Document doc) {
		
		List<EObject> eObjects = new ArrayList<EObject>();
		EClass eClass = null;
		boolean firstRun = true;
		boolean inDoc = false;
		String newFileName = "";
		
		for(Element e : doc.getAllElements()) {
			
			String currentNode = e.nodeName();
			
			EClassifier eClassifier = DataModelPackage.eINSTANCE.getEClassifier(currentNode);
			if (eClassifier instanceof EClass && firstRun){
				
				System.out.println("----------\n START OF DOC \n----------");
				
				firstRun = false;
				inDoc = true;
				System.out.println("Adding: " + currentNode);
				eClass = (EClass)eClassifier;
				
			} else if (eClassifier instanceof EClass && !firstRun) { //new doc tag
				
				//save old stuff
				
				saveData(newFileName, eObjects);
				
				System.out.println("----------\n START OF DOC \n----------");
				
				System.out.println("Adding: " + currentNode);
				eClass = (EClass)eClassifier;
				
			} else if(inDoc) {
				
				System.out.println("Node Name: " + currentNode);
				
				EObject eObject = EcoreUtil.create(eClass);
				String currentAttribute = "";
				
				for(Node n : e.childNodes()) {
					
					String attr = n.attributes().get("text").trim();
					
					if(!attr.equals(""))
						currentAttribute = currentAttribute + attr + "\n\n";
					
				}
				
				//System.out.println(currentAttribute);
				
				if(currentNode.equals("docno"))
					newFileName = "data/converted/" + currentAttribute.trim() + ".xmi";
				
				eObject.eSet(findFeature(currentNode, eClass), currentAttribute.trim());
				eObjects.add(eObject);
				
			}
			
		}
		
		saveData(newFileName, eObjects);
		
	}
	
	private void saveData(String newFileName, List<EObject> eObjects) {
		
		System.out.println("----------\n END OF DOC \n----------");
		
		try {
			URI output = URI.createFileURI(newFileName);
			Resource ecore = new XMIResourceFactoryImpl().createResource(output);
			ecore.getContents().addAll(eObjects);
			ecore.save(Collections.EMPTY_MAP);
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		
		eObjects.clear();
		
	}
	
	private EStructuralFeature findFeature(String currentNode, EClass eClass) {
		
		for(EStructuralFeature f : eClass.getEStructuralFeatures())
			if(f.getName().equals(currentNode))
				return f;
		
		return null;
		
	}
	
	public static void main(String[] args) {
		
		PopulateModel modelPop = new PopulateModel();
		
		modelPop.populateModel();
		
	}

}
