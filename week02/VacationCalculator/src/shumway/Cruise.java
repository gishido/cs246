package shumway;

/**
 * Created by thesh on 4/25/2017.
 */
public class Cruise implements Expense{

  float mexCost = 1000;
  float euroCost = 2000;
  float japCost = 3000;
  Destination myDest;

  public Cruise (Destination dest) {
    myDest = dest;
  }

  public float getCost() {

    switch (myDest) {
      case Mexico:
        return mexCost;
      case Europe:
        return euroCost;
      case Japan:
        return japCost;
      default:
        return 0;
    }
  }

}