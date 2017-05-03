package shumway;

/**
 * Created by thesh on 5/2/2017.
 */
public class Game {
  Player thePlayer;
  String fileName;

  public Game(Player myPlayer) {
    thePlayer = myPlayer;
  }

  public void saveGame() {
    //TODO should use GSON to deserialize an object and write to a file
  }

  public static Game loadGame(String fileName) {

    //TODO: this will need to read from a file and create a new game
    return null;
  }
}
