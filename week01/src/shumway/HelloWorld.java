package shumway;

public class HelloWorld {

    public static void main(String[] args) {
	    //creating an instance of the class and calling sayHello function
        new HelloWorld().sayHello();
    }

    public void sayHello() {
        //Hello World using println() function
        System.out.println("Hello World!");
    }
}

public class CircleCalculator {

    public float getRadius() {
        float myRadius = 0;

        return myRadius;
    }

    public void displayCircumference(float myRadius) {
        //print circumference displaying by 2 decimal places
        System.out.println("Nothing yet to see here!");
    }

    public void displayArea(float myRadius) {
        //pint either area or circumference, I'm not sure
        //  , by 2 decimal places
        System.out.println("Nothing to see here either!");
    }

    public static void main(String[] args) {
        CircleCalculator calc = new CircleCalculator();
        //gets the redius for the user and then uses it
        // in other parts of the program
        float radVal = calc.getRadius();
        calc.displayArea(radVal);
        calc.displayCircumference(radVal);
    }
}