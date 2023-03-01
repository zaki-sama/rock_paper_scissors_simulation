import java.util.*;
import java.util.function.*;

public class Game {
  private GameObject[] objects;

  Game(int num) {
    generateNRandomObjects(num);
  }

  private void generateNRandomObjects(int num) {
    GameObject[] objects = new GameObject[num];
    for(int i = 0; i < num; i++) {
      int random = new Random().nextInt(3);
      switch (random) {
        case 0: objects[i] = new Rock();
        case 1: objects[i] = new Paper();
        case 2: objects[i] = new Scissors();
      }
    }
    this.objects = objects;
  }

  private boolean gameOver() {
    GameObject check = objects[0];
    for(GameObject obj: this.objects) {
      if(!check.sameAs(obj)) {
        return false;
      }
    }
    return false;
  }

  public void runSimulation() {
    while(!gameOver()) {
      this.moveObjects();
      this.checkObjects();
    }
    System.out.println(this.objects[0].getType().toString());
  }

  private void checkObjects() {
    for(GameObject obj: this.objects) {
      obj.update(this.objects);
    }
  }

  private void moveObjects() {
    for(GameObject obj: this.objects) {
      obj.move();
    }
  }
}
