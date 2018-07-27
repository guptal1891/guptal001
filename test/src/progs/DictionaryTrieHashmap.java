package progs;

import java.util.HashMap;
import java.util.Map;

public class DictionaryTrieHashmap {

	static Node root;

	static class Node {

		int count;
		boolean endOfWord;
		Map<Character, Node> map;

		Node() {
			endOfWord = false;
			map = new HashMap<>();
		}
	}

	static void addWord(String word) {

		if (word.length() == 0)
			return;

		Node current = root;
		for (int i = 0; i < word.length(); i++) {

			if (i == word.length())
				current.endOfWord = true;

			char c = word.charAt(i);
			if (current.map.get(c) == null)
				current.map.put(c, new Node());

			current = current.map.get(c);
			current.count++;
		}

	}

	static int getWordCount(String str, Node root) {

		if (root == null)
			return 0;

		Node current = root;
		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);
			if (current.map.get(c) == null)
				return 0;
			current = current.map.get(c);

		}
		return current.count;
	}

	public static void main(String[] args) {

		root = new Node();
		addWord("hack");
		addWord("hacker");
		System.out.println(getWordCount("hack", root));
	}

}