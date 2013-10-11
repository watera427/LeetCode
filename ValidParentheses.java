/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * 
 * determine if the input string is valid.

	The brackets must close in the correct order, "()" and 
	
	"()[]{}" are all valid but "(]" and "([)]" are not.
 * */


import java.util.HashMap;
import java.util.Stack;



public class ValidParentheses {

	public static boolean isValid(String s) {
		
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        Stack<Character> cs = new Stack<Character>();		
        cs.push('a');
        for(char c : s.toCharArray()){
        	if(c == '(' || c == '[' || c == '{'){
        		cs.push(c);
        	}else if(c == ')' || c == ']' || c == '}'){
        		char tmp = cs.peek();
        		if(tmp != map.get(c)){
        			return false;
        		}else{
        			cs.pop();
        		}
        	}
        }
        
        return cs.size() == 1? true:false;
    }
}
