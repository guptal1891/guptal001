package progs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddOneToArray {

	public static void main(String[] str) {
		List<Integer> A = new ArrayList<>();
		A.add(0);
		A.add(6);
		A.add(0);
		A.add(6);
		System.out.println(plusOne(A));
	}

	public static List<Integer> plusOne(List<Integer> A) {
		if (A.size() == 0)
			return A;

		int carry = 1;
		int index = A.size() - 1;

		while (index >= 0) {
			int a = A.get(index) + carry;
			carry = a / 10;
			if (a > 9) {
				a = a % 10;
			}

			A.set(index, a);
			index--;
		}
		if (carry > 0) {
			List<Integer> B = new ArrayList<>();
			;
			index++;
			B.add(carry);
			while (index < A.size()) {
				B.add(A.get(index));
				index++;
			}
			A = B;
		}
		
		index = 0;
		while(A.get(index).equals(0)){
		    A.remove(index);
		    index+= 2;
		}
		    
		return A;
	}
}
