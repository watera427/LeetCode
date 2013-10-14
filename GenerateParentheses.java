/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

	For example, given n = 3, a solution set is:

	"((()))", "(()())", "(())()", "()(())", "()()()"
 * */



import java.util.ArrayList;
import java.util.Arrays;

public class GenerateParentheses {

	public static ArrayList<String> generateParenthesis(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		ArrayList<String> ans = new ArrayList<String>();
		helper(ans,new StringBuilder(),0,0,n);
		return ans;
    }
	
	public static void helper(ArrayList<String> ans, StringBuilder str, int l, int r, int total){
		if(l == total){
			char[] tmp = new char[l - r];
			Arrays.fill(tmp, ')');
			ans.add(str.append(tmp).toString());
			str.delete(str.length() - l + r, str.length());
			return;
		}
		
		if(r < l){ // append ')'
			str.append(')');
			helper(ans,str, l, r+1, total);
			str.deleteCharAt(str.length() - 1);
		}
		
		if(l < total){ // append '('
			str.append('(');
			helper(ans,str, l+1, r, total);
			str.deleteCharAt(str.length() - 1);
		}
	}
}
