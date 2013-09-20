
/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 * */

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(strs.length == 0) return "";
    	String ans = strs[0];
    	for(int i = 1; i < strs.length; i++){
    		String s = strs[i];
    		ans = FindCommonPrefix(ans,s);
    	}
    	return ans;
    }
    
    public static String FindCommonPrefix(String s1, String s2){
    	if(s1.length() < s2.length()){
    		if(s2.substring(0, s1.length()) == s1){
    			return s1;
    		}else{
    			for(int i = 1; i < s1.length(); i++){
    				if(s1.charAt(i) != s2.charAt(i)){
    					return s1.substring(0, i);
    				}
    			}
    		}
    	}else{
    		if(s1.substring(0, s2.length()) == s2){
    			return s2;
    		}else{
    			for(int i = 1; i < s2.length(); i++){
    				if(s2.charAt(i) != s1.charAt(i)){
    					return s2.substring(0, i);
    				}
    			}
    		}
    	}
		return "";
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"c","c"};
		String tmp = longestCommonPrefix(s);
	}

}
