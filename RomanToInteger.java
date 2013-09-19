/*
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 * */

import java.util.Hashtable;


public class RomanToInteger {

	public static int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		String[] rep = {"I", "IV", "V", "IX", "X", "XL", "L","XC","C","CD","D","CM","M"};
        int[] cons = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
		Hashtable<String,Integer> pairs = new Hashtable<String,Integer>(cons.length);
		for(int i = 0; i < cons.length; i++){
			pairs.put(rep[i], cons[i]);
		}
		if(s == "") return 0;
		if(s.length() == 1) return pairs.get(s);
		int ans = 0;
		int start = 0;
		int end = start + 2;;
		while(end <= s.length()){
			String tmp = s.substring(start, end);
			if(pairs.containsKey(tmp)){
				ans += pairs.get(tmp);
				if(end <= s.length() - 2){
					start += 2;
					end += 2;
				}else{
					start += 2;
					end += 1;
				}
			}else{
				end -= 1;
				tmp = s.substring(start, end);
				if(pairs.containsKey(tmp)){
					ans += pairs.get(tmp);
					if(end <= s.length() - 2){
						start += 1;
						end += 2;
					}else{
						start += 1;
						end += 1;
					}
				}
			}
		}
        return ans;
    }
}
