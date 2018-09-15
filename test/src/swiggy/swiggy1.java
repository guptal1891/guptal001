package swiggy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, you need to find all substrings with following conditions met.
 * 1.  length of the substring should be between range inclusive (minLength, maxLength) 
 * 2.  Number of unique characters should be greater than given maxUnique variable  
 * Find maximum occurrence count of such a substring 
 * @author Lovely
 *
 */
public class swiggy1 {

	// Function to get all substrings
	static public List<String> getAllSubStrings(String str, int n) {

		List<String> subStr = new ArrayList<>();
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++) {
				subStr.add(str.substring(i, j));
			}

		return subStr;
	}

	static int countMaxOccurence(List<String> strSet, int minLength, int maxLength, int maxUnique) {

		Map<String, Integer> mapCount = new HashMap<>();
		for (String str : strSet) {

			if (str.length() >= minLength && str.length() <= maxLength && uniqueChars(str) <= maxUnique) {
				if (mapCount.get(str) != null)
					mapCount.put(str, mapCount.get(str) + 1);

				else
					mapCount.put(str, 1);
			}
		}

		int maxVal = -1;
		// find max count value
		for (Integer val : mapCount.values()) {
			if (val > maxVal) {
				maxVal = val;
			}
		}

		return maxVal;
	}

	static int uniqueChars(String str) {

		boolean[] countArr = new boolean[Character.MAX_VALUE];
		for (int i = 0; i < str.length(); i++) {
			countArr[str.charAt(i)] = true;
		}

		int count = 0;
		for (int i = 0; i < countArr.length; i++) {
			if (countArr[i] == true) {
				count++;
			}
		}

		return count;
	}

	static int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {

		List<String> strSet = getAllSubStrings(s, s.length());
		return countMaxOccurence(strSet, minLength, maxLength, maxUnique);
	}

	public static void main(String[] args) {
		System.out.println(getMaxOccurrences("ababab", 2, 3, 4));
	}
}
