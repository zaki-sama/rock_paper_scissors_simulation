public class Scissors extends GameObject{
  Scissors() {
    super(ObjectType.Paper, ObjectType.Rock);
  }

  @Override
  public ObjectType getType() {
    return ObjectType.Scissors;
  }
}
