package test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class DictWordTransformation {

	public int ladderLength(String start, String end, Set<String> dict) {
		if (start == null || end == null || dict == null || dict.size() == 0) {
			return 0;
		}

		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		dict.remove(start);
		int length = 0;

		while (!queue.isEmpty()) {

			String current = queue.poll();
			for (int j = 0; j < current.length(); j++) {
				for (char c = 'a'; c <= 'z'; c++) {
					if (c == current.charAt(j)) {
						continue;
					}

					String temp = replace(current, j, c);

					if (temp.equals(end)) {
						return length + 1;
					}

					if (dict.contains(temp)) {
						queue.offer(temp);
						dict.remove(temp);
					}
				}
			}
			length++;
		}
		return 0;
	}

	private String replace(String s, int index, char c) {
		char[] chars = s.toCharArray();
		chars[index] = c;
		return new String(chars);

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.printf("Please specify how many lines you want to enter: ");
		Set<String> input = new HashSet<>();
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			input.add(in.next());
		}
		System.out.println(input);
		 System.out.println(new DictWordTransformation().ladderLength("cat", "dog", input));

	}
}