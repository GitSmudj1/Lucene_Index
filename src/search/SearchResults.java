package search;

import java.util.HashMap;
import java.util.List;

public class SearchResults {
	
	private HashMap<String, List<String>> searchResults;
	private String[] searchTerms;
	
	public SearchResults(HashMap<String, List<String>> searchResults, String[] searchTerms) {
		
		this.searchResults = searchResults;
		this.searchTerms = searchTerms;
		
	}
	
	public HashMap<String, List<String>> getSearchResults() {
		return searchResults;
	}
	
	public String[] getSearchTerms() {
		return searchTerms;
	}

}
