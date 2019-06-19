package game;
import lists.Pile;
import java.security.InvalidParameterException;
import java.util.*;

public class HanoiTower extends Game {
  private final static int TOTAL_STICKS = 3;
  private final static int MAX_DISKS = 7;
  private final static int MIN_DISKS = 3;
  private int totalDisks;
  private int totalMoves = 0;
  private Pile<Disk>[] sticks;

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

  public HanoiTower() {
    super();
    super.init();
  }

  public void init() {
    int totalDisks = Integer.parseInt(super.ask("\nChoose a number of disks (range 3..7): "));
    if (!this.isValidAmoutOfDisks(totalDisks)) throw new InvalidParameterException("Total disks must be in range of "+MIN_DISKS+".."+MAX_DISKS+".");
    this.totalDisks = totalDisks;
    this.setup();
    super.show(this.getLayout());
  }

  public void setup() {
    this.sticks = (Pile<Disk>[]) new Pile[TOTAL_STICKS];
    for (int i=0; i < TOTAL_STICKS; i++) { this.sticks[i] = new Pile<Disk>(); }
    for (int i=this.totalDisks; i > 0; i--) {this.sticks[0].push(new Disk(i));}
  }

  public String getLayout() {
    StringBuilder layout = new StringBuilder();
    String splitter = "-------";
    Pile<Disk>[] auxSticks = (Pile<Disk>[]) new Pile[TOTAL_STICKS];
    for (int i = 0; i < TOTAL_STICKS; i++) { auxSticks[i] = this.sticks[i].copy();}

    for (int i = 0; i < this.totalDisks; i++) {
      for (int j = 0; j < TOTAL_STICKS; j++) {
        if (j != 0) layout.append("      ");
        else layout.append("  ");
        
        if (auxSticks[j].size() >= this.totalDisks - i) {
          Disk disk = (Disk) auxSticks[j].pop();
          layout.append(disk.toString());
        } else {
          layout.append("|");
        }
      }
      if (i == 1) layout.append("      Total Moves: "+this.totalMoves);
      layout.append("\n");
    }
    for (int i= TOTAL_STICKS; i > 0; i--) {layout.append(splitter);}
    layout.append("\n  ");
    int firstChar = 65;
    for (int i= TOTAL_STICKS; i > 0; i--) {
      layout.append((char) firstChar++);
      layout.append("      ");
    }
    layout.append("\n\n\n\n");
    return layout.toString();
  }

  public void moveDisk(int fromStick, int toStick) {
    this.totalMoves++;
    Disk diskToMove = (Disk) this.sticks[fromStick].top();
    Disk topDisk = (Disk) this.sticks[toStick].top();

    if (isValidMove(diskToMove, topDisk)) {
      this.sticks[toStick].push(this.sticks[fromStick].pop());
      super.clear();
      if (hasWon()) super.show("\n\n\n ---- YOU WON! yey :) -----\n\n\n");
      else super.show(this.getLayout());
    } else {
      this.handleWrongMove();
    }
  }

  public void next() {
    int fromStick = (int) super.ask("Move stick from (A, B, C, ...): ").toUpperCase().charAt(0);
    int toStick = (int) super.ask("To stick (A, B, C, ...): ").toUpperCase().charAt(0);
    boolean validFromStick = fromStick-65 >= 0 && fromStick - 65 < TOTAL_STICKS;
    boolean validToStick = toStick-65 >= 0 && toStick - 65 < TOTAL_STICKS;

    if (!validFromStick || !validToStick) this.handleWrongMove();
    else this.moveDisk(fromStick - 65, toStick - 65);
  }

  private boolean isValidMove(Disk diskToMove, Disk topDisk) {
    return diskToMove != null && (topDisk == null || diskToMove.getSize() < topDisk.getSize());
  }

  private boolean isValidAmoutOfDisks(int totalDisks) {
    return totalDisks <= MAX_DISKS && totalDisks >= MIN_DISKS;
  }
  public boolean hasWon() {
    Pile<Disk> lastStick = this.sticks[TOTAL_STICKS-1];
    return lastStick.size() == this.totalDisks;
  }

  private void handleWrongMove() {
      super.clear();
      super.show("Invalid move! Try again!\n\n");
      super.show(this.getLayout());
  }
}