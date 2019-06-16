package game;

public class Game implements GameTAD {
  public Game() {}

  public void init() {
    this.show("\n\n -- GAME INITIZALIZED --\n\n");
  }
  public void show(String message) {
    System.out.print(message);
  }
  public void reset() {
    this.close();
    this.init();
  }
  public void close() {
    System.out.flush();
  }
}