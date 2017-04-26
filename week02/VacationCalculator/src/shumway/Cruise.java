package shumway;

import static shumway.Destination.Europe;
import static shumway.Destination.Japan;
import static shumway.Destination.Mexico;

/**
 * Created by thesh on 4/25/2017.
 */
public class Cruise implements Expense{

  float mexCost = 1000;
  float euroCost = 2000;
  float japCost = 3000;

  public Cruise (Destination dest) {
    float cost = getCost(dest);
  }

  public float getCost(Destination theDest) {

    switch (theDest) {
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