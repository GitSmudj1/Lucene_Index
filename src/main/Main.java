package main;

import model.*;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import index.Index;
import search.Search;
import view.SearchEngine;

/**
 * Created by thomassinclair on 16/11/15.
 */
public class Main {

	private final DataSet dataSet = new DataSet();
    private final Index index = new Index(dataSet);
    private final Search search = new Search();
    
    private HashMap<String, List<String>> results;

    public Main() {
    	
    	results = new HashMap<String, List<String>>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("types"));
            String token = br.readLine();

            while(token != null) {
                if(!token.startsWith("#"))
                    index.generateIndexes(token);
                token = br.readLine();
            }

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
        //searching

    }

    public static void main(String[] args) {
        new Main().run();
    }
}
