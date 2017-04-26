package shumway;

import sun.security.krb5.internal.crypto.Des;

/**
 * Created by thesh on 4/25/2017.
 */
public class Dining implements Expense {

  float mexCost = 10;
  float euroCost = 20;
  float japCost = 30;
  Destination myDest;
  int myStay;

  public Dining(Destination dest, int numDays) {
    myDest = dest;
    myStay = numDays;
  }

  public float getCost() {

    switch (myDest) {
      case Mexico:
        return mexCost *= myStay;
      case Europe:
        return euroCost *= myStay;
      case Japan:
        return japCost *= myStay;
      default:
        return 0;
    }
  }

}
