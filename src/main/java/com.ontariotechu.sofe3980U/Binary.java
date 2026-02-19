package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 */
public class Binary
{
    private String number = "0";  // string containing the binary value '0' or '1'

    /**
     * Constructor that generates a binary object.
     */
    public Binary(String number) {
        if (number == null || number.isEmpty()) {
            this.number = "0";
            return;
        }

        // Validate the binary string
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch != '0' && ch != '1') {
                this.number = "0";
                return;
            }
        }

        // Remove leading zeros
        int beg;
        for (beg = 0; beg < number.length(); beg++) {
            if (number.charAt(beg) != '0') {
                break;
            }
        }

        this.number = (beg == number.length()) ? "0" : number.substring(beg);
    }

    /**
     * Return the binary value of the variable
     */
    public String getValue() {
        return this.number;
    }

    /**
     * Add two binary numbers
     */
    public static Binary add(Binary num1, Binary num2) {
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;
        int carry = 0;
        String num3 = "";

        while (ind1 >= 0 || ind2 >= 0 || carry != 0) {
            int sum = carry;

            if (ind1 >= 0) {
                sum += (num1.number.charAt(ind1) == '1') ? 1 : 0;
                ind1--;
            }
            if (ind2 >= 0) {
                sum += (num2.number.charAt(ind2) == '1') ? 1 : 0;
                ind2--;
            }

            carry = sum / 2;
            sum = sum % 2;
            num3 = ((sum == 0) ? "0" : "1") + num3;
        }

        return new Binary(num3);
    }

    /**
     * OR operation
     */
    public static Binary or(Binary num1, Binary num2) {
        String a = num1.number;
        String b = num2.number;

        int maxLength = Math.max(a.length(), b.length());
        a = String.format("%" + maxLength + "s", a).replace(' ', '0');
        b = String.format("%" + maxLength + "s", b).replace(' ', '0');

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            char bitA = a.charAt(i);
            char bitB = b.charAt(i);

            result.append((bitA == '1' || bitB == '1') ? '1' : '0');
        }

        return new Binary(result.toString());
    }

    /**
     * AND operation
     */
    public static Binary and(Binary num1, Binary num2) {
        String a = num1.number;
        String b = num2.number;

        int maxLength = Math.max(a.length(), b.length());
        a = String.format("%" + maxLength + "s", a).replace(' ', '0');
        b = String.format("%" + maxLength + "s", b).replace(' ', '0');

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            char bitA = a.charAt(i);
            char bitB = b.charAt(i);

            result.append((bitA == '1' && bitB == '1') ? '1' : '0');
        }

        return new Binary(result.toString());
    }

    /**
     * Multiply two binary numbers
     */
    public static Binary multiply(Binary num1, Binary num2) {
        Binary result = new Binary("0");
        String b = num2.number;

        for (int i = b.length() - 1; i >= 0; i--) {
            if (b.charAt(i) == '1') {
                String shifted = num1.number + "0".repeat(b.length() - 1 - i);
                result = Binary.add(result, new Binary(shifted));
            }
        }

        return result;
    }
}
