package main;

import model.*;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import index.Index;
import view.SearchEngine;

/**
 * Created by thomassinclair on 16/11/15.
 */
public class Main {

	private final DataSet dataSet = new DataSet();
    private final Index index = new Index(dataSet);
    private File indexed;

    public Main() {

    	indexed = new File("indexed");
    	if(!indexed.exists())
    		generateIndex();
        
    }
    
	private final void generateIndex() {
		
		System.out.println("Indexing");
    	
    	try {
    		
            BufferedReader br = new BufferedReader(new FileReader("types"));
            String token = br.readLine();

            while(token != null) {
                if(!token.startsWith("#"))
                    index.generateIndexes(token);
                token = br.readLine();
            }
        
            new BufferedWriter(new FileWriter(indexed));

        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    }

    private final void run() {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEngine frame = new SearchEngine(dataSet);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

    }

    public static void main(String[] args) {
        new Main().run();
    }
    
}
