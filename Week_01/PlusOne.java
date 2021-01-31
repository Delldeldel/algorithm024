package com.wkx.demo;

public class PlusOne {
  public static void main(String[] args) {

  }

  public int[] plusOne(int[] digits) {
    int increase = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      if ((digits[i] + increase) / 10 > 0) {
        digits[i] = (digits[i] + 1) % 10;
        increase = 1;
      } else {
        digits[i] = digits[i] + increase;
        increase = 0;
      }
    }
    if (increase > 0) {
      int[] newDigits = new int[digits.length + 1];
      newDigits[0] = increase;
      for (int i = 1; i < newDigits.length; i++) {
        newDigits[i] = digits[i - 1];
      }
      return newDigits;
    }
    return digits;
  }

  /*  作者：yhhzw
  链接：https://leetcode-cn.com/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
  public int[] plusOneCnLeetCode(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i]++;
      digits[i] = digits[i] % 10;
      if (digits[i] != 0) return digits;
    }
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
  }

  public int[] plusOneLeetCode(int[] digits) {

    int n = digits.length;
    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }

    int[] newNumber = new int[n + 1];
    newNumber[0] = 1;

    return newNumber;
  }


}
