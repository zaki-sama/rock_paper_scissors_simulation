public class RunSimulation {

  public static void main(String... args) {
    Game world = new Game(9);
    int sceneSize = GameConstants.GAME_SIZE;
    world.bigBang(sceneSize, sceneSize, 0.01);
  }
}
