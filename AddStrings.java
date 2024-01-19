class Solution {

    String reverse(String s) {
        int low = 0;
        int high = s.length() - 1;
        char[] str = s.toCharArray();
        while (low < high) {
            char ch = str[low];
            str[low] = str[high];
            str[high] = ch;

            low++;
            high--;
        }

        return new String(str);
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        String res = "";
        int carry = 0;

        while (i >= 0 && j >= 0) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(j) - '0';

            int sum = n1 + n2 + carry;    
            int digit = sum % 10;
            res += digit;
            carry = sum / 10;
            i--;
            j--;
        }

        while (i >= 0) {  
            int val = num1.charAt(i) - '0';
            int sum = val + carry;
            int digit = sum % 10;
            res += digit;
            carry = sum / 10;
            i--;
        }

        while (j >= 0) {
            int val = num2.charAt(j) - '0';
            
            int sum = val + carry;
            int digit = sum % 10;
            res += digit;
            carry = sum / 10;
            j--;
        }

        if (carry > 0) res += carry;

        return reverse(res);

    }
}
