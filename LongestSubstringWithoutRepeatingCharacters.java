/*
 * Given a string, find the length of the longest substring 
 * without repeating characters. For example, the longest 
 * substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is 
 * "b", with the length of 1.
 * */


import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		HashSet set = new HashSet();
		int longest = 0;
		int start = 0;
		char[] cha = s.toCharArray();
        for(char c : cha){
        	if(! set.contains(c)){
        		set.add(c);
        	}else{
        		int tmp = set.size();
        		longest = Math.max(longest, tmp);
        		while(set.contains(c)){
        			set.remove(cha[start++]);
        		}
        		set.add(c);
        	}
        }
        return Math.max(longest, set.size());
    }
}
