package game;

public interface GameTAD<T> {
  public void init();
  public void show(String message);
  public void reset();
  public void close();
} 