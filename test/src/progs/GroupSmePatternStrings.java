package progs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * a string is said to be a part of a group if it have the same pattern for eg :
 * abc,bcd,a,klmn,yza,z,k abc,bcd,yza are in one group a,z,k are in one group
 * kpsw in one group
 * 
 * catch : z comes after a
 *
 * given a list of lower case character string, print the different different
 * groups.
 * 
 */

public class GroupSmePatternStrings {

	static Map<StringPattern, Set<String>> groupSimilarStrings(String[] arr) {

		if (arr.length == 0)
			return Collections.emptyMap();

		Map<StringPattern, Set<String>> group = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			StringPattern pat = new StringPattern(arr[i]);

			if (group.get(pat) != null) {
				group.get(pat).add(arr[i]);
			} else {
				Set<String> values = new HashSet<>();
				values.add(arr[i]);
				group.put(pat, values);
			}
		}

		return group;
	}

	public static void main(String[] s) {

		String[] arr = { "abc", "a", "c", "xyz", "zab", "abcd"};
		System.out.println(groupSimilarStrings(arr).values());
	}
}

class StringPattern {

	int[] arr;

	public StringPattern(String str) {

		arr = new int[str.length()];
		for (int index = 0, i = 0; index < str.length() - 1; index++) {
			int diff = str.charAt(index + 1) - str.charAt(index);

			if (diff < 0)
				diff = diff + 26;
			arr[i++] = diff;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(arr);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StringPattern other = (StringPattern) obj;
		if (!Arrays.equals(arr, other.arr))
			return false;
		return true;
	}

}
