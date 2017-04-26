package shumway;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class VacationCalculator {

    public static void main(String[] args) {
        VacationCalculator vc = new VacationCalculator();

        float mexCost = vc.calculateVacationCost(Destination.Mexico);
        float euroCost = vc.calculateVacationCost(Destination.Europe);
        float japanCost = vc.calculateVacationCost(Destination.Japan);

       System.out.format("The cost to travel to Mexico is: $%.2f\n", mexCost);
       System.out.format("The cost to travel to Europe is: $%.2f\n", euroCost);
        System.out.format("The cost to travel to Japan is: $%.2f\n", japanCost);

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
