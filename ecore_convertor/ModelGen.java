package gen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

public class ModelGen {
	
	private EPackage newPackage;
	
	private void createEcoreModel() {
		
		System.out.println("Begin");
		
		newPackage = EcoreFactory.eINSTANCE.createEPackage();
		newPackage.setName("DataModel");
		newPackage.setNsURI("com.example");
		newPackage.setNsPrefix("DataModel");
		
		try {
			parse(new Scanner(new File("data/FR940104.0")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void parse(Scanner scanner) {
		
		boolean inDefinition = false;
		EClass classObject = null;
		HashSet<String> visited = new HashSet<String>();
		
		classObject = EcoreFactory.eINSTANCE.createEClass();
		classObject.setName("doc");
		
		newPackage.getEClassifiers().add(classObject);
		
		while(scanner.hasNextLine()) {
			
			String line = scanner.nextLine().trim();
			
			if(line.startsWith("<DOC>")) {
				
				inDefinition = true;
				
			}
			
			if(inDefinition) {
				
				if(line.startsWith("<") && !line.startsWith("</") && !line.startsWith("<!--") && !line.startsWith("<DOC>")) {
					
					System.out.println(line);
					String name = line.substring(1, line.indexOf(">")).toLowerCase();
					
					if(!visited.contains(name)) {
					
						EAttribute attr = EcoreFactory.eINSTANCE.createEAttribute();
						
						attr.setName(name);
						attr.setEType(EcorePackage.Literals.ESTRING);
						attr.setUnsettable(true);
						classObject.getEStructuralFeatures().add(attr);
						
						visited.add(name);
						
					}
					
				}
			
			}
			
			if(line.startsWith("</DOC>")) {
				inDefinition = false;
			}
			
		}
		
		try {
		
			URI output = URI.createFileURI("model/model.ecore");
			
			Resource ecore = new EcoreResourceFactoryImpl().createResource(output);
	
			ecore.getContents().add(newPackage);
		
			ecore.save(Collections.EMPTY_MAP);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Complete");
		
	}
	
	public static void main(String[] args) {
		
		ModelGen modelGen = new ModelGen();
		
		modelGen.createEcoreModel();
	}

}
