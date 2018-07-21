package towerResearch;

import java.util.Arrays;

public class ScoresCountInRange {

	static int lowerIndex(int arr[], int n, int x) {
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] >= x)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
	}

	// function to find last index <= y
	static int upperIndex(int arr[], int n, int y) {
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] <= y)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return high;
	}

	// function to count elements within given range
	static int countInRange(int arr[], int n, int low, int high) {
		// initialize result
		int count = 0;
		count = upperIndex(arr, n, high) - lowerIndex(arr, n, low) + 1;
		return count;
	}
	
	static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {

		int n = scores.length;
		int q = upperLimits.length;
		 Arrays.sort(scores);
        int ans[] = new int[q];
        for(int i=0;i<q;i++) {
        	ans[i]=countInRange(scores, n, lowerLimits[i], upperLimits[i]);
        }
        
        return ans;
    }
//4	1 0 1 2
	public static void main(String[] args) {
		int s[] = {4,8,7};
		int l[] = {2,4};
		int u[] = {8,4};
		int a[] = jobOffers(s, l, u);
		for(int x:a)System.out.println(x);

	}

}
