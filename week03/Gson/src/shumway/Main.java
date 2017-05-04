package shumway;

public class Main {

    public static void main(String[] args) {
      Player victor = new Player("Ragnar", 50, 150, 100);
      victor.display();
      Game duces = new Game(victor);

      duces.saveGame();
      duces.loadGame("playerData.json");

      victor.addEquipment("Sword", 10);
      victor.addEquipment("Shield", 20);
      victor.addEquipment("Dagger", 15);
      victor.addEquipment("Helmet", 12);

      duces.saveGame();
      duces.loadGame("playerData.json");
    }
}
