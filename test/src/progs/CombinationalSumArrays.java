package progs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * https://www.interviewbit.com/problems/combination-sum/
 */
public class CombinationalSumArrays {

	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {

		if (arr == null || arr.isEmpty())
			return new ArrayList();

		int[] tempArr = new int[sum];
		ArrayList<ArrayList<Integer>> result = combinationUtil(arr, 0, arr.size(), sum, tempArr);
		Collections.sort(result, new Comparator<List<Integer>>() {
			public int compare(List<Integer> listOne, List<Integer> listTwo) {
				int oneSize = listOne.size();
				int twoSize = listTwo.size();

				for (int i = 0; i < oneSize; i++) {
					if (i == oneSize || i == twoSize)
						return oneSize - twoSize;

					int elementOne = listOne.get(i);
					int elementTwo = listTwo.get(i);
					if (elementOne == elementTwo)
						continue;

					return Integer.compare(elementOne, elementTwo);
				}
				return oneSize - twoSize;
			}
		});
		return result;
	}

	ArrayList<ArrayList<Integer>> combinationUtil(ArrayList<Integer> arr, int index, int n, int sum, int[] tempArr) {

		if (sum < 0)
			return res;

		if (sum == 0) {
			ArrayList<Integer> a = new ArrayList();
			for (int i = 0; i < index; i++)
				a.add(tempArr[i]);
			java.util.Collections.sort(a);

			if (!res.contains(a))
				res.add(a);
			return res;
		}

		for (int j = 0; j < n; j++) {
			tempArr[index] = arr.get(j);
			combinationUtil(arr, index + 1, arr.size(), sum - arr.get(j), tempArr);
		}

		return res;
	}
}
