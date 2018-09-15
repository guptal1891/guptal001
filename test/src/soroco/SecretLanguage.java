package soroco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecretLanguage {

	static int compute_distinct_homonyms(List<String> secret_mapping, List<String> word_list) {

		List<String> result = new ArrayList<>();
		word_list.forEach(word -> {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < word.length(); i++) {
				sb.append(secret_mapping.get(word.charAt(i) - 'A'));
			}

			if (!result.contains(sb.toString()))
				result.add(sb.toString());
		});

		return result.size();
	}

	public static void main(String s[]) {

		System.out
				.println(compute_distinct_homonyms(
						Arrays.asList("B", "B", "D", "D", "F", "F", "F", "H", "J", "J", "L", "L", "N", "N", "P", "P",
								"R", "R", "T", "T", "V", "V", "X", "X", "Z", "Z"),
						Arrays.asList("FOOD", "GOOD", "ZAP", "YAP")));
	}
}
