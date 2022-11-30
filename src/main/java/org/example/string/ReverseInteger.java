package org.example.string;

public class ReverseInteger {

    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0, j = S.length() - 1; i < j;) {
            if (!Character.isLetter(sb.charAt(i))) {
                ++i;
            } else if (!Character.isLetter(sb.charAt(j))) {
                --j;
            } else {
                sb.setCharAt(i, S.charAt(j)); // leave them to normal position for number
                sb.setCharAt(j--, S.charAt(i++)); // pop and push the number

            }
        }
        return sb.toString();
    }

    public static String reverse(String x, StringBuilder data){
        if(x.isBlank()||x.length()==0)
            return data.toString();
        data.append(x.substring(x.length()-1));
        x =x.substring(0, x.length()-1);
        reverse(x,data);
        return data.toString();
    }
    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10; //x % 10 retrieve the decimal place
            x = x / 10; // cut off decimal place from original value
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }

    public static void main(String[] args) {
        int testData =3994842;
        System.out.println(reverse(testData));
        String strData ="Come";
        System.out.println(reverse(strData, new StringBuilder()));

    }
}
