package DPProgs;

public class DPEggFloors {
	
	/* Function to get minimum number of trials needed in worst 
	  case with n eggs and k floors */
	int eggDrop(int n, int k) 
	{ 
	    // If there are no floors, then no trials needed. OR if there is 
	    // one floor, one trial needed. 
	    if (k == 1 || k == 0) 
	        return k; 
	  
	    // We need k trials for one egg and k floors 
	    if (n == 1) 
	        return k; 
	  
	    int min = Integer.MAX_VALUE, x, res; 
	  
	    // Consider all droppings from 1st floor to kth floor and 
	    // return the minimum of these values plus 1. 
	    for (x = 1; x <= k; x++) 
	    { 
	        res = Math.max(eggDrop(n-1, x-1), eggDrop(n, k-x)); 
	        if (res < min) 
	            min = res; 
	    } 
	  
	    return min + 1; 
	} 

	public int getDrops(int eggs, int floors) {

		int[][] eggDrops = new int[eggs + 1][floors + 1];
		// base case 1:
		// if floors = 0 then no drops are required // OR floors = 1 then 1 drop is
		// required
		for (int i = 1; i <= eggs; i++) {
			eggDrops[i][0] = 0;
			eggDrops[i][1] = 1;
		}
		// base case 2:
		// if only one egg is there then drops = floors
		for (int i = 1; i <= floors; i++) {
			eggDrops[1][i] = i;
		}

		for (int i = 2; i <= eggs; i++) {
			for (int j = 2; j <= floors; j++) {
				eggDrops[i][j] = Integer.MAX_VALUE;
				int tempResult;
				for (int k = 1; k <= j; k++) {
					tempResult = 1 + Math.max(eggDrops[i - 1][k - 1], eggDrops[i][j - k]);
					eggDrops[i][j] = Math.min(tempResult, eggDrops[i][j]);
				}
			}
		}
		// eggDrops[eggs][floors] will have the result : minimum number of drops
		// required in worst case
		return eggDrops[eggs][floors];
	}

	public static void main(String[] args) {
		DPEggFloors eggDP = new DPEggFloors();
		int eggs = 2;
		int floors = 6;
		System.out.print(eggDP.getDrops(eggs, floors));
	}
}
