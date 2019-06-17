import java.util.Scanner;

import game.*;
public class Main {
  public static void main(String[] args) {
    
    HanoiTower game = new HanoiTower();
    game.init();
    while(!game.hasWon()) {
      game.next();
    }
    
  }
}