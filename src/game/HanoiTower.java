package game;
import lists.Pile;
import java.security.InvalidParameterException;
import java.util.*;

public class HanoiTower extends Game {
  private static int TOTAL_STICKS = 3;
  private static int MAX_DISKS = 7;
  private static int MIN_DISKS = 3;
  private int totalDisks;
  private Pile[] sticks;

  private class Disk implements Comparable<Disk> {
    private int size;
    public Disk(int size) { this.size = size; }
    public int getSize() { return size; }
    public String toString() {
      return Integer.toString(this.getSize());
    }
    public int compareTo(Disk disk) { 
      if (this.getSize() == disk.getSize()) return 0;
      else return -1;
    }
  }

  public HanoiTower(int totalDisks) {
    super();
    super.init();
    if (totalDisks > MAX_DISKS || totalDisks < MIN_DISKS) {
      throw new InvalidParameterException("Total disks must be in range of "+MIN_DISKS+".."+MAX_DISKS+".");
    }
    this.totalDisks = totalDisks;
    this.setup();
  }

  public void init() {
    String layout = this.getLayout();
    super.show(layout);
  }

  public void setup() {
    this.sticks = new Pile[TOTAL_STICKS];
    for (int i=0; i < TOTAL_STICKS; i++) { this.sticks[i] = new Pile(); }
    for (int i=this.totalDisks; i > 0; i--) {this.sticks[0].push(new Disk(i));}
  }

  public String getLayout() {
    StringBuilder layout = new StringBuilder();
    String splitter = "-------";
    for (int i = 0; i < this.totalDisks; i++) {
      for (int j = 0; j < TOTAL_STICKS; j++) {
        if (j != 0) layout.append("      ");
        else layout.append("  ");
        Disk disk = (Disk) sticks[j].pop();
        if (disk == null) layout.append("|");
        else layout.append(disk.toString());
      }
      layout.append("\n");
    }
    for (int i= TOTAL_STICKS; i > 0; i--) {layout.append(splitter);}
    layout.append("\n  ");
    int firstChar = 65;
    for (int i= TOTAL_STICKS; i > 0; i--) {
      layout.append((char) firstChar++);
      layout.append("      ");
    }
    layout.append("\n");
    return layout.toString();
  }

}