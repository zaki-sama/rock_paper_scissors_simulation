public class Rock extends GameObject{

  Rock() {
    super(ObjectType.Scissors, ObjectType.Paper);
  }

  @Override
  public ObjectType getType() {
    return ObjectType.Rock;
  }
}
