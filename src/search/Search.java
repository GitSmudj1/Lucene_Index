package search;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by thomassinclair on 16/11/15.
 */
public class Search {

    private IndexSearcher searcher = null;
    private QueryParser parser = null;

    private HashMap<String, List<String>> resultMap;

    public Search() {

        resultMap = new HashMap<String, List<String>>();

    }

    public HashMap<String, List<String>> searchForQuery(String query) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("types"));
            String token = br.readLine();

            while(token != null) {
                if(!token.startsWith("#"))
                    searcher(query, token);
                token = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultMap;

    }

    private void searcher(String query, String cat) {

        Query theQuery;

        try {
            searcher = new IndexSearcher(DirectoryReader.open(FSDirectory.open(new File("index/" + cat).toPath())));
            parser = new QueryParser("data", new StandardAnalyzer());

            theQuery = parser.parse(query);

            TopDocs results = searcher.search(theQuery, 5);
            ScoreDoc[] hits = results.scoreDocs;

            if(hits.length > 0) {

                System.out.println("----------");
                System.out.println(cat);
                System.out.println("----------\n");

                List<String> catResults = new ArrayList<String>();

                for(int i = 0; i < hits.length; i++) {

                    Document doc = searcher.doc(hits[i].doc);

                    String fileName = doc.getField("fileName").stringValue();
                    System.out.println("File Name: " + fileName);

                    catResults.add(fileName);

                }

                resultMap.put(cat, catResults);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
