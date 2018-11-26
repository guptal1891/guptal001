package progs;

import java.util.ArrayList;
import java.util.List;

public class MaxSumNonNegativeSubarray {

	public static ArrayList<Integer> maxset(ArrayList<Integer> A) {

		int start = 0, end = 0;
		long sum = Integer.MIN_VALUE;
		int res_start = 0, res_end = -1;
		long max_sum = Integer.MIN_VALUE;
		ArrayList<Integer> res = new ArrayList<>();

		if (A == null || A.size() == 0)
			return res;

		if (A.size() == 1 && A.get(0) < 0)
			return res;

		while (end < A.size()) {
			if (A.get(end) >= 0) {
				start = end;
				sum = 0;

				while (end < A.size() && A.get(end) >= 0) {
					sum += A.get(end);
					end++;
				}
				end = end - 1;

				if ((sum > max_sum) || (sum == max_sum && end - start + 1 > res_end - res_start + 1)) {
					res_start = start;
					res_end = end;
					max_sum = sum;
				}
			}
			end++;
		}

		for (int index = res_start; index <= res_end; index++)
			res.add(A.get(index));

		return res;
	}

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(336465782);
		arr.add(-278722862);
		arr.add(-2145174067);
		arr.add(1101513929);
		arr.add(1315634022);
		arr.add(-1369133069);
		arr.add(1059961393);
		arr.add(628175011);
		arr.add(-1131176229);

		/*
		 * arr.add(-1); arr.add(-1); arr.add(2);
		 */
		List<Integer> res = maxset(arr);
		for (int index = 0; index < res.size() && !res.isEmpty(); index++)
			System.out.println(res.get(index));
	}
}
