/*
 * Given a digit string, return all possible letter combinations that the number 
 * 
 * could represent.

   A mapping of digit to letters (just like on the telephone buttons) is given below.
   
   Input:Digit string "23"

   Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * */


import java.util.ArrayList;
import java.util.HashMap;


public class LetterComOfPhoneNo {

	public static ArrayList<String> letterCombinations(String digits) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        HashMap<String, String> digit = new HashMap<String, String>();
        digit.put("1", "");
        digit.put("2", "abc");
        digit.put("3", "def");
        digit.put("4", "ghi");
        digit.put("5", "jkl");
        digit.put("6", "mno");
        digit.put("7", "pqrs");
        digit.put("8", "tuv");
        digit.put("9", "wxyz");
        digit.put("0", "");
        
        ArrayList<String> ans = new ArrayList<String>();
        if(digits.length() == 0){
        	ans.add("");
        }
        else if(digits.length() == 1) {
        	for(char c : digit.get(digits).toCharArray()){
        		ans.add(Character.toString(c));
        	}
        }else{
        	ArrayList<String> returned = letterCombinations(digits.substring(1));
        	for(char c : digit.get(digits.substring(0, 1)).toCharArray()){
        		for(String s : returned){
        			ans.add(Character.toString(c) + s );
        		}
        	}
        }
           
        return ans;
        		
    }
}
