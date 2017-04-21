package shumway;

import java.util.Scanner;

import static shumway.NSALoginController.hashUserPassword;
import static shumway.NSALoginController.verifyPassword;

public class Test {

    String password;

    public static Scanner myScans = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter a password: ");
        password = myScans.next();

        User user = new User(password);

        System.out.print("Before Hash:");
        System.out.print("\tPassword: " + user.getPassword());
        System.out.print("\tSalt: " + user.getSalt());
        System.out.print("\tHash: " + user.getHashedPassword());

        try {
            hashUserPassword(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("After Hash:");
        System.out.print("\tPassword: " + user.getPassword());
        System.out.print("\tSalt: " + user.getSalt());
        System.out.print("\tHash: " + user.getHashedPassword());

        System.out.print("Enter a password for verification: ");
        password = myScans.next();

        User verify = new User(password);

        try {
            verifyPassword(verify);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
