package model;

import java.util.Date;

/**
 * Created by thomassinclair on 16/11/15.
 */
public interface DataModel {
    String getDoc();

    static String getTitle() {
		// Testing
    	System.out.println("Title");
		return null;
	}

    static Date getDate() {
		// Testing
    	System.out.println("Date");
		return null;
	}

    String getDept();

    String getBureau();

    static String getAgency() {
		// Testing
    	System.out.println("Agency");
		return null;
	}

    String getAction();

    String getContent();
}
