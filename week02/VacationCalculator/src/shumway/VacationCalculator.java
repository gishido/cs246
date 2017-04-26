package shumway;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class VacationCalculator {

    public static void main(String[] args) {
        VacationCalculator vc = new VacationCalculator();

        float japanCost = vc.calculateVacationCost(Destination.Japan);

        System.out.println("The cost to Japan is: " + japanCost);

    }

    public float calculateVacationCost(Destination dest)
    {
      Destination currDest = dest;
      List<Expense> expenses = new ArrayList();
      Cruise newCruise = new Cruise(currDest);

      expenses.add(newCruise);

      float cost = tallyExpenses(expenses);

      return cost;
    }

    float tallyExpenses(List<Expense> expenses)
    {
      float tally = 0;

      for (int i = 0; i < expenses.size(); i++)
      {
        tally += expenses.get(i).getCost();
      }
      return tally;
    }
}
