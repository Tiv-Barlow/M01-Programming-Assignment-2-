//SDEV 200 - Software Development Using Java
//Professor Adam Bumgardner
//Student: Tiv Muhammad
//24 Mar 2024
// Assignment: Mod1 Programming Assignment (2) 6.31
/*-------------------------------------------------------*/

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an entire credit card number as a long.  Use numercial digits only.  No spaces: ");
    long creditCardNumber = input.nextLong();
    input.nextLine(); // Consume the newline character
    if (isValid(creditCardNumber)) {
      System.out.println(creditCardNumber + " is valid");
    } else {
      System.out.println(creditCardNumber + " is invalid");
    }
    input.close();
  }

  // Function will return "TRUE" if the card # is valid.
  public static boolean isValid(long number) {
    int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
    return sum % 10 == 0;
  }

  // Function will retreive result from last step
  public static int sumOfDoubleEvenPlace(long number) {
    int sum = 0;
    String num = Long.toString(number);

    for (int i = num.length() - 2; i >= 0; i -= 2) {
      int digit = Character.getNumericValue(num.charAt(i));
      sum += getDigit(digit * 2);
    }

    return sum;
  }

  // Function will return number IF it is a single digit. Else, the number
  // returned will be the sum of the 2 digits.
  public static int getDigit(int number) {
    if (number < 10) {
      return number;
    } else {
      return number / 10 + number % 10;
    }
  }

  // Function will return sum of odd-place digits in CC #.
  public static int sumOfOddPlace(long number) {
    int sum = 0;
    String num = Long.toString(number);

    for (int i = num.length() - 1; i >= 0; i -= 2) {
      int digit = Character.getNumericValue(num.charAt(i));
      sum += digit;
    }

    return sum;
  }

  // Function will return TRUE if the # "d" is a prefix for #.
  public static boolean prefixMatched(long number, int d) {
    return getPrefix(number, getSize(d)) == d;
  }

  // Function will return the # of digits in "d".
  public static int getSize(long d) {
    return Long.toString(d).length();
  }

  // Function will return the first k # of digits from number. If the # of digits
  // in # is > k, The # will be returned.
  public static long getPrefix(long number, int k) {
    if (getSize(number) > k) {
      String num = Long.toString(number);
      return Long.parseLong(num.substring(0, k));
    }
    return number;
  }
}
