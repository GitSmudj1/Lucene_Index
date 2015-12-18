package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import search.SearchResults;

public class Results {
	
	private SearchResults results = null;
	private HashMap<String, List<String>> resultsMap = null;
	private String[] searchTerms = null;
	
	public void setResults(SearchResults res) {
		this.results = res;
		splitResults();
	}
	
	public List<String> getKeys() {
		List<String> returnValues = new ArrayList<String>();
		returnValues.addAll(this.resultsMap.keySet());
		
		return returnValues;
	}
	
	public List<String> getResults(String category) {
		return resultsMap.get(category);
	}
	
	public HashMap<String, List<String>> getMap() {
		return resultsMap;
	}
	
	public String[] getSearchTerms() {
		return searchTerms;
	}
	
	private void splitResults() {
		
		resultsMap = results.getSearchResults();
		searchTerms = results.getSearchTerms();
		
	}

}
