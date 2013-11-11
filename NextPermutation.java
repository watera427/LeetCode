/*
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

Solutions:

1。 From right to left, find the first digit (PartitionNumber) which violate the 
increase trend.
2. If PartitionNumber is the right end, then just switch it with its previous one
3. If PartitionNumber is the left end, then return the array in reverse order
4. Otherwise, from right to left, find the first digit which is larger than 
PartitionNumber, call it changeNumber
5. Swap ParitionNumber and changeNumber
6. Reverse all the digit on the right of partition index

 */


public class NextPermutation {

	public static void nextPermutation(int[] num) {
		 
	    if(num.length == 0 || num.length == 1) return;
	    
	    int PartitionNum = -1;
	    int changeNum = 0;
	    
	    for(int i = num.length - 1; i >= 1; i--){
	    	if(num[i] > num[i-1]){
	    		PartitionNum = i-1;
	    		break;
	    	}
	    }
	    
	    if(PartitionNum == -1){//left end
	    	for(int i = 0; i <= num.length/2 - 1; i++){
				int tmp = num[i];
				num[i] = num[num.length - 1 - i];
				num[num.length - 1 - i] = tmp; 
			}
	    }else if(PartitionNum == num.length - 1){//right end
	    	int tmp = num[PartitionNum];
	    	num[PartitionNum] = num[PartitionNum - 1];
	    	num[PartitionNum - 1] = tmp;
	    }else{
	    	for(int i = num.length - 1; i > PartitionNum; i--){
		    	if(num[i] > num[PartitionNum]){
		    		changeNum = i;
		    		break;
		    	}
		    }
	    	int tmp = num[changeNum];
	    	num[changeNum] = num[PartitionNum];
	    	num[PartitionNum] = tmp;
	    	
	    	int newStart = PartitionNum + 1;
	    	int newLength = num.length - newStart;
	    	for(int i = 0; i <= newLength/2 - 1; i++){
				tmp = num[i + newStart];
				num[i + newStart] = num[newLength - 1 - i + newStart];
				num[newLength - 1 - i + newStart] = tmp; 
			}
	    }
	    return;
	}
	
	/*public void Reverse(int[] x){
		for(int i = 0; i <= x.length/2 - 1; i++){
			int tmp = x[i];
			x[i] = x[x.length - 1 - i];
			x[x.length - 1 - i] = tmp; 
		}
		return;
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = {6,8,7,4,3,2};
		nextPermutation(x);
	}

}
