package shumway;

/**
 * Created by thesh on 5/2/2017.
 */
public class Player {

  String name;
  int health;
  int mana;
  int gold;

  public Player (String myName, int myHealth, int myMana, int myGold) {

  }

  public String toString() {

    //TODO: not sure what I have to do here yet
    return null;
  }

  public void addEquipment(String hero, int vitality) {

  }

  private void display() {
    System.out.println("Name: " + name + " Health: " + health + " Mana: " + mana + " Gold: " + gold);
  }

}
