import java.util.*;

public abstract class GameObject {

  public enum ObjectType {
    Rock, Paper, Scissors;
  }
  private ObjectType beats;
  private ObjectType beatBy;
  private double x;
  private double y;
  //private Random rand;

  GameObject(ObjectType beats, ObjectType beatBy) {
    this.beats = beats;
    this.beatBy = beatBy;
    this.x = new Random().nextInt(GameConstants.GAME_SIZE);
    this.y = new Random().nextInt(GameConstants.GAME_SIZE);
  }

  public void update(GameObject[] objects) {

  }

  public void move() {
    double xMove = -1 + (1 - (-1)) * new Random().nextDouble();
    double yMove = -1 + (1 - (-1)) * new Random().nextDouble();
    this.x += xMove;
    this.y += yMove;
  }

  public abstract ObjectType getType();

  private boolean beats(GameObject beats) {
    return (this.beats.equals(beats.getType()));
  }

  private boolean beatBy(GameObject beatBy) {
    return (this.beatBy.equals(beatBy.getType()));
  }

  public boolean sameAs(GameObject obj) {
    return (this.getType().equals(obj.getType()));
  }

}
