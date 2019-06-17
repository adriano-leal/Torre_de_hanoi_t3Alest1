package game;
import java.util.Scanner;

public class Game implements GameTAD {
  private Scanner promptReader;
  public Game() {
    this.promptReader = new Scanner(System.in);
  }

  public void init() {
    this.clear();
    this.show("\n\n -- GAME INITIALIZED --\n\n");
  }
  public void show(String message) {
    System.out.print(message);
  }

  public String ask(String message) {
    System.out.print(message);
    return promptReader.next();
  }

  public void reset() {
    this.clear();
    this.init();
  }
  public void clear() {
    for (int clear = 0; clear < 100; clear++) {
      System.out.println("\b");
    }
  }
}