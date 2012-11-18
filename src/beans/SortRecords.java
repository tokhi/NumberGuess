package beans;

import java.util.*;
public class SortRecords{
	public SortRecords(){
		super();
	}
	//public static void main(String[] args){
	public Map getRecords(){
		Map someMap= new LinkedHashMap();
		
		someMap.put("1","c");
		someMap.put("2","a");
		someMap.put("3","b");
		
		List mapKeys = new ArrayList(someMap.keySet());
		List mapValues = new ArrayList(someMap.values());
		
		someMap.clear();
		
		TreeSet sortedSet = new TreeSet(mapKeys);
		
		Object[] sortedArray = sortedSet.toArray();
		
		int size = sortedArray.length;
		
		//a) Ascending sort
		
		for (int i=0; i<size; i++){
		
			//System.out.println(sortedArray[i]);		
			someMap.put(mapValues.get(mapKeys.indexOf(sortedArray[i])), sortedArray[i]);
		
		}
		
		System.out.println(someMap);
		

		
		//someMap.clear();
		return someMap;
	}
}
