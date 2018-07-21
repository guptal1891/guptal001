package towerResearch;

public class FlowerBouquet {

	public static int flowerBouquets(int p, int q, String s) {
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if(i>0)
                arr[i] = arr[i-1];
            if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                int pre = i - 2 >= 0 ? arr[i - 2] : 0;
                arr[i] = (pre + q > arr[i - 1]) ? pre + q : arr[i - 1];
            }

            if (i > 1 && s.charAt(i) == '0' && s.charAt(i) == s.charAt(i - 1)
                    && s.charAt(i - 1) == s.charAt(i - 2)) {
                int pre = i - 3 >= 0 ? arr[i - 3] : 0;
                arr[i] = (pre + p > arr[i]) ? pre + p : arr[i];
            }
        }

        return arr[s.length()-1];
    }
	
	public static void main(String[] s) {
		
		System.out.print(flowerBouquets(2,3, "00010001"));
	}
}
