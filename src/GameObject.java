import java.awt.*;
import java.util.*;

import javalib.worldimages.*;

public class GameObject {

  public enum ObjectType {
    Rock, Paper, Scissors
  }
  private ObjectType type;
  private ObjectType beatBy;
  private double x;
  private double y;
  private double xMove;
  private double yMove;
  //private Random rand;

  GameObject(ObjectType type) {
    this.type = type;
    this.calculateBeatBy();
    this.x = new Random().nextInt(GameConstants.GAME_SIZE);
    this.y = new Random().nextInt(GameConstants.GAME_SIZE);

    int moveBy = 5;
    this.xMove = -moveBy + (moveBy - (-moveBy)) * new Random().nextDouble();
    this.yMove = -moveBy + (moveBy - (-moveBy)) * new Random().nextDouble();
  }

  //public methods
  public WorldImage draw() {
    String text = "";
    if(this.type == ObjectType.Rock) {
      text = "R";
    }
    if(this.type == ObjectType.Paper) {
      text = "P";
    }
    if(this.type == ObjectType.Scissors) {
      text = "S";
    }
    WorldImage img = new FromFileImage("paper.png");
    return new TextImage(text, 20.0, Color.BLACK);

  }

  public int getX() {
    return (int) this.x;
  }

  public int getY() {
    return (int) this.y;
  }

  private int assignRandom() {
    if(new Random().nextInt(1) == 0) {
      return 5;
    } else {
      return -5;
    }
  }

  public void check(GameObject[] objects) {
    for(int i = 0; i < objects.length; i++) {
      GameObject otherObj = objects[i];
      if(this.touching(otherObj) && this.beatBy(otherObj)) {
        this.updateTo(otherObj.type);
      }
    }
  }

  public void move() {
    if(willHitTopOrBottom()) {
      yMove = -yMove;
    }
    if(willHitLeftOrRight()) {
      xMove = -xMove;
    }
    else {
      this.x += xMove;
      this.y += yMove;
    }
  }

  private boolean willHitLeftOrRight() {
    return ((x + xMove) < 0 || (x + xMove) > GameConstants.GAME_SIZE);
  }

  private boolean willHitTopOrBottom() {
    return ((y + yMove) < 0 || (y + yMove) > GameConstants.GAME_SIZE);
  }

  public ObjectType getType() {
    return this.type;
  }

  public boolean sameAs(GameObject obj) {
    return (this.getType().equals(obj.getType()));
  }

  //private methods

  private void updateTo(ObjectType newType) {
    this.type = newType;
    this.calculateBeatBy();
  }

  private boolean beatBy(GameObject beatBy) {
    return (this.beatBy.equals(beatBy.getType()));
  }

  private boolean touching(GameObject otherObj) {
    double absXDiff = Math.abs(this.x - otherObj.x);
    double absYDiff = Math.abs(this.y - otherObj.y);
    return (absXDiff <= 10) && (absYDiff <= 10);
  }

  private void calculateBeatBy() {
    if(this.type.equals(ObjectType.Rock)) {
      this.beatBy = ObjectType.Paper;
    } else if(this.type.equals(ObjectType.Paper)) {
      this.beatBy = ObjectType.Scissors;
    } else {
      this.beatBy = ObjectType.Rock;
    }
  }

}
