package shumway;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by thesh on 5/2/2017.
 */
public class Player {

  String name;
  int health;
  int mana;
  int gold;
  Map<String, Integer> equipment;

  public Player (String myName, int myHealth, int myMana, int myGold) {
    name = myName;
    health = myHealth;
    mana = myMana;
    gold = myGold;

    this.equipment = new HashMap<>();
  }

  public String toString() {

    //TODO: not sure what I have to do here yet
    return null;
  }

  public void addEquipment(String item, int vitality) {
    equipment.put(item, vitality);
  }

  public void display() {
    System.out.println("Name: " + name + " Health: " + health + " Mana: " + mana + " Gold: " + gold + " EquipmentNum: " + equipment.size());
  }

}
