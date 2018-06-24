package test;

import java.util.function.LongToIntFunction;

public class StringProg {

	public static void main(String args[]) {

		System.out.println(compareVersion("234353543", "4.83"));
	}

	public static int compareVersion(String A, String B) {

		if (A.length() != 0 && B.length() != 0) {
			while (A.length() != 0 && B.length() != 0) {

				String a = A.contains(".") ? A.substring(0, A.indexOf(".")) : A;
				String b = B.contains(".") ? B.substring(0, B.indexOf(".")) : B;

				if (Long.valueOf(a) > Long.valueOf(b))
					return 1;
				else if (Long.valueOf(a) < Long.valueOf(b))
					return -1;
				else if(a.equals(A) && b.equals(B))
					return 0;

				A = A.replace(a + ".", "");
				B = B.replace(b + ".", "");

				System.out.println(A + B);

			}
		}
		return 0;
	}
}