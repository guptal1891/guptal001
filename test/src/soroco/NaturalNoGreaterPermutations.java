package soroco;

import java.util.LinkedList;
import java.util.Queue;

// Time complexity O(k),  k = no of such permutation (answer)
public class NaturalNoGreaterPermutations {

	public static void main(String[] args) {
		NaturalNoGreaterPermutations obj = new NaturalNoGreaterPermutations();
		int n = 888;
		int total = obj.countAll(n);
		System.out.println("Total No : " + total);
	}

	int countAll(int num) {
		// All single digit numbers are candidates
		if (num <= 9) {
			return num;
		}

		Queue<Integer> queue = new LinkedList<>();
		// initialize queue
		for (int i = 1; i <= 9; i++) {
			queue.add(i);
		}

		int count = 0;
		// loop will break when we generate no which is greater than n
		while (true) {
			int current = queue.remove();
			if (current > num) {
				break;
			}
			count++;
			for (int i = current % 10; i <= 9; i++) {
				int newNo = current * 10 + i;
				queue.add(newNo);
			}
		}
		return count;
	}

}
