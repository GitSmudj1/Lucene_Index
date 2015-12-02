package main;

import java.awt.EventQueue;

import model.DataModel;
import index.Index;
import search.Search;
import view.SearchEngine;

/**
 * Created by thomassinclair on 16/11/15.
 */
public class Main {

    private final DataModel dataModel = null;

    private final Index index = new Index(dataModel);
    private final Search search = new Search(dataModel);
    //private final View view = new View();

    public Main() {
        index.generateIndexes();
    }

    private final void run() {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEngine frame = new SearchEngine();
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
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
			}
		});
    }
}
