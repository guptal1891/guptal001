package Acko;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryLongestChain {

    // Complete the longestChain function below.
    static int longestChain(List<String> words) {

        // sort the list of inputs.    
    	Collections.sort(words,new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				 
				return str1.length()-str2.length();
			}
		});
        Map<String ,Integer> wordMap = new HashMap<String ,Integer>();
        //put the firt element into map
        wordMap.put(words.get(0),1);
        int[] longestLength = new int[words.size()];
        longestLength[0] =1;
        int result =longestLength[0];

        for(int i=1;i < words.size();i++)
        {    
            longestLength[i] =1;
            String str = words.get(i);
            int size = str.length();

            for(int j=0;j<size;j++){
                String newStr =  str.substring(0, j) + str.substring(j+1);
                if(wordMap.containsKey(newStr)){
                    longestLength[i]= Math.max(longestLength[i], wordMap.get(newStr)+1);
                }
            }
            result = Math.max(result, longestLength[i]);
            wordMap.put(str, longestLength[i]);
        }
		return result;
	}
}
