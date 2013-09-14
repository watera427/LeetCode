/*The string "PAYPALISHIRING" is written in a zigzag pattern on 
 * a given number of rows like this: (you may want to display 
 * this pattern in a fixed font for better legibility)
 * P   A   H   N
	A P L S I I G
	Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	Write the code that will take a string and make this conversion given a number of rows:
	string convert(string text, int nRows);
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */




public class ZigZagConversion {

	public static String convert(String s, int nRows) {
		if(s == "") return "";
        int count = 2*nRows - 2;
        int l = s.length();
        if(l <= 1 || nRows <= 1) return s;
        int part = l/count;
        int extra = l%count;
        char[] charArray = s.toCharArray();
        String[] ans = new String[nRows];
        for (int i = 0; i < nRows; i++) {
            ans[i] = "";
        }
        for(int i = 0; i < nRows; i++){
        	for(int j = 1; j <= part; j++){
	        	if(i == 0){
	        		ans[i] = ans[i] + charArray[count*(j - 1)];
	        	}else if(i == nRows - 1){
	        		ans[i] = ans[i] + charArray[nRows - 1 + count*(j - 1)];
	        	}else{
	        		ans[i] = ans[i] + charArray[nRows - 1 + count*(j - 1) - nRows + i + 1] + charArray[nRows - 1 + count*(j - 1) + nRows - i - 1];
	        	}
        	}
        }
        for(int i = 0; i < extra; i++){
        	if(i < nRows)
        		ans[i] = ans[i] + charArray[count*part + i];
        	else
        		ans[2*nRows - i - 2] = ans[2*nRows - i - 2] + charArray[count*part + i];
        }
        
        String final_ans = "";
        for(int i = 0; i < nRows; i++){
        	final_ans += (String)ans[i];
        }
        return final_ans;
    }
}
