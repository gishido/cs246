package shumway;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
      Player victor = new Player("Ragnar", 50, 50, 100);
      Game duces = new Game(victor);

      duces.saveGame();
    }
}
