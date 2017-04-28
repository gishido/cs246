package prove02;

import java.awt.Color;
import java.util.Random;

/**
 * Created by thesh on 4/28/2017.
 */
public class Wolf extends Creature implements Movable, Aware, Aggressor  {
  Random _rand;
  boolean isPreferred = true;

  public Wolf() {
    _rand = new Random();
    _health = 1;
  }

  public void attack(Creature target) {
    // Wolves only follow and attach animals. Wolves inflict 5 damage
    if(target instanceof Animal) {
      target.takeDamage(5);
    }
  }


  public void move() {

    if(isPreferred){
      // Choose a random direction each time move() is called.
      switch (_rand.nextInt(4)) {
        case 0:
          _location.x++;
          break;
        case 1:
          _location.x--;
          break;
        case 2:
          _location.y++;
          break;
        case 3:
          _location.y--;
          break;
        default:
          break;
      }
    }
  }

  public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {
    if(above instanceof Animal)
    {
      setLocation(above.getLocation());
      isPreferred = false;
    }
    else if(below instanceof Animal)
    {
      setLocation(below.getLocation());
      isPreferred = false;
    }
    else if(left instanceof Animal)
    {
      setLocation(left.getLocation());
      isPreferred = false;
    }
    else if(right instanceof Animal)
    {
      setLocation(right.getLocation());
      isPreferred = false;
    }
    else
      isPreferred = true;

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
