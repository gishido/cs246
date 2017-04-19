package shumway;

import java.util.Scanner; //needed for Scanner/input

public class CircleCalculator {

    //creating shared Scanner input
    private static Scanner scanner = new Scanner(System.in);

    public double getRadius() {
        //prompt user
        System.out.println("Enter a Radius: ");
        //get input
        double myRadius = scanner.nextDouble();
        //return to calling program
        return myRadius;
    }

    public void displayCircumference(double myRadius) {
        //calculate circumference
        double circumference = Math.PI * 2 * myRadius;
        //display
        System.out.format("\tCircumference: %.2f\n", circumference);
    }

    public void displayArea(double myRadius) {
        //calculate area
        double area = Math.PI * (myRadius * myRadius);
        //display
        System.out.format("\tArea: %.2f\n", area);

    }

    public static void main(String[] args) {
        CircleCalculator calc = new CircleCalculator();
        //gets the radius for the user and then uses it
        // in other parts of the program
        double radVal = calc.getRadius();
        //calculate circumference
        calc.displayCircumference(radVal);
        //calculate area
        calc.displayArea(radVal);
    }
}