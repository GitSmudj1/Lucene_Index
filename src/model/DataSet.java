package model;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by mlb12174 on 30/11/15.
 */
public class DataSet {

    private HashMap<String, Doc> dataSet;

    public DataSet() {

        dataSet = new Parser().getDocs();

    }

    public Doc getArticle(String key) {
        return dataSet.get(key);
    }

    public Iterator getIterator() {
        return dataSet.entrySet().iterator();
    }

}
