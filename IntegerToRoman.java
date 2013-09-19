/* Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.*/ 



public class IntegerToRoman {

	public static String intToRoman(int num) {
        String[] rep = {"I", "IV", "V", "IX", "X", "XL", "L","XC","C","CD","D","CM","M"};
        int[] cons = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        int count = 12;
        String ans = "";
        while(num >= 1){
        	if(num >= cons[count]){
        		ans += rep[count];
        		num -= cons[count];
        	}else{
        		count--;
        	}
        }
        return ans;
    }
}
