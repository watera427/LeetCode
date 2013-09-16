/*
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. 

If you want a challenge, please do not see below and ask 

yourself what are the possible input cases.

Notes: It is intended for this problem to be specified 

vaguely (ie, no given input specs). You are responsible

 to gather all the input requirements up front.

Requirements for atoi:

The function first discards as many whitespace characters 

as necessary until the first non-whitespace character is found. 

Then, starting from this character, takes an optional initial 

plus or minus sign followed by as many numerical digits as possible

, and interprets them as a numerical value.

The string can contain additional characters after those that

 form the integral number, which are ignored and have no effect 
 
 on the behavior of this function.

If the first sequence of non-whitespace characters in str is 

not a valid integral number, or if no such sequence exists because 

either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. 

If the correct value is out of the range of representable values, 

INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.*/

public class StringToInteger {

	public static int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(str == null || str.length() == 0) return 0;
		int start = 0;
		while(start < str.length() && str.charAt(start) == ' ' ){
			start++;
		}
		int end = str.length() - 1;
		while( end >= 0 && str.charAt(end) == ' '){
			end--;
		}
		String new_str = str.substring(start, end + 1);
		if(new_str.charAt(0) != '-' && new_str.charAt(0) != '+'){
			if(new_str.charAt(0) > '9' || new_str.charAt(0) < '0'){
				return 0;
			}
		}
		boolean flag;
		if(new_str.charAt(0) == '-' || new_str.charAt(0) == '+'){
			flag = new_str.charAt(0) == '+';
			start = 1;
		}else{
			flag = true;
			start = 0;
		}
		end = 1;
		while(end < new_str.length() && new_str.charAt(end) >= '0' && new_str.charAt(end) <= '9'){
			end++;
		}
		new_str = new_str.substring(start, end);
		if(new_str.length() > 0){
			Long ans = Long.parseLong(new_str);
			if(flag){
				return (int) Math.min(ans, Integer.MAX_VALUE);
			}else{
				return (int) Math.max(-ans, Integer.MIN_VALUE);
			}
		}
		else{
			return 0;
		}
		
    }	

}
