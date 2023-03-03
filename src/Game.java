import java.awt.*;

import javalib.impworld.*;
import javalib.worldimages.*;

public class Game extends World {
  private GameObject[] objects;

  public Game(int num) {
    if(!(num % 3 == 0)) {
      throw new IllegalArgumentException("Number of objects must be divisible by 3");
    }
    //generateNRandomObjects(num);
    generateObjects(num);
  }

  private void generateObjects(int num) {
    GameObject[] objects = new GameObject[num];
    int eachType = num / 3;
    int count = 0;
    for(int i = 0; i < eachType; i++) {
      objects[count] = new GameObject(GameObject.ObjectType.Rock);
      count++;
    }
    for(int i = 0; i < eachType; i++) {
      objects[count] = new GameObject(GameObject.ObjectType.Paper);
      count++;
    }
    for(int i = 0; i < eachType; i++) {
      objects[count] = new GameObject(GameObject.ObjectType.Scissors);
      count++;
    }
    this.objects = objects;
  }

//  private void generateNRandomObjects(int num) {
//    GameObject[] objects = new GameObject[num];
//    for(int i = 0; i < num; i++) {
//      int random = new Random().nextInt(3);
//      if(random == 0) {
//        objects[i] = new GameObject(GameObject.ObjectType.Rock);
//      } else if(random == 1) {
//        objects[i] = new GameObject(GameObject.ObjectType.Paper);
//      } else {
//        objects[i] = new GameObject(GameObject.ObjectType.Scissors);
//      }
//    }
//    this.objects = objects;
//  }

  private boolean gameOver() {
    GameObject check = objects[0];
    for(GameObject obj: this.objects) {
      if(!check.sameAs(obj)) {
        return false;
      }
    }
    return true;
  }

  private void checkObjects() {
    for(GameObject obj: this.objects) {
      obj.check(this.objects);
    }
  }

  private void moveObjects() {
    for(GameObject obj: this.objects) {
      obj.move();
    }
  }

  @Override
  public WorldScene makeScene() {
    WorldScene scene = new WorldScene(GameConstants.GAME_SIZE, GameConstants.GAME_SIZE);
    for(GameObject obj: this.objects) {
      scene.placeImageXY(obj.draw(), obj.getX(), obj.getY());
    }
    return scene;
  }
  //🪨📄✂️

  @Override
  public void onTick() {
    if(!this.gameOver()) {
      this.moveObjects();
      this.checkObjects();
    }
    else {
      this.endOfWorld("Winner: " + objects[0].getType());
    }
  }

  @Override
  public WorldScene lastScene(String s) {
    int size = GameConstants.GAME_SIZE;
    WorldScene scene = new WorldScene(size, size);
    WorldImage text = new TextImage(s, 20, Color.BLACK);
    scene.placeImageXY(text, size/2, size/2);
    return scene;
  }
}
