/*
 * Determine whether an integer is a palindrome. Do this without extra space.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", 

you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
 * */


public class PalindromeNumber {

	public static boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(x < 0) return false;
		if(x >= 0 && x <= 9) return true;
		String value = Integer.toString(x);
		int l = value.length();
		int mid = l/2;
		int count = 1;
		if(l % 2 == 0){
			while(value.charAt(mid - count) == value.charAt(mid + count - 1)){
				count++;
				if(mid - count < 0 || mid + count - 1 >= l){
					break;
				}
			} 
		}else{
			while(value.charAt(mid - count) == value.charAt(mid + count)){
				count++;
				if(mid - count < 0 || mid + count >= l){
					break;
				}
			}			
		}
		return (count == mid + 1);
    }
}
