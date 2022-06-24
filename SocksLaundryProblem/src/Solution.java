import java.util.ArrayList;
import java.util.List;

class Solution {
	    public int solution(int K, int[] C, int[] D) {
	    	int count = 0;
	    	boolean ab = false;
	    	List<Integer> remainingClean = new ArrayList<>();

	    	List<Integer> cleanSocks = new ArrayList<>();
	    	for(int i=0; i<C.length;i++) {
	    		ab= false;
	    		for(int j = i+1; j<C.length;j++) {
	    			if(C[j]!=0) {
	    				if(C[i]==C[j]) {
		    				cleanSocks.add(C[i]);
		    				C[j] =0;
		    				ab=true;
		    				break;
		    			}
	    			}
	    			
	    		}
	    		if(!ab && C[i]!= 0) {
	    			remainingClean.add(C[i]);
	    		}
	    	}
	    	count=cleanSocks.size();

	    	for ( int i=0; i<D.length; i++) {
	    		if(null!= remainingClean && remainingClean.contains(D[i]) && K>0) {
	    			count+=1;
	    			K--;
	    			remainingClean.remove(Integer.valueOf(D[i]));
	    			D[i]=0;
	    		}
	    	}
	    	for(int i=0; i<D.length;i++) {
	    		if(D[i] != 0) {
	    			for(int j = i+1; j<D.length;j++) {
		    			if( D[j] != 0) {
		    				if(D[i]==D[j]&& K>=2) {
			    				count++;
			    				K-=2;
			    				D[j] =0;
			    				break;
			    			}
		    			}
		    			
		    		}
	    		}
	    	}
	    	
	    	
	    	return count;
	    	
	    }
	    
	    public static void main(String[] args) {

			// Test program
			// Can invoke with a variable number of arguments
	    	Solution sol = new Solution();
	    	
			int ans;
			try {
				int[] clean = {1,2,3,4,5,6,1,1,6,6,6};
				int[]dirty = {6,4,1,6,4,2,4,6,2,1};
				ans = sol.solution(6, clean, dirty);
				System.out.println(ans);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		   }
	}

