/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 * 
 * which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
 * */
public class ContainerWithMostWater {

	public static int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(height.length == 0 || height == null) return 0;
		int start = 0;
		int end = height.length - 1;
		int area = 0;
		while(start < end){
			int tmp = Math.min(height[start], height[end]) * (end - start);
			if(tmp > area){
				area = tmp;
			}
			if(height[start] <= height[end]){
				start++;
			}else{
				end--;
			}			
		}
		return area;
    }
}
