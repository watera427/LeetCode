
public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] A) {
		
		if(A.length == 0) return 0;
		if(A.length == 1) return 1;
        
		int ans = A.length;
		
		//first find the length
		for(int i = 0; i < A.length - 1; i++){
			if(A[i] == A[i+1]){
				ans--;
			}
		}
			
		
		for(int i = 0; i < A.length - 1; i++){
			// finding the next different component
			int j = i + 1;
			while(A[j] == A[i] ){
				j++;
				if(j == A.length){ // reach the end of array
					return ans;
				}
			}// copy the elements
			for(int start = i + 1; start < j; start++){
				A[start] = A[j];
			}
		}
		
		return ans;        
    }

}
