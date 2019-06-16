package game;
import lists.Pile;

public class HanoiTower extends Game {
  private int totalDisks;

  public HanoiTower(int totalDisks) {
    this.totalDisks = totalDisks;
  }

  public void init() {
    StringBuilder layout = new StringBuilder();
    for (int i=0; i < this.totalDisks; i++) {
      layout.append("  |      |      |\n");
    } 
    layout.append("-------------------\n");
    layout.append("  A      B      C\n");
    System.out.println(layout.toString());
  }
}