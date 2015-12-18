package model;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Created by thomassinclair on 29/11/15.
 */
public class Parser {

    private HashMap<String, Doc> articles;

    public Parser() {
    	
    	System.out.println("Parsing");

        articles = new HashMap<String, Doc>();

        loadData();

    }

    private void loadData(){

        try{

            Files.walk(Paths.get("data/")).forEach(filePath -> {

                if(Files.isRegularFile(filePath)) {

                    String fileName = filePath.getFileName().toString();
                    
                    if(fileName.endsWith(".xml")) {
                    
	                    fileName = fileName.replace(fileName.substring(fileName.length() - 4), "");
	
	                    DocumentBuilderFactory docFac;
	                    File xmlFile;
	                    DocumentBuilder docBuilder = null;
	                    Document doc;
	
	                    try {
	                        xmlFile = filePath.toFile();
	                        docFac = DocumentBuilderFactory.newInstance();
	                        docBuilder = docFac.newDocumentBuilder();
	                        doc = docBuilder.parse(xmlFile);
	                        doc.getDocumentElement().normalize();
	
	                        processDoc(doc, fileName);
	
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                    }
                    
                    }

                }

            });

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void processDoc(Document doc, String fileName) {

        NodeList nodeList = doc.getElementsByTagName("doc");
        NodeList childList = nodeList.item(0).getChildNodes();

        FRDoc article = new FRDoc();

        for(int i = 0; i < childList.getLength(); i++) {

            Node node = childList.item(i);

            String nodeName = node.getNodeName();

            if(!nodeName.equals("#text")) {
                String textContent = node.getTextContent().trim();
                addToDoc(article, nodeName, textContent);
            }

        }

        articles.put(fileName, article);

    }

    private void addToDoc(FRDoc article, String tag, String content) {

        switch (tag) {

            case "docno" :
                article.setDocNo(content);
                break;
            case "parent" :
                article.setParent(content);
                break;
            case "text" :
                article.setText(content);
                break;
            case "usdept" :
                article.setUSDept(content);
                break;
            case "usbureau" :
                article.setUSBureau(content);
                break;
            case "cfrno" :
                article.setCfrno(content);
                break;
            case "rindock" :
                article.setRindock(content);
                break;
            case "agency" :
                article.setAgency(content);
                break;
            case "action" :
                article.setAction(content);
                break;
            case "summary" :
                article.setSummary(content);
                break;
            case "date" :
                article.setDate(content);
                break;
            case "further" :
                article.setFurther(content);
                break;
            case "supplem" :
                article.setSupplem(content);
                break;
            case "signer" :
                article.setSigner(content);
                break;
            case "signjob" :
                article.setSignjob(content);
                break;
            case "frfiling" :
                article.setFrfiling(content);
                break;
            case "billing" :
                article.setBilling(content);
                break;
            case "footcite" :
                article.setFootcite(content);
                break;
            case "footnote" :
                article.setFootnote(content);
                break;
            case "footname" :
                article.setFootname(content);
                break;
            case "table" :
                article.setTable(content);
                break;
            case "import" :
                article.setImport(content);
                break;
            case "address" :
                article.setAddress(content);
                break;
            case "doctitle" :
                article.setDocTitle(content);
                break;
        }

    }

    public HashMap<String, Doc> getDocs() {
        return articles;
    }

}
