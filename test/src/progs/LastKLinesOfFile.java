package progs;

import java.io.IOException;
import java.io.RandomAccessFile;

public class LastKLinesOfFile {

	public static void main(String[] args) throws IOException {

		int n = 5;
		int currentPos = 1;
		int index = 0;
		RandomAccessFile file = new RandomAccessFile("C:\\Users\\gupta\\eclipse-workspace\\test\\src\\test\\abc.txt",
				"r");
		long endPos = file.length();
		file.seek(endPos);
		while (index < n) {
			if ((char) file.read() == '\n') {
				index++;
			} else {
				file.seek(endPos - currentPos);
				currentPos++;
			}
		}
		String s;
		while ((s = file.readLine()) != null) {
			System.out.println(s);
		}

	}

}
