public class Paper extends GameObject{

  Paper() {
    super(ObjectType.Rock, ObjectType.Scissors);
  }

  @Override
  public ObjectType getType() {
    return ObjectType.Paper;
  }
}
