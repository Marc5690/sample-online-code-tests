package com.number.find;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class FindNthRarestNumber {
    public static int nthMostRare(int[] elements, int n) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int returnedVal = 0;
    	
    	for(int i = 0; i < elements.length; i++) {
    		if(map.containsKey(elements[i])) {
    			Integer newVal = map.get(elements[i]);
    			newVal += 1;
    			map.put(elements[i], newVal);
    		}
    		else {
    			map.put(elements[i], 1);
    		}
    	}
    	
    	ArrayList<Integer> numberSort = new ArrayList<Integer>(map.values());
    	Collections.sort(numberSort);
    	Integer nRarest = numberSort.get(n-1);
    	
    	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    		  
    		  if (entry.getValue().equals(nRarest)) {
    			  returnedVal = entry.getKey();
    		  }
    		}
    	
    	return returnedVal;
    }

    public static void main(String[] args) {
        int x = nthMostRare(new int[] { 5, 4, 3, 2, 1, 2, 2,2,2,2,5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 5);
        System.out.println(x);
    }
}