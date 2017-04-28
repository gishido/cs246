package prove02;

import java.awt.Color;
import java.util.Random;

/**
 * Created by thesh on 4/28/2017.
 */
public class Zombie extends Creature implements Movable, Aggressor {
  Random _rand;

  public Zombie() {
    _rand = new Random();
    _health = 1;
  }
  public void attack(Creature target) {
    // Zombies attack everything but plants. Zombies inflict 10 damage
    if(target instanceof Creature) {
      target.takeDamage(10);
      _health++;
    }
  }


  public void move() {
    // Choose a random direction each time move() is called.
    switch(_rand.nextInt(4)) {
      case 0:
        _location.x++;
        break;
      case 1:
        _location.x--;
        break;
/*      case 2:
        _location.y++;
        break;
      case 3:
        _location.y--;
        break;*/
      default:
        break;
    }
  }

  public Color getColor() {
    return new Color(0, 102, 255);
  }

  public Boolean isAlive() {
    return _health > 0;
  }

  public Shape getShape() {
    return Shape.Square;
  }

}
