package shumway;

/**
 * Created by thesh on 4/25/2017.
 */
public class Lodging implements Expense {

  float mexCost = 100;
  float euroCost = 200;
  float japCost = 300;
  double euroTax = 1.10;
  double japTax = 1.30;
  Destination myDest;
  int myStay;

  public Lodging (Destination dest, int numDays){
    myDest = dest;
    myStay = numDays;
  }

  public float getCost() {

    switch (myDest) {
      case Mexico:
        return mexCost * myStay;
      case Europe:
        euroCost = (euroCost * myStay)* (float)euroTax;
        return euroCost;
      case Japan:
        japCost = (japCost * myStay) * (float)japTax;
        return japCost;
      default:
        return 0;
    }
  }

}
