package ru.jft.secondProgram;

/**
 * Created by Home on 09.04.2016.
 */
public class Point {
  private int x;
  private int y;

  public Point(int x, int y) {
    setX(x);
    setY(y);
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getY() {
    return y;
  }

  public int getX() {
    return x;
  }

  public double distance(Point p2) {
    return Math.sqrt(Math.pow((p2.x - this.x), 2) + Math.pow((p2.y - this.y), 2));
  }
}
