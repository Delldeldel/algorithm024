package com.wkx.demo.week4;

/**
 * 柠檬水找零
 */
public class LemonadeChange {
  public static void main(String[] args) {
    int[] bills = new int[]{5, 5, 10, 10, 20};
    LemonadeChange l = new LemonadeChange();
    System.out.println(l.lemonadeChange(bills));
  }

  public boolean lemonadeChange(int[] bills) {
    int count5 = 0, count10 = 0;
    for (int i = 0; i < bills.length; i++) {
      if (bills[i] == 5) {
        count5++;
      } else if (bills[i] == 10) {
        if (count5 == 0) {
          return false;
        } else {
          count5--;
          count10++;
        }
      } else if (bills[i] == 20) {
        if (count5 == 0 || (count10 == 0 && count5 < 3)) {
          return false;
        } else {
          if (count10 > 0) {
            count5--;
            count10--;
          } else {
            count5 -= 3;
          }

        }
      }
    }
    return true;
  }
}
