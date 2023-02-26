import java.util.*;

public abstract class GameObject {
  public enum ObjectType {
    Rock, Paper, Scissors;
  }
  private ObjectType title;
  private ObjectType beats;
  private ObjectType beatBy;
  private int x;
  private int y;
  //private Random rand;

  GameObject(ObjectType title, ObjectType beats, ObjectType beatBy) {
    this.title = title;
    this.beats = beats;
    this.beatBy = beatBy;
    this.x = new Random().nextInt(Constants.GAME_SIZE);
    this.y = new Random().nextInt(Constants.GAME_SIZE);
  }


}
