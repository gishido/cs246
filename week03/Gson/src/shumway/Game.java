package shumway;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


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
    Gson gson = new Gson();
    String playerJson = gson.toJson(thePlayer);

    //reference for writing a file
    //http://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("playerData.json"), StandardCharsets.UTF_8))) {
      writer.write(playerJson);
    }
    catch (IOException ex) {
      // Handle me
    }

  }

  public static Game loadGame(String fileName) {
    String fileData;
    Gson gson = new Gson();

    //Reference for reading from a file
    //http://stackoverflow.com/questions/326390/how-do-i-create-a-java-string-from-the-contents-of-a-file
    try {
      fileData = new String(Files.readAllBytes(Paths.get(fileName)));
      Player newPlayer = gson.fromJson(fileData,Player.class);

      newPlayer.display();
      Game newGame = new Game(newPlayer);

      return newGame;

    } catch (IOException e) {
      e.printStackTrace();
    }
    //TODO: this will need to read from a file and create a new game
    return null;
  }
}
