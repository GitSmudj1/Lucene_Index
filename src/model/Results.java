package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Results {
	
	private HashMap<String, List<String>> results;
	
	public Results() {
		
		results = new HashMap<String, List<String>>();
		
	}
	
	public void setResults(HashMap<String, List<String>> res) {
		this.results = res;
	}
	
	public List<String> getKeys() {
		List<String> returnValues = new ArrayList<String>();
		returnValues.addAll(this.results.keySet());
		
		return returnValues;
	}
	
	public List<String> getResults(String category) {
		return results.get(category);
	}
	
	public HashMap<String, List<String>> getMap() {
		return results;
	}

}
