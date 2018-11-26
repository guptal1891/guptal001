package progs;

import java.util.Arrays;
import java.util.List;

public class MaxSumContigousSubarray {

	public static int maxSubArray(final List<Integer> arr) {

		if (arr != null && arr.size() == 0)
			return 0;

		int maxSum = Integer.MIN_VALUE;
		int curMax = 0;
		for (int i = 0; i < arr.size(); i++) {

			curMax = Math.max(arr.get(i), curMax + arr.get(i));
			maxSum = Math.max(curMax, maxSum);
		}

		return maxSum;
	}

	public static void main(String[] args) {

		Integer arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		Integer arr2[] = { 97, 0, -461, -125, -404, -59, -322, -495, -288, -341, -449, -313, -192, -214, -389, -202,
				-183, -72, -416, -455, -187, -242, -416, 39, -198, -338, -465, -248, -25, -398, -97, -461, -214, -423,
				-407, -77, -190, -67, -178, -410, -160, 72, -350, -31, -85, -247, -319, -462, -303, -48, -354, -110, 17,
				60, 19, 80, -218, -28, -426, -366, -140, 50 };
		System.out.println(maxSubArray(Arrays.asList(arr)));
		System.out.println(maxSubArray(Arrays.asList(arr2)));
	}

}
