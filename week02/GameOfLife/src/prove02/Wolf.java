package prove02;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

/**
 * Created by thesh on 4/28/2017.
 */
public class Wolf extends Creature implements Movable, Aware, Aggressor, Spawner  {
  Random _rand;
  boolean canSpawn = false;
  int direction;

  public Wolf() {
    _rand = new Random();
    direction = _rand.nextInt(4);
    _health = 1;
  }

  public boolean isCanSpawn() { return canSpawn;}
  public void setCanSpawn(boolean trueFalse) {canSpawn = trueFalse;}

  public void attack(Creature target) {
    // Wolves only follow and attach animals. Wolves inflict 5 damage
    if(target instanceof Animal) {
      target.takeDamage(5);
      canSpawn = true;
    }
  }


  public void move() {

      // Choose a random direction each time move() is called.
      switch (direction) {
        case 0: //right
          _location.x++;
          break;
        case 1: //left
          _location.x--;
          break;
        case 2: //down
          _location.y++;
          break;
        case 3: //up
          _location.y--;
          break;
        default:
          break;
      }
  }

  public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {
      switch (direction) {
        case 3: //current direction is up
          if (above instanceof Animal) {
            direction = 3;
          } else if (right instanceof Animal) {
            direction = 0;
          } else if (below instanceof Animal) {
            direction = 2;
          } else if (left instanceof Animal) {
            direction = 1;
          }
          break;
        case 0 : //current direction is right
          if (right instanceof Animal) {
            direction = 0;
          } else if (below instanceof Animal) {
            direction = 2;
          } else if (left instanceof Animal) {
            direction = 1;
          } else if (above instanceof Animal) {
            direction = 3;
          }
          break;
        case 2 : //current direction is down
          if (below instanceof Animal) {
            direction = 2;
          } else if (left instanceof Animal) {
            direction = 1;
          } else if (above instanceof Animal) {
            direction = 3;
          } else if (right instanceof Animal) {
            direction = 0;
          }
          break;
        case 1 : //current direction is left
          if (left instanceof Animal) {
              direction = 1;
          } else if (above instanceof Animal) {
            direction = 3;
          } else if (right instanceof Animal) {
            direction = 0;
          } else if (below instanceof Animal) {
            direction = 2;
          }
          break;
        default:
          direction = _rand.nextInt(4);
      }
  }

  public Creature spawnNewCreature() {
    if(canSpawn) {
      //if the wolf can spawn, creates baby

      //get parent current position
      Point currP = (Point)getLocation().clone();
      //create baby
      Wolf wBaby = new Wolf();
      //set baby location to the left of parent
      currP.x += -1;
      wBaby.setLocation(currP);

      //disable ability for parent to spawn again until another kill
      canSpawn = false;

      //return the baby wolf
      return wBaby;
     }
    // returns null if the wolf can't spawn
    return null;
  }

  public Color getColor() {
    return new Color(128, 128, 128);
  }

  public Boolean isAlive() {
    return _health > 0;
  }

  public Shape getShape() {
    return Shape.Square;
  }
}
