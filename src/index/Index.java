package index;

import model.*;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;

import java.io.*;
import java.util.Iterator;
import java.util.Map;

import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * Created by thomassinclair on 16/11/15.
 */
public class Index {

    private DataSet dataSet;

    private IndexWriter indexWriter;
    private IndexWriterConfig iwc;
    private Directory dir;

    public Index(DataSet dataSet) {

        this.dataSet = dataSet;

    }

    public void generateIndexes(String category) {

        String indexPath = "index/" + category;

        new File(indexPath).mkdirs();

        indexDocs(indexPath, category);

    }

    private void indexDocs(String indexPath, String category) {

        try {

            dir = FSDirectory.open(new File(indexPath).toPath());
            iwc = new IndexWriterConfig(new StandardAnalyzer());
            iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            indexWriter = new IndexWriter(dir, iwc);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Iterator<Map.Entry<String, Doc>> iterator = dataSet.getIterator();

        while(iterator.hasNext()) {

            java.util.Map.Entry article = iterator.next();

            String fileName = (String)article.getKey();
            String dataToIndex = ((Doc) article.getValue()).getCategory(category);

            if(!dataToIndex.equals("")) {

                try {

                    Document doc = new Document();
                    doc.add(new StringField("fileName", fileName, Field.Store.YES));
                    doc.add(new TextField("data", new BufferedReader(new StringReader(dataToIndex))));
//                    doc.add(new TextField("data", dataToIndex, Field.Store.YES));
                    indexWriter.addDocument(doc);

//                System.out.println("File Name: " + doc.getField("fileName"));
//                System.out.println("Data: " + doc.getField("data"));

                } catch (Exception e) {
                    System.out.println("In Catch");
                    e.printStackTrace();
                }

            }

        }

        try {
//            System.out.println("--------------------");
//            System.out.println("Number of Docs in Index: " + indexWriter.numDocs());
//            System.out.println("--------------------\n");
            indexWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
