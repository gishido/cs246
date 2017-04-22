package shumway;

import java.util.Scanner;

import static shumway.NSALoginController.hashUserPassword;
import static shumway.NSALoginController.verifyPassword;

public class Test {

  String password;


  public static Scanner myScans = new Scanner(System.in);

  public static void main(String[] args) {
    boolean trueFalse;

    Test t = new Test();

    User user = new User(t.getPassFromUser());

    t.hash(user);

    user.setPassword((t.getPassFromUser()));

    //t.hash(verify);

    trueFalse = t.verify(user);

    if (trueFalse) {
      System.out.print("Passwords Match!");
    } else {
      System.out.print("Passwords Do NOT Match!");
    }
  }

  public String getPassFromUser() {
    System.out.print("Enter a password: ");
    password = myScans.next();

    return password;
  }

  public void hash(User user) {
    System.out.print("Before Hash:\n");
    System.out.print("\tPassword: " + user.getPassword() + "\n");
    System.out.print("\tSalt: " + user.getSalt() + "\n");
    System.out.print("\tHash: " + user.getHashedPassword() + "\n");

    try {
      hashUserPassword(user);
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.print("After Hash:" + "\n");
    System.out.print("\tPassword: " + user.getPassword() + "\n");
    System.out.print("\tSalt: " + user.getSalt() + "\n");
    System.out.print("\tHash: " + user.getHashedPassword() + "\n");
  }

  public boolean verify(User verify) {
    boolean trueFalse = false;

    try {
      trueFalse = verifyPassword(verify);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return trueFalse;
  }

}
