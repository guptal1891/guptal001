package swiggy;

import java.util.ArrayList;
import java.util.List;

public class Swiigy2 {
	static List<Integer> connectedCities(int n, int threshold, List<Integer> originCities, List<Integer> destinationCities) {
        Graph g = new Graph(n+1);
        
        for(int i=1;i<=n;i++) {
        	for(int j=i+1;j<=n;j++) {
        		if(gcd(i,j)>threshold) {
        			g.connect(i, j);
        		}
        	}
        }
        
        g.connectedComponent();
        
        int ans[] = new int[originCities.size()];
        for(int  i=0;i<originCities.size();i++) {
        	if(g.connected(originCities.get(i), destinationCities.get(i))) {


        		ans[i]=1;
        	}else {
        		ans[i]=0;
        	}
        }
        List<Integer> answerList = new ArrayList<>();
        for(int i=0;i<ans.length;i++)answerList.add(ans[i]);
		return answerList;
    }
	
	
	static int gcd(int a, int b) {
		if(b==0)return a;
		return gcd(b,a%b);
	}
	
	private static class Graph {

		private int n = 0;
		public ArrayList<Integer>[] vertex;
		
		private boolean[] marked;
		private int[] id; 
		private int count; 
		
		@SuppressWarnings("unchecked")
		Graph(int n){
			this.n = n;
			ArrayList<Integer>[] vertex = (ArrayList<Integer>[])new ArrayList[n];
			marked = new boolean[n];
			id = new int[n];
			
			
			for(int i=0;i<n;i++)vertex[i]=new ArrayList<>();
			
			
			
		}
		
		public void connect(int v, int w) {
			vertex[v].add(w);
			vertex[w].add(v);
		}
		public void connectedComponent() {
			for (int v = 0; v < n; v++) {
	            if (!marked[v]) {
	                dfs(v);
	                count++;
	            }
	        }
		}
		
		private void dfs( int v) {
	        marked[v] = true;
	        id[v] = count;
	        for (int w : vertex[v]) {
	            if (!marked[w]) {
	                dfs(w);
	            }
	        }
	    }
		
		public int id(int v) {
	        return id[v];
	    }
		
		public boolean connected(int v, int w) {
			return id(v) == id(w);
		}

	}
}
