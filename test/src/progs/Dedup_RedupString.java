package progs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Dedup_RedupString {

	public static String dedupe(String inputStr, int chunkSize) {
		int chunks = 0;
		StringBuilder dedup = new StringBuilder();
		for (int i = 0; i < inputStr.length();) {
			String str = inputStr.substring(i, i + chunkSize);
			if (dedup.indexOf(str) != -1) {
				int ind = dedup.indexOf(str);
				dedup.insert(dedup.indexOf(",", ind), "-" + chunks);
			} else {
				dedup.append(str + "-" + chunks + ",");
			}
			chunks++;
			i += chunkSize;
		}

		return dedup.toString();

	}

	public static String redupe(String inputStr, int chunkSize) {
		StringBuilder redup = new StringBuilder();

		Map<Integer, String> map = new TreeMap<>(); // used this to store keys in sorted order
		for (int i = 0; i < inputStr.length();) {
			String str = inputStr.substring(i, i + chunkSize);
			int endOfChunk = inputStr.indexOf(",", i + chunkSize);

			String indexStr = inputStr.substring(i + chunkSize, endOfChunk);
			indexStr = indexStr.startsWith("-") ? indexStr.substring(1) : indexStr;
			String[] strIndex = indexStr.split("-");
			List<Integer> intIndex = Arrays.asList(strIndex).stream().map(Integer::parseInt)
					.collect(Collectors.toList());
			intIndex.stream().forEach(u -> map.put(u, str));
			i = endOfChunk + 1;
		}
		map.entrySet().stream().forEach(u -> redup.append(u.getValue()));
		return redup.toString();
	}

	public static void main(String s[]) {

		System.out.println(dedupe("aaaaaaaabbbbccccbbbb", 4));
		System.out.println(redupe("aaaa-0-1,bbbb-2-4,cccc-3,", 4));
		System.out.println(Integer.SIZE);
	}
}
