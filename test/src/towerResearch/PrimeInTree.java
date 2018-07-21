package towerResearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PrimeInTree {

	static class Node {
		int v;
		int id;
		Node left;
		Node right;

		Node(int value, int id) {
			v = value;
			this.id = id;
		}
		
		public String toString() {
			return "[ "+ id + " , " + v+ " ]" ;
		}
	}

	

	private static int countPrime(Node node, HashMap<Integer, Integer> map) {
		if(node!=null) {
			int leftCount = countPrime(node.left, map);
			int rightCount = countPrime(node.right, map);
			int ans = leftCount + rightCount;
			if(isPrime(node.v))ans++;
			map.put(node.id, ans);
			return ans;
		}
		return 0;
	}

	public static boolean isPrime(int n) {  
	       if (n <= 1) {  
	           return false;  
	       }  
	       for (int i = 2; i < n; i++) {  
	           if (n % i == 0) {  
	               return false;  
	           }  
	       }  
	       return true;  
	 } 

	private static void connect(Node[] nodes, int x, int y) {
		
		if(nodes[x].left == null) nodes[x].left = nodes[y];
		else nodes[x].right = nodes[y];
	}
	
	static List<Integer> primeQuery(int n, List<Integer> u, List<Integer> v, List<Integer> values,
			List<Integer> queries) {
       
		 Node[] nodes = new Node[n+1];
		for(int i=1;i<=values.size();i++) {
			nodes[i] = new Node(values.get(i-1),i);
		}
		for(int i=0 ; i<n-1; i++) {
			connect(nodes, Math.min(u.get(i), v.get(i)), Math.max(u.get(i), v.get(i)));
		}
		
		preOrder(nodes[1]);
		System.out.println();
		inOrder(nodes[1]);
		System.out.println();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		countPrime(nodes[1], map);
		System.out.println(map);
		List<Integer> ans = new ArrayList<>();
		for(int q : queries) {
			ans.add(map.get(q));
		}
		return ans;
	}
	private static void preOrder(Node node) {
		if(node!=null) {
			System.out.println(node);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	private static void inOrder(Node node) {
		if(node!=null) {
			inOrder(node.left);
			System.out.println(node);
			inOrder(node.right);
		}
	}

	//65122135245366226543514562
	//4 	1	0	1	2
	public static void main(String args[]) {
		int n = 6;
		List<Integer> u = Arrays.asList(1,2,2,1,3);
		List<Integer> v = Arrays.asList(2,4,5,3,6);
		List<Integer> values = Arrays.asList(2,2,6,5,4,3);
		List<Integer> queries = Arrays.asList(1,4,5,6,2);
		System.out.println(primeQuery(n, u, v, values, queries));
		
		System.out.println(isPrime(4));
		
	}

}
